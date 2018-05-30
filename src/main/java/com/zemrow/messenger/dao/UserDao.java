package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.User;
import java.util.List;
import java.util.logging.Level;
import org.apache.ignite.Ignite;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

/**
 * DAO (data access object) для работы с пользователем
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class UserDao extends AbstractDao<User> {

    public UserDao(Ignite ignite) {
        super(ignite, User.class, IdConstant.FIRST_ID_USER, 2);
    }

    /**
     * Получить идентификатор пользователя по его наименованию
     *
     * @param session - SessionStorage
     * @param name    - имя пользователя
     * @return идентификатор пользователя
     */
    public Long selectIdByName(SessionStorage session, String name) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("selectIdByName by name " + name);
        }
        Long result = null;
        try (final FieldsQueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery("select id from User where name = ?").setArgs(name))) {
            final List<List<?>> all = cursor.getAll();
            if (all.size() == 1) {
                final List<?> row = all.get(0);
                if (row.size() == 1) {
                    result = (Long)(row.get(0));
                }
            }
        }
        return result;
    }
}