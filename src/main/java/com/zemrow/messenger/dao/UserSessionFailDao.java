package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateOnly;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.UserSessionFail;

/**
 * DAO (data access object) для работы с неудачными попытками входа в систему
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserSessionFailDao extends AbstractDaoCreateOnly<UserSessionFail> {

    public UserSessionFailDao(DataBase dataBase) {
        super(dataBase, UserSessionFail.class, IdConstant.FIRST_ID_USER_SESSION_FAIL, 0);
    }

    @Override
    protected void preUpdate(SessionStorage session, UserSessionFail entity) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserSessionFail select(SimpleKey id) {
        return super.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void delete(SessionStorage session, SimpleKey id) {
        super.delete(session, id);
    }
}
