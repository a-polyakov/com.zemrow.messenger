package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.ChatWork;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с логированием времени
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatWorkDao extends AbstractDao<ChatWork> {

    public ChatWorkDao(Ignite ignite) {
        super(ignite, ChatWork.class, 2);
    }
}
