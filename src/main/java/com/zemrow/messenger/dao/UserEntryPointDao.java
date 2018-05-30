package com.zemrow.messenger.dao;

import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserEntryPoint;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы со способами авторизации пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserEntryPointDao extends AbstractDao<UserEntryPoint> {

    public UserEntryPointDao(Ignite ignite) {
        super(ignite, UserEntryPoint.class, IdConstant.FIRST_ID_USER_ENTRY_POINT, 2);
    }
}
