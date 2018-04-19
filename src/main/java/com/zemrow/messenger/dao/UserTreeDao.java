package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserTree;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteBiTuple;

/**
 * DAO (data access object) для работы с иерархией пользователей
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserTreeDao extends AbstractDaoWithoutId<IgniteBiTuple, UserTree> {

    public UserTreeDao(Ignite ignite) {
        super(ignite, IgniteBiTuple.class, UserTree.class, 2);
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param entity
     */
    public void insert(SessionStorage session, UserTree entity) {
        super.insert(session, new IgniteBiTuple(entity.getParentUserId(), entity.getChildUserId()), entity);
    }
}
