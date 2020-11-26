package com.zemrow.messenger.controller;

import com.zemrow.messenger.dto.Triplet;
import com.zemrow.messenger.dto.UserInsertRequest;
import com.zemrow.messenger.dto.UserInsertResponse;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.json.JsonMapper;
import com.zemrow.messenger.service.UserInfoService;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.CookieImpl;
import io.undertow.util.Headers;
import java.io.OutputStream;

/**
 * Регистрация пользователя.
 *
 * @author Alexandr Polyakov on 2020.11.24
 */
public class UserInsertController extends AbstractController<UserInfoService> implements HttpHandler {

    private final JsonMapper jsonMapper;

    public UserInsertController(final JsonMapper jsonMapper, UserInfoService service) {
        super(service);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        if (exchange.isInIoThread()) {
            exchange.dispatch(this);
            return;
        }
        exchange.startBlocking();

        final UserInsertRequest request = jsonMapper.deserialize(UserInsertRequest.class, exchange.getInputStream());
        // TODO userId как параметр, если с таким id есть пытаться залогиниться и если логин не совпадает отправить клиенту ответ повтора нового id
        // позволит на стороне клиента повторять запросы если произошли сетевые ошибки и все-же получить ответ
        final Triplet<UserInfo, UserEntryPoint, UserSession> newUser = service.insert(request);
        final UserInsertResponse response = new UserInsertResponse();
        response.setToken(newUser.getV3().getToken());
        response.setUserId(newUser.getV1().getId());
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
    }
}
