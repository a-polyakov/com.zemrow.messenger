package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.ChatTagGroup;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с груповыми тегами чатома
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatTagGroupDao extends AbstractDao<ChatTagGroup> {

    public ChatTagGroupDao(Ignite ignite) {
        super(ignite, ChatTagGroup.class, 2);
    }
}
