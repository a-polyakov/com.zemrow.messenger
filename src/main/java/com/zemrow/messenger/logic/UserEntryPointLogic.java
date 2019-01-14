package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserEntryPointDao;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.logic.abstracts.AbstractLogic;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class UserEntryPointLogic extends AbstractLogic {

    private final UserEntryPointDao userEntryPointDao;

    public UserEntryPointLogic(UserEntryPointDao userEntryPointDao) {
        this.userEntryPointDao = userEntryPointDao;
    }

    /**
     * Добавление cпособа авторизации
     *
     * @param session        - SessionStorage
     * @param userEntryPoint - Способ авторизации
     */
    public void insert(final SessionStorage session, final UserEntryPoint userEntryPoint) {
        userEntryPointDao.insert(session, userEntryPoint);
    }

    /**
     * Найти cпособ авторизации по указаному логину и паролю.
     *
     * @param login    Логин.
     * @param password Пароль.
     * @return Способ авторизации.
     */
    public UserEntryPoint selectByLoginAndPassword(String login, String password) {
        return userEntryPointDao.selectByLoginAndPassword(login, password);
    }

    /**
     * Найти cпособ авторизации
     *
     * @param userEntryPointId Идентификатор
     * @return Способ авторизации.
     */
    public UserEntryPoint select(Long userEntryPointId) {
        return userEntryPointDao.select(userEntryPointId);
    }
}
