package com.zemrow.messenger.web.websocket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.RoutConst;
import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.controller.UserSessionController;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.exception.NotAuthorizedException;
import com.zemrow.messenger.web.EventEnum;
import com.zemrow.messenger.web.MessengerRout;
import com.zemrow.messenger.web.ResponseScopeEnum;
import io.undertow.server.handlers.Cookie;
import io.undertow.util.Cookies;
import io.undertow.util.Headers;
import io.undertow.websockets.WebSocketConnectionCallback;
import io.undertow.websockets.core.*;
import io.undertow.websockets.spi.WebSocketHttpExchange;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class MessengerWebSocketListener extends AbstractReceiveListener implements WebSocketConnectionCallback, WebSocketCallback<Long> {

    private static final int TIMEOUT = 10_000;

    private final ObjectMapper jsonMapper;
    private final MessengerRout rout;

    private final UserSessionController userSessionController;

    private final Map<WebSocketChannel, Long> connectToUser;

    public MessengerWebSocketListener(ObjectMapper jsonMapper,
                                      MessengerRout rout,
                                      UserSessionController userSessionController) {
        this.jsonMapper = jsonMapper;
        this.rout = rout;
        this.userSessionController = userSessionController;
        connectToUser = new HashMap<>();
    }

    @Override
    public void onConnect(WebSocketHttpExchange exchange, WebSocketChannel channel) {
        // Проверка сессии.
        final String token = getToken(exchange);
        final SessionStorage session = userSessionController.getSessionStorage(token);
        if (session != null) {
            connectToUser.put(channel, session.getUserId());
            // регистрируем слушателя сообщений (onFullTextMessage)
            channel.getReceiveSetter().set(this);
            channel.resumeReceives();
            channel.setAttribute(UserSessionConst.TOKEN, token);
        } else {
            // TODO сообщить об ошибке авторизации
            WebSockets.sendClose(HttpURLConnection.HTTP_UNAUTHORIZED, "asdfghjkl;", channel, null);
        }
    }

    @Override
    protected void onFullTextMessage(WebSocketChannel channel, BufferedTextMessage message) {
        // TODO проверить паралельную работу: клиент отправляет 2 сообщения и регистрирует время ответа каждого, сервер на все запросы вставляет задержку 5 сек, если итоговое время ~5 все хорошо, если ~10 надо переделать
        final String jsonStr = message.getData();
        try {
            ObjectNode json = (ObjectNode) jsonMapper.readTree(jsonStr);
            final String eventIdStr = json.remove(RoutConst.EVENT_ID).asText();
            //TODO check enum
            final EventEnum eventId = EventEnum.valueOf(eventIdStr);
            final String requestId = json.remove(RoutConst.REQUEST_ID).asText();
            final String token = (String) channel.getAttribute(UserSessionConst.TOKEN);
            final SessionStorage sessionStorage = userSessionController.getSessionStorage(token);
            final ObjectNode response = rout.receive(eventId, sessionStorage, json);
            send(channel, eventId, requestId, response);
            //TODO log
        } catch (NotAuthorizedException e) {
            WebSockets.sendClose(HttpURLConnection.HTTP_UNAUTHORIZED, e.getMessage(), channel, null);
        } catch (IOException e) {
            WebSockets.sendText("Content that does not conform to JSON syntax as per specification: " + jsonStr, channel, this, System.currentTimeMillis(), TIMEOUT);
        }
    }

    @Override
    protected void onClose(WebSocketChannel channel, StreamSourceFrameChannel frameChannel) throws IOException {
        //TODO log
        connectToUser.remove(channel);
        super.onClose(channel, frameChannel);
    }

    @Override
    protected void onError(WebSocketChannel channel, Throwable error) {
        //TODO log
        connectToUser.remove(channel);
        super.onError(channel, error);
    }

    @Override
    public void complete(WebSocketChannel channel, Long context) {
        long time = System.currentTimeMillis() - context;
        //TODO
        System.out.println("com.zemrow.messenger.web.websocket.MessengerWebSocketListener.complete send " + time + " ms");
    }

    @Override
    public void onError(WebSocketChannel channel, Long context, Throwable throwable) {
        long time = System.currentTimeMillis() - context;
        //TODO
        System.out.println("ping error");
    }

    public void send(WebSocketChannel channel, EventEnum eventId, final String requestId, ObjectNode json) {
        if (json != null) {
            if (json.get(RoutConst.EVENT_ID) == null) {
                json.set(RoutConst.EVENT_ID, new TextNode(eventId.name()));
            }
            if (requestId != null && json.get(RoutConst.REQUEST_ID) == null) {
                json.set(RoutConst.REQUEST_ID, new TextNode(requestId));
            }
            final JsonNode scopeStr = json.remove(RoutConst.SCOPE);

            ResponseScopeEnum scope = (scopeStr != null) ? ResponseScopeEnum.valueOf(scopeStr.asText()) : ResponseScopeEnum.REQUEST;
            final String message = json.toString();
            switch (scope) {
                case REQUEST:
                    WebSockets.sendText(message, channel, this, System.currentTimeMillis(), TIMEOUT);
                    break;
                case USER: {
                    long userId = json.get(AbstractController.ATTR_USER_ID).asLong();
                    for (WebSocketChannel webSocketChannel : allByUserId(userId)) {
                        WebSockets.sendText(message, webSocketChannel, this, System.currentTimeMillis(), TIMEOUT);
                    }
                    // TODO отправить на другие сервера
                }
                break;
                case USER_CONTACT: {
                    long userId = json.get(AbstractController.ATTR_USER_ID).asLong();
                    //TODO
                }
                break;
                case CHAT: {
                    long chatId = json.get(AbstractController.ATTR_CHAT_ID).asLong();
                    //TODO
                }
                break;
                case ALL:
                    for (WebSocketChannel webSocketChannel : connectToUser.keySet()) {
                        WebSockets.sendText(message, webSocketChannel, this, System.currentTimeMillis(), TIMEOUT);
                    }
                    // TODO отправить на другие сервера
                    break;
            }
        }
    }

    private Iterable<WebSocketChannel> allByUserId(long userId) {
        List<WebSocketChannel> result = new ArrayList<>();
        for (Map.Entry<WebSocketChannel, Long> entry : connectToUser.entrySet()) {
            if (userId == entry.getValue()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    @Nullable
    private String getToken(WebSocketHttpExchange exchange) {
        String token = null;
        final List<String> cookies = exchange.getRequestHeaders().get(Headers.COOKIE_STRING);
        final Map<String, Cookie> parseCookies = Cookies.parseRequestCookies(10, false, cookies);
        final Cookie tokenCookie = parseCookies.get(UserSessionConst.TOKEN);
        if (tokenCookie != null) {
            token = tokenCookie.getValue();
        }
        return token;
    }

//================================ AUTO GENERATE ==============================
}
