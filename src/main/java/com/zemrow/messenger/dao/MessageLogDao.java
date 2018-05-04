package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.MessageLog;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с историей сообщений
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageLogDao extends AbstractDaoCreateOnly<MessageLog> {

    public MessageLogDao(Ignite ignite) {
        super(ignite, MessageLog.class, IdConstant.FIRST_ID_MESSAGE_LOG, 2);
    }

    @Override
    protected void preUpdate(SessionStorage session, MessageLog entity) {
        throw new UnsupportedOperationException("TODO");
    }
}
