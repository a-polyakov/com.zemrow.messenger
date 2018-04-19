package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserFilter;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с пользовательскими фильтрами
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserFilterDao extends AbstractDao<UserFilter> {

    public UserFilterDao(Ignite ignite) {
        super(ignite, UserFilter.class, 2);
    }
}
