package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserStatusDao;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.logic.abstracts.AbstractLogic;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class UserStatusLogic extends AbstractLogic {
    /**
     * TODO
     */
    private final UserStatusDao userStatusDao;

    public UserStatusLogic(UserStatusDao userStatusDao) {
        this.userStatusDao = userStatusDao;
    }

    /**
     * Получить идентификатор статуса по его типу
     *
     * @param session - SessionStorage
     * @param type    - тип статуса
     * @return идентификатор статуса
     */
    public Long selectIdByType(SessionStorage session, UserStatusTypeEnum type) {
        return userStatusDao.selectIdByType(session, type);
    }

    public void insert(SessionStorage session, UserStatus entity) {
        userStatusDao.insert(session, entity);
    }
}
