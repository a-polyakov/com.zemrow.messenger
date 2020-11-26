package com.zemrow.messenger.dao;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.sql.RelationalPath;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.SQLInsertClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.AbstractEntity;

import java.sql.Connection;
import java.util.List;

/**
 * Универсальное DAO (data access object) реализующее базовые методы работы с БД
 * <ul>
 *     <li>Получить список entity</li>
 *     <li>Определение количества записей удовлетворяющее условиям</li>
 *     <li>Добавление запись в таблицу</li>
 *     <li>Добавление записей в таблицу</li>
 * </ul>
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public abstract class AbstractDao<E extends AbstractEntity, Q extends RelationalPath> {
    /**
     * SQL константа таблицы
     *
     * @return TODO
     */
    public abstract Q getTable();

    /**
     * Получить список entity
     *
     * @param connection TODO
     * @param where      TODO
     * @param order      TODO
     * @param offset     TODO
     * @param limit      TODO
     * @return TODO
     */
    protected List<E> select(final Connection connection, Predicate where[],
                             OrderSpecifier order[], long offset,
                             long limit) {
        final SQLQuery<E> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        if (where != null) {
            query.where(where);
        }
        if (order != null) {
            query.orderBy(order);
        }
        query.offset(offset);
        query.limit(limit);
        final List<E> result = query.fetch();
        return result;
    }

    /**
     * Определение количества записей удовлетворяющее условиям
     *
     * @param connection TODO
     * @param where      TODO
     * @return TODO
     */
    protected long selectCount(final Connection connection, Predicate where[]) {
        final SQLQuery<Long> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.from(getTable());
        if (where != null) {
            query.where(where);
        }
        final long result = query.fetchCount();
        return result;
    }

    /**
     * Добавление запись в таблицу
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    protected void insert(final Connection connection, final SessionStorage session, E entity) {
        entity.preInsert(session);
        final SQLInsertClause query = new SQLInsertClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.populate(entity);
        query.execute();
    }

    /**
     * Добавление записей в таблицу
     *
     * @param connection  TODO
     * @param session     TODO
     * @param entityArray TODO
     */
    protected void insertBatch(final Connection connection, final SessionStorage session, E... entityArray) {
        if (entityArray != null && entityArray.length > 0) {
            final SQLInsertClause query = new SQLInsertClause(connection, QueryDslConfiguration.CUSTOM, getTable());
            for (E entity : entityArray) {
                entity.preInsert(session);
                query.populate(entity);
                query.addBatch();
            }
            query.execute();
        }
    }
}
