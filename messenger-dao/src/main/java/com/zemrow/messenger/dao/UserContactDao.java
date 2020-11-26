package com.zemrow.messenger.dao;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.SQLQuery;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.entity.constants.UserContactConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с контактами пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserContactDao extends AbstractDaoWithId<UserContact, UserContactConst> {

    @Override
    public UserContactConst getTable() {
        return UserContactConst.UserContact;
    }

    @Override
    public SimpleExpression getKey() {
        return UserContactConst.UserContact.id;
    }

    /**
     * TODO
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    public void insert(Connection connection, SessionStorage session, UserContact entity) {
        super.insert(connection, session, entity);
    }

    /**
     * TODO
     */
    @Override
    protected UserContact select(Connection connection, long id) {
        return super.select(connection, id);
    }

    /**
     * TODO
     */
    @Override
    protected void update(final Connection connection, SessionStorage session, UserContact entity) {
        super.update(connection, session, entity);
    }

    /**
     * TODO
     */
    public UserContact selectByParentUserIdAndChildUserId(final Connection connection, Long parentUserId, Long childUserId) {
        final SQLQuery<UserContact> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        query.where(getTable().parentUserId.eq(parentUserId), getTable().childUserId.eq(childUserId));
        final UserContact result = query.fetchOne();
        return result;
    }
}
