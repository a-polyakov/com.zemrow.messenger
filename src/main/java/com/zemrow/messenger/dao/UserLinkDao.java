package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserLink;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с организационой структурой пользователей
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserLinkDao extends AbstractDaoCreateAndDelete<UserLink> {

    public UserLinkDao(Ignite ignite) {
        super(ignite, UserLink.class, IdConstant.FIRST_ID_USER_LINK, 2);
    }
}
