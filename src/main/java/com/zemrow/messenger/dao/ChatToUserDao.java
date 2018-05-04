package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.ChatToUser;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с участниками чатома
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatToUserDao extends AbstractDao<ChatToUser> {

    public ChatToUserDao(Ignite ignite) {
        super(ignite, ChatToUser.class, IdConstant.FIRST_ID_CHAT_TO_USER, 2);
    }
}
