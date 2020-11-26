package com.zemrow.messenger.dao;

import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.DefaultMapper;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.querydsl.sql.dml.SQLUpdateClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.ChatToUserLastMessage;
import com.zemrow.messenger.entity.constants.ChatToUserLastMessageConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с последним сообщением в чате
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatToUserLastMessageDao extends AbstractDao<ChatToUserLastMessage, ChatToUserLastMessageConst> {

    @Override
    public ChatToUserLastMessageConst getTable() {
        return ChatToUserLastMessageConst.ChatToUserLastMessage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insert(final Connection connection, SessionStorage session, ChatToUserLastMessage entity) {
        super.insert(connection, session, entity);
    }

    /**
     * Получить последнее сообщение участника чата по идентификатору.
     *
     * @param connection   TODO
     * @param chatToUserId Идентификатор.
     * @return Последнее сообщение участника чата.
     */
    protected ChatToUserLastMessage select(final Connection connection, long chatToUserId) {
        final SQLQuery<ChatToUserLastMessage> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable());
        query.from(getTable());
        query.where(getTable().chatToUserId.eq(chatToUserId));
        final ChatToUserLastMessage result = query.fetchOne();
        return result;
    }

    /**
     * Обновление записи в таблице по id
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     *                   TODO return
     */
    protected void update(final Connection connection, SessionStorage session, ChatToUserLastMessage entity) {
        entity.preUpdate(session);
        final SQLUpdateClause query = new SQLUpdateClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.populate(entity, DefaultMapper.WITH_NULL_BINDINGS);
        query.where(getTable().chatToUserId.eq(entity.getChatToUserId()));
        query.execute();
    }

    /**
     * Удаление записи из таблицы
     *
     * @param connection TODO
     * @param session    TODO
     * @param id         TODO
     */
    protected void delete(final Connection connection, SessionStorage session, long id) {
        final SQLDeleteClause query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.where(getTable().chatToUserId.eq(id));
        query.execute();
    }
}
