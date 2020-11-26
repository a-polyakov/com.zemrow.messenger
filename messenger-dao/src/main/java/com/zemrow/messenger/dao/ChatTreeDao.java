package com.zemrow.messenger.dao;

import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.ChatTree;
import com.zemrow.messenger.entity.constants.ChatTreeConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с иерархией чатов
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatTreeDao extends AbstractDao<ChatTree, ChatTreeConst> {

    @Override
    public ChatTreeConst getTable() {
        return ChatTreeConst.ChatTree;
    }

    /**
     * Добавление записи
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    public void insert(final Connection connection, SessionStorage session, ChatTree entity) {
        super.insert(connection, session, entity);
    }

    /**
     * TODO
     */
    protected ChatTree select(final Connection connection, Long parentChatId, Long childChatId) {
        final SQLQuery<ChatTree> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        query.where(
                ChatTreeConst.ChatTree.parentChatId.eq(parentChatId),
                ChatTreeConst.ChatTree.childChatId.eq(childChatId)
        );
        final ChatTree result = query.fetchOne();
        return result;
    }

    /**
     * TODO
     */
    protected void delete(final Connection connection, Long parentChatId, Long childChatId) {
        final SQLDeleteClause query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.where(
                ChatTreeConst.ChatTree.parentChatId.eq(parentChatId),
                ChatTreeConst.ChatTree.childChatId.eq(childChatId)
        );
        query.execute();
    }
}
