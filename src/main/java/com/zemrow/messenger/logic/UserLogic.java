package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.UserConst;
import com.zemrow.messenger.dao.UserDao;
import com.zemrow.messenger.dao.UserStatusDao;
import com.zemrow.messenger.dao.UserTreeDao;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.UserTree;
import com.zemrow.messenger.exception.ForeignKeyViolationException;
import com.zemrow.messenger.exception.NotNullConstrainViolationException;
import com.zemrow.messenger.exception.UniqueConstraintViolationException;
import com.zemrow.messenger.logic.abstracts.AbstractLogic;
import com.zemrow.messenger.logic.сonstrain.ForeignKeyConstrain;
import com.zemrow.messenger.logic.сonstrain.NotNullConstrain;
import com.zemrow.messenger.logic.сonstrain.UniqueConstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserLogic extends AbstractLogic {

    //TODO выполнять проверки при сохранении
    private static final NotNullConstrain USER_NAME_NOT_NULL = new NotNullConstrain(User.class, UserConst.NAME);
    private static final UniqueConstrain USER_NAME_UNIQUE = new UniqueConstrain(User.class, UserConst.NAME);
    private static final NotNullConstrain USER_STATUS_ID_NOT_NULL = new NotNullConstrain(User.class, UserConst.STATUS);
    private static final ForeignKeyConstrain USER_STATUS_ID_FK = new ForeignKeyConstrain(User.class, UserConst.STATUS, UserStatus.class);

    private final UserDao userDao;
    private final UserTreeDao userTreeDao;
    private final UserStatusDao userStatusDao;

    public UserLogic(UserDao userDao, UserTreeDao userTreeDao, UserStatusDao userStatusDao) {
        this.userDao = userDao;
        this.userTreeDao = userTreeDao;
        this.userStatusDao = userStatusDao;
    }

    /**
     * Получить идентификатор пользователя по его наименованию
     *
     * @param name - имя пользователя
     * @return идентификатор пользователя
     */
    public Long selectIdByName(String name) {
        return userDao.selectIdByName(name);
    }

    /**
     * Добавление пользователя
     *
     * @param session - SessionStorage
     * @param user    - пользователь
     */
    public void insert(final SessionStorage session, final User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new NotNullConstrainViolationException(USER_NAME_NOT_NULL);
        }
        if (user.getUserStatusId() == null) {
            throw new NotNullConstrainViolationException(USER_STATUS_ID_NOT_NULL);
        }
        if (!userStatusDao.containsById(user.getUserStatusId())) {
            throw new ForeignKeyViolationException(USER_STATUS_ID_FK);
        }
        if (userDao.selectIdByName(user.getName()) != null) {
            throw new UniqueConstraintViolationException(USER_NAME_UNIQUE);
        }

        userDao.insert(session, user);

        final UserTree userTree = new UserTree();
        userTree.setParentUserId(user.getId());
        userTree.setChildUserId(user.getId());
        userTree.setDistance(0);
        userTreeDao.insert(session, userTree);
    }

    /**
     * Получить пользователя по идентификатору.
     *
     * @param userId Идентификатор пользователя.
     * @return Пользователь.
     */
    public User select(Long userId) {
        return userDao.select(userId);
    }

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
        return userDao.find(session, userLike, offset, limit);
    }
}
