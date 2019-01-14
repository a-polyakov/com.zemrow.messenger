package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateOnly;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.UserLog;

/**
 * DAO (data access object) для работы с историей пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserLogDao extends AbstractDaoCreateOnly<UserLog> {

    public UserLogDao(DataBase dataBase) {
        super(dataBase, UserLog.class, IdConstant.FIRST_ID_USER_LOG, 2);
    }

    @Override
    protected void preUpdate(SessionStorage session, UserLog entity) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserLog select(SimpleKey id) {
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
