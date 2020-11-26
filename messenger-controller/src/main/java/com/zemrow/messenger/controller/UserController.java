package com.zemrow.messenger.controller;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.PageNavigationResponse;
import com.zemrow.messenger.dto.UserCurrentResponse;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.enums.ResponseScopeEnum;
import com.zemrow.messenger.service.UserInfoService;

import java.util.Map;

/**
 * Получить информацию о текущем пользователе.
 * <p>
 * Получить информацию о пользователе.
 * <p>
 * Сменить статус пользователя.
 * <p>
 * Найти пользователей.
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserController extends AbstractController<UserInfoService> {
    //TODO
    public UserController(UserInfoService service) {
        super(service);
    }

    /**
     * Получить информацию о текущем пользователе.
     *
     * @param session TODO
     * @param json    TODO
     * @return TODO
     */
    public UserCurrentResponse current(SessionStorage session, Map json) throws Exception {
        final UserInfo user = service.select(session, null);
        final UserCurrentResponse result = new UserCurrentResponse();
        result.setScope(ResponseScopeEnum.REQUEST);
        result.setUserId(user.getId());
        result.setUserName(user.getName());
        // TODO задание над которым работает пользователь
        return result;
    }
    //TODO
/*
    *
 * Получить информацию о пользователе.

    public ObjectNode select(SessionStorage session, Map json) {
        final Long userId = json.get("userId").asLong();
        final UserInfo user = service.select(session, userId);
        final ObjectNode result = jsonMapper.createObjectNode();
        result.set(RoutConst.SCOPE, new TextNode(ResponseScopeEnum.REQUEST.name()));
        result.set("userId", new TextNode(user.getId().toString()));
        result.set("username", new TextNode(user.getName()));
        return result;
    }
//TODO
    *
 * Сменить статус пользователя.
 *//*
    public void updateStatus(SessionStorage session, Map json) {
        long statusId = json.get("statusId").asLong();
        service.updateStatus(statusId);
    }*/

    /**
     * Найти пользователей.
     *
     * @param session TODO
     * @param json    TODO
     * @return TODO
     */
    public PageNavigationResponse<UserTiledDto> find(SessionStorage session, Map json) throws Exception {
        String userLike = (String) json.get("userLike");
        Long offset = getLong(json, AbstractController.ATTR_OFFSET, DEFAULT_OFFSET);
        Long limit = getLong(json, AbstractController.ATTR_LIMIT, DEFAULT_LIMIT);
        final PageNavigationDto<UserTiledDto> page = service.find(session, userLike, offset, limit);
        return new PageNavigationResponse<>(page);
    }
}
