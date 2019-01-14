package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserSessionDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import com.zemrow.messenger.logic.abstracts.AbstractLogic;

import java.util.UUID;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserSessionLogic extends AbstractLogic {

    private final UserSessionDao userSessionDao;

    public UserSessionLogic(UserSessionDao userSessionDao) {
        this.userSessionDao = userSessionDao;
    }

    public SessionStorage getSystemSession() {
        final SessionStorage session = new SessionStorage(IdConstant.FIRST_ID_USER);
        session.setUserType(UserTypeEnum.ADMIN);
        return session;
    }

    /**
     * Добавление сессии пользователя
     *
     * @param session     - SessionStorage
     * @param userSession - Сессия пользователя
     */
    public void insert(final SessionStorage session, final UserSession userSession) {
        final String token = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        session.setToken(token);
        userSession.setToken(token);
        userSessionDao.insert(session, userSession);
    }

    /**
     * Получить сессию пользователя.
     *
     * @param token Идентификатор сессии.
     * @return Сессия.
     */
    public UserSession select(String token) {
        return userSessionDao.select(token);
    }

    //TODO doc
    public void delete(SessionStorage session, String token) {
        userSessionDao.markAsDeleted(session, token);
    }
}
