package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.MessageTag;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с тегами сообщений
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageTagDao extends AbstractDao<MessageTag> {

    public MessageTagDao(Ignite ignite) {
        super(ignite, MessageTag.class, 2);
    }
}