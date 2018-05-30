package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateAndDelete;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserSession;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с сесиями пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserSessionDao extends AbstractDaoCreateAndDelete<UserSession> {

    public UserSessionDao(Ignite ignite) {
        super(ignite, UserSession.class, IdConstant.FIRST_ID_USER_SESSION, -1);
    }

    @Override
    protected void preUpdate(SessionStorage session, UserSession entity) {
        throw new UnsupportedOperationException("TODO");
    }
}
