package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateOnly;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserLog;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с историей пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserLogDao extends AbstractDaoCreateOnly<UserLog> {

    public UserLogDao(Ignite ignite) {
        super(ignite, UserLog.class, IdConstant.FIRST_ID_USER_LOG, 2);
    }

    @Override
    protected void preUpdate(SessionStorage session, UserLog entity) {
        throw new UnsupportedOperationException("TODO");
    }
}
