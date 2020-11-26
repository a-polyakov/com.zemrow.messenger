package com.zemrow.messenger.dao;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.constants.ChatToUserConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с участниками чатов
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatToUserDao extends AbstractDaoWithId<ChatToUser, ChatToUserConst> {

    @Override
    public ChatToUserConst getTable() {
        return ChatToUserConst.ChatToUser;
    }

    @Override
    public SimpleExpression getKey() {
        return ChatToUserConst.ChatToUser.id;
    }

    /**
     * Добавление запись в таблицу
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    public void insert(final Connection connection, final SessionStorage session, ChatToUser entity) {
        super.insert(connection, session, entity);
    }

    /**
     * Получить участника чата по идентификатору.
     *
     * @param connection TODO
     * @param id         Идентификатор.
     * @return Участник чата.
     */
    @Override
    public ChatToUser select(final Connection connection, final long id) {
        return super.select(connection, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Connection connection, SessionStorage session, ChatToUser entity) {
        super.update(connection, session, entity);
    }
}
