package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserContact;
import java.util.List;
import javax.cache.Cache;
import org.apache.ignite.Ignite;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlQuery;

/**
 * DAO (data access object) для работы с контактами пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserContactDao extends AbstractDao<UserContact> {

    public UserContactDao(Ignite ignite) {
        super(ignite, UserContact.class, IdConstant.FIRST_ID_USER_CONTACT, 2);
    }

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
