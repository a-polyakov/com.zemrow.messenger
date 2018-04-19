package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.Message;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с сообщениями
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageDao extends AbstractDao<Message> {

    public MessageDao(Ignite ignite) {
        super(ignite, Message.class, 2);
    }
}