package com.zemrow.messenger.dao;

import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserTree;
import com.zemrow.messenger.entity.constants.UserTreeConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с иерархией пользователей
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserTreeDao extends AbstractDao<UserTree, UserTreeConst> {

    @Override
    public UserTreeConst getTable() {
        return UserTreeConst.UserTree;
    }

    /**
     * Добавление записи
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    public void insert(final Connection connection, SessionStorage session, UserTree entity) {
        super.insert(connection, session, entity);
    }

    /**
     * TODO
     *
     * @param connection   TODO
     * @param parentUserId ID родительского пользователя
     * @param childUserId  ID дочернего пользователя
     * @return TODO
     */
    protected UserTree select(final Connection connection, Long parentUserId, Long childUserId) {
        final SQLQuery<UserTree> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        query.where(
                UserTreeConst.UserTree.parentUserId.eq(parentUserId),
                UserTreeConst.UserTree.childUserId.eq(childUserId)
        );
        final UserTree result = query.fetchOne();
        return result;
    }

    /**
     * TODO
     *
     * @param connection   TODO
     * @param session      TODO
     * @param parentUserId TODO
     * @param childUserId  TODO
     */
    protected void delete(final Connection connection, SessionStorage session, Long parentUserId, Long childUserId) {
        final SQLDeleteClause query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.where(
                UserTreeConst.UserTree.parentUserId.eq(parentUserId),
                UserTreeConst.UserTree.childUserId.eq(childUserId)
        );
        query.execute();
    }
}
