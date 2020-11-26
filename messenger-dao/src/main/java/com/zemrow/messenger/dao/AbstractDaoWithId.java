package com.zemrow.messenger.dao;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.RelationalPath;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.DefaultMapper;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.querydsl.sql.dml.SQLUpdateClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.AbstractEntityWithId;

import java.sql.Connection;
import java.util.UUID;

/**
 * Универсальное DAO (data access object) реализующее базовые методы работы с БД для таблиц имеющих id
 * <ul>
 *     <li>Получить список entity</li>
 *     <li>Определение количества записей удовлетворяющее условиям</li>
 *     <li>Добавление запись в таблицу</li>
 *     <li>Добавление записей в таблицу</li>
 *
 *     <li>Получить entity по id</li>
 *     <li>Обновление записи в таблице по id</li>
 *     <li>Удаление записи из таблицы</li>
 *     <li>Пометить запись как удаленная</li>
 * </ul>
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public abstract class AbstractDaoWithId<E extends AbstractEntityWithId, Q extends RelationalPath> extends AbstractDao<E, Q> {
    /**
     * SQL константа идентификатора записи
     *
     * @return SQL константа
     */
    public abstract SimpleExpression getKey();

    /**
     * Получить следующий идентификатор
     */
    public long nextId() {
        return UUID.randomUUID().getLeastSignificantBits();
    }

    /**
     * Получить запись по id
     *
     * @param connection - TODO
     * @param id         - Идентификатор записи
     * @return запись
     */
    protected E select(final Connection connection, long id) {
        final SQLQuery<E> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        query.where(getKey().eq(id));
        final E result = query.fetchOne();
        return result;
    }

    /**
     * Обновление записи в таблице по id
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     * TODO return
     */
    protected void update(final Connection connection, final SessionStorage session, E entity) {
        entity.preUpdate(session);
        final SQLUpdateClause query = new SQLUpdateClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.populate(entity, DefaultMapper.WITH_NULL_BINDINGS);
        query.where(getKey().eq(entity.getId()));
        query.execute();
    }

    /**
     * Удаление записи из таблицы
     *
     * @param connection TODO
     * @param session    TODO
     * @param id         TODO
     */
    protected void delete(final Connection connection, final SessionStorage session, long id) {
        final SQLDeleteClause query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.where(getKey().eq(id));
        query.execute();
    }

    /**
     * Пометить запись как удаленная
     *
     * @param connection TODO
     * @param session    TODO
     * @param id         TODO
     */
    protected void markAsDeleted(final Connection connection, final SessionStorage session, long id) {
        final E entity = select(connection, id);
        markAsDeleted(connection, session, entity);
    }

    /**
     * Пометить запись как удаленная
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    protected void markAsDeleted(final Connection connection, final SessionStorage session, E entity) {
        entity.preDelete(session);
        update(connection, session, entity);
    }
}
