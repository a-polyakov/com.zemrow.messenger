package com.zemrow.messenger.server;

import com.zemrow.messenger.controller.UserInsertController;
import com.zemrow.messenger.controller.UserSessionInsertController;
import com.zemrow.messenger.websocket.MessengerWebSocketListener;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;
import io.undertow.util.Headers;
import io.undertow.websockets.WebSocketProtocolHandshakeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.06.17
 */
public class WebServer implements Closeable {

    protected Logger logger = LoggerFactory.getLogger(WebServer.class);

    private final Undertow undertow;

    public WebServer(ServerConfiguration serverConfiguration, UserInsertController userInsertController,
                     UserSessionInsertController userSessionInsertController, MessengerWebSocketListener webSocketListener) {
        //TODO RequestLog
        final RoutingHandler routingHandler = Handlers.routing().post("/api/v1/user", userInsertController)
                .post("/api/v1/userSession", userSessionInsertController)
                //TODO получение файла
                // Обработка сообщений через websocket
                .get("/websocket", new WebSocketProtocolHandshakeHandler(webSocketListener));
        // Статический контент
        final ResourceHandler staticHandler;
        if (serverConfiguration.getWebServerStaticDir() != null) {
            staticHandler = Handlers.resource(new FileResourceManager(serverConfiguration.getWebServerStaticDir()));
        } else {
            staticHandler = Handlers.resource(new ClassPathResourceManager(WebServer.class.getClassLoader(), "webapp"));
        }
        staticHandler.setWelcomeFiles("index.html");
        routingHandler.get("/*", staticHandler);

        // TODO
        routingHandler.setFallbackHandler(new HttpHandler() {
            @Override
            public void handleRequest(HttpServerExchange exchange) throws Exception {
                exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                exchange.getResponseSender().send("Hello World 404");
            }
        });

        undertow = Undertow.builder().addHttpListener(serverConfiguration.getWebServerPort(), "localhost"/*TODO*/)
                .setHandler(routingHandler).build();
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
