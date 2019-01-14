package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoWithoutId;
import com.zemrow.messenger.entity.UserTree;
import com.zemrow.messenger.entity.UserTreeKey;

/**
 * DAO (data access object) для работы с иерархией пользователей
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserTreeDao extends AbstractDaoWithoutId<UserTreeKey, UserTree> {

    public UserTreeDao(DataBase dataBase) {
        super(dataBase, UserTreeKey.class, UserTree.class, 2);
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param entity
     */
    public void insert(SessionStorage session, UserTree entity) {
        super.insert(session, entity);
    }

    /**
     * TODO
     */
    @Override
    protected UserTree select(UserTreeKey id) {
        return super.select(id);
    }

    /**
     * TODO
     */
    @Override
    protected void delete(SessionStorage session, UserTreeKey id) {
        super.delete(session, id);
    }
}
