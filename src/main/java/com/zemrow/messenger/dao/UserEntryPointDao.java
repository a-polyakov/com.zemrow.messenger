package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlQuery;

import javax.cache.Cache;
import java.util.List;

/**
 * DAO (data access object) для работы со способами авторизации пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserEntryPointDao extends AbstractDao<UserEntryPoint> {

    public static final String TABLE = "UserEntryPoint";
    public static final String ENTRY_POINT_TYPE = "entryPointType";
    public static final String CLIENT_ID = "clientId";
    public static final String CREDENTIAL = "credential";

    public UserEntryPointDao(DataBase dataBase) {
        super(dataBase, UserEntryPoint.class, IdConstant.FIRST_ID_USER_ENTRY_POINT, 2);
    }

    /**
     * Найти cпособ авторизации
     *
     * @param userEntryPointId Идентификатор
     * @return Способ авторизации.
     */
    public UserEntryPoint select(long userEntryPointId) {
        return super.select(new SimpleKey(userEntryPointId));
    }

    //TODO
    @Override
    protected void update(SessionStorage session, UserEntryPoint entity) {
        super.update(session, entity);
    }

    private static final String selectByLoginAndPasswordQuery = ENTRY_POINT_TYPE + " = ? AND " + CLIENT_ID + " = ? AND " + CREDENTIAL + " = ?";

    public UserEntryPoint selectByLoginAndPassword(String login, String password) {
        logger.debug("selectIdByLoginAndPassword by login {}", login);
        UserEntryPoint result = null;
        try (final QueryCursor<Cache.Entry<Long, UserEntryPoint>> cursor = cache.query(new SqlQuery(UserEntryPoint.class, selectByLoginAndPasswordQuery).setArgs(EntryPointTypeEnum.LOGIN_PASSWORD, login, password))) {
            final List<Cache.Entry<Long, UserEntryPoint>> all = cursor.getAll();
            if (all.size() == 1) {
                final Cache.Entry<Long, UserEntryPoint> row = all.get(0);
                result = row.getValue();
            }
        }
        return result;
    }
}
