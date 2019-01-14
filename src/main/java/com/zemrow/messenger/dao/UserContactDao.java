package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.UserContact;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlQuery;

import javax.cache.Cache;
import java.util.List;

/**
 * DAO (data access object) для работы с контактами пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserContactDao extends AbstractDao<UserContact> {

    public static final String TABLE = "UserContact";

    public UserContactDao(DataBase dataBase) {
        super(dataBase, UserContact.class, IdConstant.FIRST_ID_USER_CONTACT, 2);
    }

    /**
     * TODO
     */
    @Override
    protected UserContact select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, UserContact entity) {
        super.update(session, entity);
    }

    //TODO
    public UserContact selectByParentUserIdAndChildUserId(SessionStorage session, Long parentUserId, Long childUserId) {
        UserContact result=null;
        try(final QueryCursor cursor = cache.query(new SqlQuery(UserContact.class, "parentUserId=? and childUserId=?").setArgs(parentUserId, childUserId))) {
            final List<Cache.Entry<Long, UserContact>> all = cursor.getAll();
            if (!all.isEmpty()) {
                result = all.get(0).getValue();
            }
        }
        return result;
    }
}
