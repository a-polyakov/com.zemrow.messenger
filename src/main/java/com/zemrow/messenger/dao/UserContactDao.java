package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserContact;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с контактами пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserContactDao extends AbstractDao<UserContact> {

    public UserContactDao(Ignite ignite) {
        super(ignite, UserContact.class, 2);
    }
}
