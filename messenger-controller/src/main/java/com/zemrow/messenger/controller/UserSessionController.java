package com.zemrow.messenger.controller;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.AbstractScopeDto;
import com.zemrow.messenger.exception.NotAuthorizedException;
import com.zemrow.messenger.service.UserSessionService;

import java.util.Map;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.10
 */
public class UserSessionController extends AbstractController<UserSessionService> {

    public UserSessionController(UserSessionService userSessionService) {
        super(userSessionService);
    }


    /**
     * Выход из системы (только текущую сессию).
     *
     * @param session TODO
     * @param json    TODO
     */
    public AbstractScopeDto delete(SessionStorage session, Map json) throws Exception {
        service.delete(session);
        //TODO
        throw new NotAuthorizedException("User logout");
    }

    /**
     * Создать контекст сессии пользователя (проверить token).
     *
     * @param token Идентификатор сессии.
     * @return Сессия.
     */
    public SessionStorage getSessionStorage(String token) throws Exception {
        return service.getSessionStorage(token);
    }
}
