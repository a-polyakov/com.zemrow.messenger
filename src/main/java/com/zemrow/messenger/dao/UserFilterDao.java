package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.UserFilter;

/**
 * DAO (data access object) для работы с пользовательскими фильтрами
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserFilterDao extends AbstractDao<UserFilter> {

    public UserFilterDao(DataBase dataBase) {
        super(dataBase, UserFilter.class, IdConstant.FIRST_ID_USER_FILTER, 2);
    }

    /**
     * TODO
     */
    @Override
    protected UserFilter select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, UserFilter entity) {
        super.update(session, entity);
    }
}
