package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateAndDelete;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.UserLink;

/**
 * DAO (data access object) для работы с организационой структурой пользователей
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserLinkDao extends AbstractDaoCreateAndDelete<UserLink> {

    public UserLinkDao(DataBase dataBase) {
        super(dataBase, UserLink.class, IdConstant.FIRST_ID_USER_LINK, 2);
    }

    /**
     * TODO
     */
    @Override
    protected UserLink select(SimpleKey id) {
        return super.select(id);
    }

    @Override
    protected void update(SessionStorage session, UserLink entity) {
        super.update(session, entity);
    }
}
