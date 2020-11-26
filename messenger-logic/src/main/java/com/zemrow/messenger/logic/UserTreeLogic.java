package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserTreeDao;
import com.zemrow.messenger.entity.UserTree;

import java.sql.Connection;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserTreeLogic extends AbstractLogic<UserTreeDao> {
    public UserTreeLogic(UserTreeDao dao) {
        super(dao);
    }

    /**
     * Создать Дерево пользователей. Данные являются избыточными, возможно восстановить.
     *
     * @param connection   TODO
     * @param session      TODO
     * @param parentUserId ID родительского пользователя
     * @param childUserId  ID дочернего пользователя
     * @param distance     Разность уровней
     */
    public void insert(final Connection connection, SessionStorage session, long parentUserId, long childUserId, int distance) {
        final UserTree userTree = new UserTree(parentUserId, childUserId, distance);
        dao.insert(connection, session, userTree);
    }
}
