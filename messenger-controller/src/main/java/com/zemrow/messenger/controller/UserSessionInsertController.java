package com.zemrow.messenger.controller;

import com.zemrow.messenger.dto.Pair;
import com.zemrow.messenger.dto.UserSessionInsertRequest;
import com.zemrow.messenger.dto.UserSessionInsertResponse;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.exception.NotAuthorizedException;
import com.zemrow.messenger.json.JsonMapper;
import com.zemrow.messenger.service.UserSessionService;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.CookieImpl;
import io.undertow.util.Headers;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * Вход в систему.
 *
 * @author Alexandr Polyakov on 2020.11.24
 */
public class UserSessionInsertController extends AbstractController<UserSessionService> implements HttpHandler {

    final private JsonMapper jsonMapper;

    public UserSessionInsertController(final JsonMapper jsonMapper, UserSessionService service) {
        super(service);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        // Вход в систему.
        if (exchange.isInIoThread()) {
            exchange.dispatch(this);
            return;
        }

        exchange.startBlocking();
        final UserSessionInsertRequest request = jsonMapper.deserialize(UserSessionInsertRequest.class, exchange.getInputStream());
        try {
            final Pair<UserEntryPoint, UserSession> newUserSession = service.insert(request);
            if (newUserSession == null) {
                // TODO
                throw new NotAuthorizedException("Неверно задан логин или пароль");
            }
            final UserSessionInsertResponse response = new UserSessionInsertResponse();
            response.setUserId(newUserSession.getV1().getUserId());
            response.setToken(newUserSession.getV2().getToken());

            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, MIME_TYPE_JSON);
            final CookieImpl cookie = new CookieImpl(TOKEN, response.getToken());
            cookie.setHttpOnly(true);
            //TODO
            cookie.setDomain("localhost");
            cookie.setPath("/");
            exchange.setResponseCookie(cookie);
            try (OutputStream outputStream = exchange.getOutputStream()) {
                jsonMapper.serialize(response, outputStream);
            }
        } catch (NotAuthorizedException e) {
            // TODO формат ошибки
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, MIME_TYPE_JSON);
            exchange.setStatusCode(HttpURLConnection.HTTP_UNAUTHORIZED);
            exchange.getResponseSender().send(e.getMessage());
        }
    }
}
