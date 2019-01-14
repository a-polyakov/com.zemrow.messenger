package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatWork;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с логированием времени
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatWorkDao extends AbstractDao<ChatWork> {

    public ChatWorkDao(DataBase dataBase) {
        super(dataBase, ChatWork.class, IdConstant.FIRST_ID_CHAT_WORK, 2);
    }

    /**
     * Получить залогированое время по идентификатору.
     *
     * @param id Идентификатор работы.
     * @return Время работы.
     */
    protected ChatWork select(SimpleKey id) {
        return super.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void update(SessionStorage session, ChatWork entity) {
        super.update(session, entity);
    }
}
