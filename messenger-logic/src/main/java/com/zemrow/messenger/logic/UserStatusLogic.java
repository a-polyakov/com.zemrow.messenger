package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserStatusDao;
import com.zemrow.messenger.entity.UserStatus;
import java.sql.Connection;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class UserStatusLogic extends AbstractLogicWithId<UserStatusDao> {
    //TODO
    public UserStatusLogic(UserStatusDao dao) {
        super(dao);
    }

    //TODO
    public void insert(final Connection connection, SessionStorage session, UserStatus entity) {
        dao.insert(connection, session, entity);
    }
}
