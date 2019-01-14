package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.MessageTag;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с тегами сообщений
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class MessageTagDao extends AbstractDao<MessageTag> {

    public static final String TABLE = "MessageTag";

    public MessageTagDao(DataBase dataBase) {
        super(dataBase, MessageTag.class, IdConstant.FIRST_ID_MESSAGE_TAG, 2);
    }

    /**
     * TODO
     */
    @Override
    protected MessageTag select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, MessageTag entity) {
        super.update(session, entity);
    }
}
