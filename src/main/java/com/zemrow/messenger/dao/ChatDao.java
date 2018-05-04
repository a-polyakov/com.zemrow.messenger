package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.Chat;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с чатом(заданием)
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatDao extends AbstractDao<Chat> {

    public ChatDao(Ignite ignite) {
        super(ignite, Chat.class, IdConstant.FIRST_ID_CHAT, 2);
    }
}
