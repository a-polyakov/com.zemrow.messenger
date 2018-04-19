package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.ChatTree;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteBiTuple;

/**
 * DAO (data access object) для работы с иерархией чатов
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatTreeDao extends AbstractDaoWithoutId<IgniteBiTuple, ChatTree> {

    public ChatTreeDao(Ignite ignite) {
        super(ignite, IgniteBiTuple.class, ChatTree.class, 2);
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param entity
     */
    public void insert(SessionStorage session, ChatTree entity) {
        super.insert(session, new IgniteBiTuple(entity.getParentChatId(), entity.getChildChatId()), entity);
    }
}
