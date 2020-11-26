package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserSessionDao;
import com.zemrow.messenger.entity.UserSession;

import java.sql.Connection;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserSessionLogic extends AbstractLogic<UserSessionDao> {

    //TODO
    public UserSessionLogic(UserSessionDao userSessionDao) {
        super(userSessionDao);
    }

    //TODO
    //    public SessionStorage getSystemSession() {
    //        final SessionStorage session = new SessionStorage(IdConstant.FIRST_ID_USER);
    //        session.setUserType(UserTypeEnum.ADMIN);
    //        return session;
    //    }

    /**
     * Получить следующий идентификатор
     */
    public String nextId() {
        return dao.nextId();
    }

    /**
     * Вход в систему.
     *
     * @param connection       TODO
     * @param token            Уникальный идентификатор сессии, сложный для подбора
     * @param userEntryPointId ID способа авторизации пользователя
     */
    public UserSession insert(final Connection connection, String token, final long userEntryPointId) {
        UserSession userSession = new UserSession();
        userSession.setToken(token);
        userSession.setUserEntryPointId(userEntryPointId);
        dao.insert(connection, null, userSession);
        return userSession;
    }

    /**
     * Получить сессию пользователя.
     *
     * @param connection TODO
     * @param token      Идентификатор сессии.
     * @return Сессия.
     */
    public UserSession select(final Connection connection, String token) {
        return dao.select(connection, token);
    }

    //TODO doc
    public void delete(final Connection connection, SessionStorage session, String token) {
        dao.markAsDeleted(connection, session, token);
    }
}
