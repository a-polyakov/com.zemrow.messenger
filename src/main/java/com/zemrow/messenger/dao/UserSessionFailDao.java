package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserSessionFail;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с неудачными попытками входа в систему
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserSessionFailDao extends AbstractDaoCreateOnly<UserSessionFail> {

    public UserSessionFailDao(Ignite ignite) {
        super(ignite, UserSessionFail.class, 2);
    }

    @Override
    protected void preUpdate(SessionStorage session, UserSessionFail entity) {
        throw new UnsupportedOperationException("TODO");
    }
}
