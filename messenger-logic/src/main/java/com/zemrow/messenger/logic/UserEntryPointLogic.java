package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserEntryPointDao;
import com.zemrow.messenger.entity.UserEntryPoint;
import java.sql.Connection;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class UserEntryPointLogic extends AbstractLogicWithId<UserEntryPointDao> {

    public UserEntryPointLogic(UserEntryPointDao userEntryPointDao) {
        super(userEntryPointDao);
    }

    /**
     * Добавление способа авторизации
     *
     * @param connection     - TODO
     * @param session        - TODO
     * @param userEntryPoint - Способ авторизации
     */
    public void insert(final Connection connection, final SessionStorage session, final UserEntryPoint userEntryPoint) {
        dao.insert(connection, session, userEntryPoint);
    }

    /**
     * Найти способ авторизации по указанному логину и паролю.
     *
     * @param connection - TODO
     * @param login      - Логин.
     * @param password   - Пароль.
     * @return Способ авторизации.
     */
    public UserEntryPoint selectByLoginAndPassword(Connection connection, String login, String password) {
        return dao.selectByLoginAndPassword(connection, login, password);
    }

    /**
     * Найти способ авторизации
     *
     * @param connection       - TODO
     * @param userEntryPointId - Идентификатор
     * @return Способ авторизации.
     */
    public UserEntryPoint select(Connection connection, Long userEntryPointId) {
        return dao.select(connection, userEntryPointId);
    }
}
