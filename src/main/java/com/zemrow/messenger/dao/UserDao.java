package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.User;
import org.apache.ignite.Ignite;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.lang.IgniteUuid;

import java.util.List;
import java.util.logging.Level;

/**
 * DAO (data access object) для работы с пользователем
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class UserDao extends AbstractDao<User> {

    public UserDao(Ignite ignite) {
        super(ignite, User.class, 2);
    }

    /**
     * Получить идентификатор пользователя по его наименованию
     *
     * @param session - SessionStorage
     * @param name    - имя пользователя
     * @return идентификатор пользователя
     */
    public IgniteUuid selectIdByName(SessionStorage session, String name) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("selectIdByName by name " + name);
        }
        IgniteUuid result = null;
        //TODO
//        try (final QueryCursor<Cache.Entry<IgniteUuid, User>> cursor = cache.query(new SqlQuery(User.class, "name=?").setArgs(name))) {
//            final List<Cache.Entry<IgniteUuid, User>> all = cursor.getAll();
//            if (all.size() == 1) {
//                result = all.get(0).getValue().getId();
//            }
//        }
//        try (final QueryCursor<Cache.Entry<IgniteUuid, User>> cursor = cache.query(new ScanQuery<IgniteUuid, User>((k, v) -> name.equals(v.getName())))) {
//            final List<Cache.Entry<IgniteUuid, User>> all = cursor.getAll();
//            if (all.size() == 1) {
//                result = all.get(0).getValue().getId();
//            }
//        }
        try (final FieldsQueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery("select id from User where name = ?").setArgs(name))) {
            final List<List<?>> all = cursor.getAll();
            if (all.size() == 1) {
                final List<?> row = all.get(0);
                if (row.size() == 1) {
                    result = (IgniteUuid) (row.get(0));
                }
            }
        }
        return result;
    }
}