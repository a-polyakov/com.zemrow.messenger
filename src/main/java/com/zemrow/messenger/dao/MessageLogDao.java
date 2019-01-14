package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateOnly;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.MessageLog;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с историей сообщений
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageLogDao extends AbstractDaoCreateOnly<MessageLog> {

    public MessageLogDao(DataBase dataBase) {
        super(dataBase, MessageLog.class, IdConstant.FIRST_ID_MESSAGE_LOG, 2);
    }

    /**
     * TODO
     */
    @Override
    protected MessageLog select(SimpleKey id) {
        return super.select(id);
    }
}
