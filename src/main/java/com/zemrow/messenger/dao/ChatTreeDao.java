package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoWithoutId;
import com.zemrow.messenger.entity.ChatTree;
import com.zemrow.messenger.entity.ChatTreeKey;

/**
 * DAO (data access object) для работы с иерархией чатов
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatTreeDao extends AbstractDaoWithoutId<ChatTreeKey, ChatTree> {

    public ChatTreeDao(DataBase dataBase) {
        super(dataBase, ChatTreeKey.class, ChatTree.class, 2);
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param entity
     */
    public void insert(SessionStorage session, ChatTree entity) {
        super.insert(session, entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ChatTree select(ChatTreeKey id) {
        return super.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void delete(SessionStorage session, ChatTreeKey id) {
        super.delete(session, id);
    }
}
