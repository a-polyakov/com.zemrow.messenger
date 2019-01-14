package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.UserConst;
import com.zemrow.messenger.constants.UserContactConst;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.User;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * DAO (data access object) для работы с пользователем
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class UserDao extends AbstractDao<User> {

    public static final String TABLE = "User";

    public UserDao(DataBase dataBase) {
        super(dataBase, User.class, IdConstant.FIRST_ID_USER, 2);
    }

    /**
     * Получить пользователя по идентификатору.
     *
     * @param userId Идентификатор пользователя.
     * @return Пользователь.
     */
    public User select(Long userId) {
        return super.select(new SimpleKey(userId));
    }


    private static final String selectIdByNameQuery = "select " + UserConst.ID + " from " + TABLE + " where " + UserConst.NAME + " = ?";

    /**
     * Получить идентификатор пользователя по его наименованию
     *
     * @param name - имя пользователя
     * @return идентификатор пользователя
     */
    public Long selectIdByName(String name) {
        logger.debug("selectIdByName by name {}", name);
        return query(selectIdByNameQuery, name);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, User entity) {
        super.update(session, entity);
    }


    private static final String findQuery = "select " +
            "u." + UserConst.ID + ", " +
            "u." + UserConst.AVATAR_ID + ", " +
            "u." + UserConst.NAME + ", " +
            "uc." + UserContactConst.ID + " " +
            "from " + TABLE + " u " +
            "  left join " + UserContactDao.TABLE + " uc " +
            "    on uc." + UserContactConst.PARENT_USER_ID + "= ? " +
            "       and uc." + UserContactConst.CHILD_USER_ID + "=u." + UserConst.ID + " " +
            "where u." + UserConst.NAME + " like ? " +
            "order by u." + UserConst.NAME + " " +
            "offset ? limit ?";

    /**
     * Наити пользователей.
     *
     * @param session  TODO
     * @param userLike TODO
     * @param offset   TODO
     * @param limit    TODO
     * @return TODO
     */
    public PageNavigationDto<UserTiledDto> find(SessionStorage session, String userLike, int offset, int limit) {
        logger.debug("find by userLike {}, offset {}, limit {}", userLike, offset, limit);
        final PageNavigationDto<UserTiledDto> result = new PageNavigationDto<>();
        final ArrayList<UserTiledDto> page = new ArrayList<>();
        result.setPage(page);
        result.setOffset(offset);
        result.setLimit(limit);

        final SqlFieldsQuery query = new SqlFieldsQuery(findQuery);

        if (userLike != null) {
            userLike = userLike.trim();
            if (!userLike.isEmpty()) {
                query.setArgs(session.getUserId(), "%" + userLike + "%", offset, limit);
                try (final FieldsQueryCursor<List<?>> cursor = cache.query(query)) {
                    for (Iterator<List<?>> it = cursor.iterator(); it.hasNext(); ) {
                        final List row = it.next();
                        UserTiledDto dto = new UserTiledDto();
                        dto.setUserId((Long) row.get(0));
                        dto.setAvatarId((Long) row.get(1));
                        dto.setUsername((String) row.get(2));
                        dto.setUserContactId((Long) row.get(3));
                        page.add(dto);
                    }
                }
            }
        }
        return result;
    }
}