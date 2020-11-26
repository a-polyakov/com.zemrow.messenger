package com.zemrow.messenger.dao;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Message;
import com.zemrow.messenger.entity.constants.MessageConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с сообщениями
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageDao extends AbstractDaoWithId<Message, MessageConst> {

    @Override
    public MessageConst getTable() {
        return MessageConst.Message;
    }

    @Override
    public SimpleExpression getKey() {
        return MessageConst.Message.id;
    }

    //TODO
    @Override
    protected Message select(final Connection connection, long id) {
        return super.select(connection, id);
    }

    //TODO
    @Override
    protected void update(final Connection connection, SessionStorage session, Message entity) {
        super.update(connection, session, entity);
    }
}
