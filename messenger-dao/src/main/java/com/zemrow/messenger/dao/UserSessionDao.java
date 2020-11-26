package com.zemrow.messenger.dao;

import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.SQLUpdateClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.constants.UserSessionConst;

import java.sql.Connection;
import java.util.UUID;

/**
 * DAO (data access object) для работы с сессиями пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserSessionDao extends AbstractDao<UserSession, UserSessionConst> {

    @Override
    public UserSessionConst getTable() {
        return UserSessionConst.UserSession;
    }

    /**
     * Получить следующий идентификатор
     */
    public String nextId() {
        return UUID.randomUUID().toString() + UUID.randomUUID().toString();
    }

    /**
     * Вход в систему.
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    public void insert(final Connection connection, final SessionStorage session, UserSession entity) {
        super.insert(connection, session, entity);
    }

    /**
     * Получить сессию пользователя.
     *
     * @param connection TODO
     * @param token      Идентификатор сессии.
     * @return Сессия.
     */
    public UserSession select(final Connection connection, String token) {
        final SQLQuery<UserSession> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        query.where(getTable().token.eq(token));
        final UserSession result = query.fetchOne();
        return result;
    }

    /**
     * Пометить запись как удаленная
     *
     * @param connection TODO
     * @param session    TODO
     * @param token      TODO
     */
    public void markAsDeleted(final Connection connection, final SessionStorage session, String token) {
        final SQLUpdateClause query = new SQLUpdateClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.set(UserSessionConst.UserSession.deleteTime, System.currentTimeMillis());
        query.set(UserSessionConst.UserSession.deletedBy, session.getUserId());
        query.where(getTable().token.eq(token));
        query.execute();
    }

    /**
     * Пометить запись как удаленная (работает медленно)
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    public void markAsDeleted(final Connection connection, final SessionStorage session, UserSession entity) {
        entity.preDelete(session);
        final SQLUpdateClause query = new SQLUpdateClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.set(UserSessionConst.UserSession.deleteTime, entity.getDeleteTime());
        query.set(UserSessionConst.UserSession.deletedBy, entity.getDeletedBy());
        query.where(getTable().token.eq(entity.getToken()));
        query.execute();
    }
}
