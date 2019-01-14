package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.Message;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с сообщениями
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageDao extends AbstractDao<Message> {

    public static final String TABLE = "Message";

    public MessageDao(DataBase dataBase) {
        super(dataBase, Message.class, IdConstant.FIRST_ID_MESSAGE, 2);
    }

    //TODO
    @Override
    protected Message select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, Message entity) {
        super.update(session, entity);
    }
}
