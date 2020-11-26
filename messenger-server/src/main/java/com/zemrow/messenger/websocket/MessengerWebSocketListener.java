package com.zemrow.messenger.websocket;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.controller.AbstractController;
import com.zemrow.messenger.controller.ChatController;
import com.zemrow.messenger.controller.UserSessionController;
import com.zemrow.messenger.dto.AbstractScopeDto;
import com.zemrow.messenger.enums.OperationIdEnum;
import com.zemrow.messenger.enums.ResponseScopeEnum;
import com.zemrow.messenger.exception.NotAuthorizedException;
import com.zemrow.messenger.json.JsonMapper;
import com.zemrow.messenger.mq.ClusterMessaging;
import com.zemrow.messenger.mq.ClusterMessagingListener;
import com.zemrow.messenger.server.MessengerRout;
import io.undertow.server.handlers.Cookie;
import io.undertow.util.Cookies;
import io.undertow.util.Headers;
import io.undertow.websockets.WebSocketConnectionCallback;
import io.undertow.websockets.core.AbstractReceiveListener;
import io.undertow.websockets.core.BufferedTextMessage;
import io.undertow.websockets.core.CloseMessage;
import io.undertow.websockets.core.StreamSourceFrameChannel;
import io.undertow.websockets.core.WebSocketCallback;
import io.undertow.websockets.core.WebSocketChannel;
import io.undertow.websockets.core.WebSockets;
import io.undertow.websockets.spi.WebSocketHttpExchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class MessengerWebSocketListener extends AbstractReceiveListener implements WebSocketConnectionCallback,
        WebSocketCallback<RequestContext>, ClusterMessagingListener {

    private static final Logger log = LogManager.getLogger(MessengerWebSocketListener.class);

    //TODO вынести в настройку
    private static final int TIMEOUT = 10_000;
    // TODO
    private final JsonMapper jsonMapper;
    // TODO
    private final MessengerRout rout;
    // TODO
    private final UserSessionController userSessionController;
    // TODO
    private final ChatController chatController;
    // TODO
    private final UserToWebSocket userToWebSocket;
    // TODO
    private final ClusterMessaging clusterMessaging;

    //TODO
    public MessengerWebSocketListener(final JsonMapper jsonMapper, MessengerRout rout,
                                      UserSessionController userSessionController,
                                      final ChatController chatController,
                                      ClusterMessaging clusterMessaging) {
        this.jsonMapper = jsonMapper;
        this.rout = rout;
        this.userSessionController = userSessionController;
        this.chatController = chatController;
        this.clusterMessaging = clusterMessaging;
        this.userToWebSocket = new UserToWebSocket();
        clusterMessaging.subscribe(this);
    }

    //TODO
    @Override
    public void onConnect(WebSocketHttpExchange exchange, WebSocketChannel channel) {
        // Проверка сессии.
        final String token = getToken(exchange);
        log.debug("WebSocket open {}", token);
        try {
            final SessionStorage session = userSessionController.getSessionStorage(token);
            userToWebSocket.put(session.getUserId(), channel);
            // регистрируем слушателя сообщений (onFullTextMessage)
            channel.getReceiveSetter().set(this);
            channel.resumeReceives();
            channel.setAttribute(AbstractController.TOKEN, token);
        } catch (NotAuthorizedException e) {
            closeUnauthorized(channel, e);
        } catch (Exception e) {
            sendException(channel, e);
        }
    }

    //TODO
    @Override
    protected void onFullTextMessage(WebSocketChannel channel, BufferedTextMessage message) {
        // TODO проверить параллельную работу: клиент отправляет 2 сообщения и регистрирует время ответа каждого, сервер на все запросы вставляет задержку 5 сек, если итоговое время ~5 все хорошо, если ~10 надо переделать
        final String jsonStr = message.getData();
        final String token = (String) channel.getAttribute(AbstractController.TOKEN);
        log.debug("WebSocket receive {} {}", token, jsonStr);
        try {
            final Map request = jsonMapper.deserialize(jsonStr);
            final String operationIdStr = (String) request.remove(MessengerRout.OPERATION_ID);
            //TODO check enum
            final OperationIdEnum operationId = OperationIdEnum.valueOf(operationIdStr);
            final String requestId = (String) request.remove(MessengerRout.REQUEST_ID);
            final SessionStorage session = userSessionController.getSessionStorage(token);
            final AbstractScopeDto response = rout.receive(operationId, session, request);
            send(channel, operationId, requestId, response);
            //TODO log
        } catch (NotAuthorizedException e) {
            closeUnauthorized(channel, e);
        } catch (Exception e) {
            sendException(channel, e);
        }
    }

    //TODO
    private void sendText(WebSocketChannel channel, String message) {
        final String token = (String) channel.getAttribute(AbstractController.TOKEN);
        log.debug("WebSocket send {} {}", token, message);
        //TODO requestId
        WebSockets.sendText(message, channel, this, new RequestContext(System.currentTimeMillis()), TIMEOUT);
    }

    //TODO
    private void sendException(WebSocketChannel channel, Exception e) {
        log.warn("Error", e);
        // TODO привязка ошибки к запросу
        // TODO формат ошибки
        try {
            String error;
            // TODO
//            if (e instanceof MessengerException){
//                error=jsonMapper.serialize(e);
//            }else
            {
                final HashMap<String, String> json = new HashMap<>();
                json.put("status_code", "400");
                json.put("data", e.getMessage());
                json.put("operationId", "");
                error = jsonMapper.serialize(json);
            }
            sendText(channel, error);
        } catch (IOException ioException) {
            //TODO
            ioException.printStackTrace();
        }
    }

    //TODO
    private void closeUnauthorized(WebSocketChannel channel, NotAuthorizedException e) {
        // TODO сообщить об ошибке авторизации
        log.debug("WebSocket send close {}", e.getMessage());
        WebSockets.sendClose(CloseMessage.MSG_VIOLATES_POLICY, e.getMessage(), channel, null);
    }

    //TODO
    @Override
    protected void onClose(WebSocketChannel channel, StreamSourceFrameChannel frameChannel) throws IOException {
        log.debug("WebSocket close {}", channel.getAttribute(AbstractController.TOKEN));
        userToWebSocket.remove(channel);
        super.onClose(channel, frameChannel);
    }

    //TODO
    @Override
    protected void onError(WebSocketChannel channel, Throwable error) {
        log.debug("WebSocket error {}: {}", channel.getAttribute(AbstractController.TOKEN), error);
        userToWebSocket.remove(channel);
        super.onError(channel, error);
    }

    //TODO
    @Override
    public void complete(WebSocketChannel channel, RequestContext context) {
        long time = System.currentTimeMillis() - context.getStart();
        log.debug("WebSocket send complete {} ms", time);
        // TODO request log
    }

    //TODO
    @Override
    public void onError(WebSocketChannel channel, RequestContext context, Throwable throwable) {
        long time = System.currentTimeMillis() - context.getStart();
        log.debug("WebSocket send error {} ms {}", time, throwable);
        //TODO request log
    }

    //TODO
    public void send(WebSocketChannel channel, OperationIdEnum operationId, final String requestId, AbstractScopeDto response) {
        if (response != null) {
            if (response.getOperationId() == null) {
                response.setOperationId(operationId);
            }
            if (requestId != null && response.getRequestId() == null) {
                response.setRequestId(requestId);
            }
            // TODO scope required
            ResponseScopeEnum scope = response.getScope();
            if (scope == null) {
                scope = ResponseScopeEnum.REQUEST;
            }

            try {
                final String message = jsonMapper.serialize(response);

                switch (scope) {
                    case REQUEST:
                        sendText(channel, message);
                        break;
                    case USER:
                    case USER_CONTACT:
                    case CHAT:
                    case ALL:
                        final Long scopeObjectId = response.getTo();
                        onMessage(scope, scopeObjectId, message);
                        // отправить на другие сервера
                        // TODO проверить зацикливание
                        clusterMessaging.publish(scope, scopeObjectId, message);
                        break;
                }
            } catch (Exception e) {
                sendException(channel, e);
            }
        }
    }

    //TODO
    @Override
    public void onMessage(ResponseScopeEnum scope, Long scopeObjectId, String json) throws Exception {
        log.debug("ClusterMessaging onMessage {} {} {}", scope, scopeObjectId, json);
        switch (scope) {
            case USER: {
                final Long userId = scopeObjectId;
                sendText(userId, json);
            }
            break;
            case USER_CONTACT: {
                final Long parentUserId = scopeObjectId;
                //TODO
                // получить список пользователей
                //TODO
                final Set<Long> userIdSet = null;
                for (Long userId : userIdSet) {
                    sendText(userId, json);
                }
            }
            break;
            case CHAT: {
                final Long chatId = scopeObjectId;
                // получить список пользователей
                final List<Long> userIdSet = chatController.selectUserIdByChatId(chatId);
                for (Long userId : userIdSet) {
                    sendText(userId, json);
                }
            }
            break;
            case ALL:
                for (WebSocketChannel webSocketChannel : userToWebSocket.getChannels()) {
                    sendText(webSocketChannel, json);
                }
                break;
        }
    }

    /**
     * TODO
     * @param userId идентификатор пользователя
     * @param json сообщение
     */
    public void sendText(Long userId, String json) {
        final Set<WebSocketChannel> channelsByUserId = userToWebSocket.getChannelsByUserId(userId);
        if (channelsByUserId != null) {
            for (WebSocketChannel webSocketChannel : channelsByUserId) {
                sendText(webSocketChannel, json);
            }
        }
    }

    //TODO
    private String getToken(WebSocketHttpExchange exchange) {
        String token = null;
        final List<String> cookies = exchange.getRequestHeaders().get(Headers.COOKIE_STRING);
        final Map<String, Cookie> parseCookies = Cookies.parseRequestCookies(10, false, cookies);
        final Cookie tokenCookie = parseCookies.get(AbstractController.TOKEN);
        if (tokenCookie != null) {
            token = tokenCookie.getValue();
        }
        return token;
    }

    //================================ AUTO GENERATE ==============================
}
