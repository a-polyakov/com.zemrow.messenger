package com.zemrow.messenger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.abstracts.Pair;
import com.zemrow.messenger.exception.NotAuthorizedException;
import com.zemrow.messenger.service.UserSessionService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.10
 */
public class UserSessionController extends AbstractController {

    private final ObjectMapper jsonMapper;

    private final UserSessionService userSessionService;

    public UserSessionController(ObjectMapper jsonMapper, UserSessionService userSessionService) {
        this.jsonMapper = jsonMapper;
        this.userSessionService = userSessionService;
    }

    /**
     * Вход в сисему.
     */
    public ObjectNode insert(ObjectNode json) {
        final String username = json.get("username").asText();
        final String password = json.get("password").asText();
        final Pair<UserEntryPoint, UserSession> newUserSession = userSessionService.insert(username, password);
        final ObjectNode result = jsonMapper.createObjectNode();
        result.set(UserSessionConst.TOKEN, new TextNode(newUserSession.getV2().getToken()));
        result.set("userId", new TextNode(newUserSession.getV1().getUserId().toString()));
        return result;
    }

    /**
     * Выход из системы (только текущую сессию).
     *
     * @param session TODO
     * @param json    TODO
     */
    public void delete(SessionStorage session, ObjectNode json) {
        userSessionService.delete(session);
        throw new NotAuthorizedException(/*TODO*/"User logout");
    }

    /**
     * Создась сессию пользователя
     *
     * @param token Идентификатор сессии.
     * @return Сессия.
     */
    public SessionStorage getSessionStorage(String token) {
        return userSessionService.getSessionStorage(token);
    }
}
