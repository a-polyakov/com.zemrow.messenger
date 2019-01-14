package com.zemrow.messenger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.RoutConst;
import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.abstracts.Triplet;
import com.zemrow.messenger.service.UserService;
import com.zemrow.messenger.web.ResponseScopeEnum;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserController extends AbstractController {

    private final ObjectMapper jsonMapper;

    private final UserService service;

    public UserController(ObjectMapper jsonMapper, UserService service) {
        this.jsonMapper = jsonMapper;
        this.service = service;
    }

    /**
     * Регистрация пользователя.
     */
    public ObjectNode insert(ObjectNode json) {
        final String username = json.get("username").asText();
        final String password = json.get("password").asText();
        final Triplet<User, UserEntryPoint, UserSession> newUser = service.insert(username, password);
        final ObjectNode result = jsonMapper.createObjectNode();
        result.set(UserSessionConst.TOKEN, new TextNode(newUser.getV3().getToken()));
        result.set("userId", new TextNode(newUser.getV1().getId().toString()));
        return result;
    }

    /**
     * Получить информацию о текущем пользователе.
     */
    public ObjectNode current(SessionStorage session, ObjectNode json) {
        final User user = service.select(session, null);
        final ObjectNode result = jsonMapper.createObjectNode();
        result.set(RoutConst.SCOPE, new TextNode(ResponseScopeEnum.REQUEST.name()));
        result.set("userId", new TextNode(user.getId().toString()));
        result.set("userName", new TextNode(user.getName()));
        // TODO задание над которым работает пользователь
        return result;
    }

    /**
     * Получить информацию о пользователе.
     */
    public ObjectNode select(SessionStorage session, ObjectNode json) {
        final Long userId = json.get("userId").asLong();
        final User user = service.select(session, userId);
        final ObjectNode result = jsonMapper.createObjectNode();
        result.set(RoutConst.SCOPE, new TextNode(ResponseScopeEnum.REQUEST.name()));
        result.set("userId", new TextNode(user.getId().toString()));
        result.set("username", new TextNode(user.getName()));
        return result;
    }

    /**
     * Сменить статус пользователя.
     */
    public void updateStatus(SessionStorage session, ObjectNode json) {
        long statusId = json.get("statusId").asLong();
        service.updateStatus(statusId);
    }

    /**
     * Наити пользователей.
     *
     * @param session TODO
     * @param json    TODO
     * @return TODO
     */
    public ObjectNode find(SessionStorage session, ObjectNode json) {
        final String userLike = json.get("userLike").asText();
        final int offset = json.get(ATTR_OFFSET).asInt();
        final int limit = json.get(ATTR_LIMIT).asInt();
        PageNavigationDto<UserTiledDto> page = service.find(session, userLike, offset, limit);

        return jsonMapper.valueToTree(page);
    }
}
