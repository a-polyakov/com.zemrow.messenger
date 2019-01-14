package com.zemrow.messenger.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemrow.messenger.AppConfiguration;
import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.web.websocket.MessengerWebSocketListener;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.CookieImpl;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.util.Headers;
import io.undertow.util.Methods;
import io.undertow.websockets.WebSocketProtocolHandshakeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.net.HttpURLConnection;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.06.17
 */
public class WebServer implements Closeable {

    protected Logger logger = LoggerFactory.getLogger(WebServer.class);

    private final Undertow undertow;

    public WebServer(AppConfiguration appConfiguration, ObjectMapper jsonMapper, MessengerRout rout, MessengerWebSocketListener webSocketListener) {
        final WebSocketProtocolHandshakeHandler webSocketHandler = new WebSocketProtocolHandshakeHandler(webSocketListener);
        //TODO RequestLog
        final PathHandler handler = Handlers.path()
                .addPrefixPath("/api/user", new HttpHandler() {
                    @Override
                    public void handleRequest(HttpServerExchange exchange) throws Exception {
                        if (Methods.POST.equals(exchange.getRequestMethod())) {
                            // Регистрация пользователя.
                            if (exchange.isInIoThread()) {
                                exchange.dispatch(this);
                                return;
                            }

                            exchange.startBlocking();
                            final ObjectNode request = (ObjectNode) jsonMapper.readTree(exchange.getInputStream());
                            final JsonNode result = rout.receive(EventEnum.user_insert, request);
                            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                            final CookieImpl cookie = new CookieImpl(UserSessionConst.TOKEN, result.get(UserSessionConst.TOKEN).asText());
                            cookie.setHttpOnly(true);
                            //TODO
                            cookie.setDomain("localhost");
                            cookie.setPath("/");
                            exchange.setResponseCookie(cookie);
                            exchange.getResponseSender().send(result.toString());
                        } else {
                            //TODO
                            System.out.println(HttpURLConnection.HTTP_BAD_REQUEST);
                        }
                    }
                })
                .addPrefixPath("/api/userSession", new HttpHandler() {
                    @Override
                    public void handleRequest(HttpServerExchange exchange) throws Exception {
                        if (Methods.POST.equals(exchange.getRequestMethod())) {
                            // Вход в сисему.
                            if (exchange.isInIoThread()) {
                                exchange.dispatch(this);
                                return;
                            }

                            exchange.startBlocking();
                            final ObjectNode request = (ObjectNode) jsonMapper.readTree(exchange.getInputStream());
                            final ObjectNode result = rout.receive(EventEnum.userSession_insert, request);
                            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                            final CookieImpl cookie = new CookieImpl(UserSessionConst.TOKEN, result.get(UserSessionConst.TOKEN).asText());
                            cookie.setHttpOnly(true);
                            //TODO
                            cookie.setDomain("localhost");
                            cookie.setPath("/");
                            exchange.setResponseCookie(cookie);
                            exchange.getResponseSender().send(result.toString());
                        } else {
                            //TODO
                            System.out.println(HttpURLConnection.HTTP_BAD_REQUEST);
                        }
                    }
                })
                // TODO file
                // Обработка сообщений через websocket
                .addPrefixPath("/websocket", webSocketHandler)
                // Статический контент
                //TODO
//                .addPrefixPath("/", Handlers.resource(new ClassPathResourceManager(WebServer.class.getClassLoader(), "webapp")).addWelcomeFiles("webapp/index.html"));
                .addPrefixPath("/", Handlers.resource(new FileResourceManager(new File("C:\\dev\\zemrow\\com.zemrow.messenger\\src\\main\\resources\\webapp"))).addWelcomeFiles("index.html"));
        undertow = Undertow.builder()
                .addHttpListener(appConfiguration.getWebServerPort(), "localhost"/*TODO*/)
                .setHandler(handler)
                .build();

        undertow.start();
    }

    @Override
    public void close() {
        if (undertow != null) {
            try {
                undertow.stop();
            } catch (Throwable e) {
                logger.error("Error undertow stop", e);
            }
        }
    }
//================================ AUTO GENERATE ==============================
}
