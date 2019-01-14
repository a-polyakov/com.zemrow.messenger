package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.MessageToUser;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с пользователями сообщения
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageToUserDao extends AbstractDao<MessageToUser> {

    public static final String TABLE = "MessageToUser";

    public MessageToUserDao(DataBase dataBase) {
        super(dataBase, MessageToUser.class, IdConstant.FIRST_ID_MESSAGE_TO_USER, 2);
    }

    /**
     * TODO
     */
    @Override
    protected MessageToUser select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, MessageToUser entity) {
        super.update(session, entity);
    }
}
