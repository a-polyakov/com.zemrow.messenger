package com.zemrow.messenger.dao;

import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.MessageToUser;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с пользователями сообщения
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageToUserDao extends AbstractDao<MessageToUser> {

    public MessageToUserDao(Ignite ignite) {
        super(ignite, MessageToUser.class, IdConstant.FIRST_ID_MESSAGE_TO_USER, 2);
    }
}
