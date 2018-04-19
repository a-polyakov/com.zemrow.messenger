package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserStatus;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы со статустм пользователя
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class UserStatusDao extends AbstractDao<UserStatus> {

    public UserStatusDao(Ignite ignite) {
        super(ignite, UserStatus.class, 2);
    }
}
