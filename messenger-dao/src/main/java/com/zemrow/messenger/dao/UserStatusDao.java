package com.zemrow.messenger.dao;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.constants.UserStatusConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы со статусом пользователя
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class UserStatusDao extends AbstractDaoWithId<UserStatus, UserStatusConst> {

    //TODO
    @Override
    public UserStatusConst getTable() {
        return UserStatusConst.UserStatus;
    }

    //TODO
    @Override
    public SimpleExpression getKey() {
        return UserStatusConst.UserStatus.id;
    }

    //TODO
    @Override
    public void insert(Connection connection, SessionStorage session, UserStatus entity) {
        super.insert(connection, session, entity);
    }
}
