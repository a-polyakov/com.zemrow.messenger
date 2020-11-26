package com.zemrow.messenger.dao;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.SQLQuery;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.constants.UserEntryPointConst;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;

import java.sql.Connection;

/**
 * DAO (data access object) для работы со способами авторизации пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserEntryPointDao extends AbstractDaoWithId<UserEntryPoint, UserEntryPointConst> {

    @Override
    public UserEntryPointConst getTable() {
        return UserEntryPointConst.UserEntryPoint;
    }

    @Override
    public SimpleExpression getKey() {
        return UserEntryPointConst.UserEntryPoint.id;
    }

    //TODO
    @Override
    public void insert(Connection connection, SessionStorage session, UserEntryPoint entity) {
        super.insert(connection, session, entity);
    }

    /**
     * Найти cпособ авторизации
     *
     * @param connection       TODO
     * @param userEntryPointId Идентификатор
     * @return Способ авторизации.
     */
    public UserEntryPoint select(final Connection connection, final long userEntryPointId) {
        return super.select(connection, userEntryPointId);
    }

    //TODO
    @Override
    protected void update(final Connection connection, SessionStorage session, UserEntryPoint entity) {
        super.update(connection, session, entity);
    }

    //TODO
    public UserEntryPoint selectByLoginAndPassword(final Connection connection, String login, String password) {
        final SQLQuery<UserEntryPoint> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        query.where(
                getTable().entryPointType.eq(EntryPointTypeEnum.LOGIN_PASSWORD),
                getTable().clientId.eq(login),
                getTable().credential.eq(password)
        );
        final UserEntryPoint result = query.fetchOne();
        return result;
    }
}
