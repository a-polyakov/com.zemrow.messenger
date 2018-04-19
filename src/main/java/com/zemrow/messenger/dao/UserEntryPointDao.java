package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserEntryPoint;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы со способами авторизации пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserEntryPointDao extends AbstractDao<UserEntryPoint> {

    public UserEntryPointDao(Ignite ignite) {
        super(ignite, UserEntryPoint.class, 2);
    }
}
