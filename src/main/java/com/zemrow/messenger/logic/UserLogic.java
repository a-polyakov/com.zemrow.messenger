package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserDao;
import com.zemrow.messenger.dao.UserStatusDao;
import com.zemrow.messenger.dao.UserTreeDao;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.UserTree;
import com.zemrow.messenger.exception.ForeignKeyViolationException;
import com.zemrow.messenger.exception.NotNullConstrainViolationException;
import com.zemrow.messenger.exception.UniqueConstraintViolationException;
import com.zemrow.messenger.logic.сonstrain.ForeignKeyConstrain;
import com.zemrow.messenger.logic.сonstrain.NotNullConstrain;
import com.zemrow.messenger.logic.сonstrain.UniqueConstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserLogic {

    private static final NotNullConstrain USER_NAME_NOT_NULL = new NotNullConstrain(User.class, "name");
    private static final UniqueConstrain USER_NAME_UNIQUE = new UniqueConstrain(User.class, "name");
    private static final NotNullConstrain USER_STATUS_ID_NOT_NULL = new NotNullConstrain(User.class, "status");
    private static final ForeignKeyConstrain USER_STATUS_ID_FK = new ForeignKeyConstrain(User.class, "status", UserStatus.class);

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
     * @param session - SessionStorage
     * @param name - имя пользователя
     * @return идентификатор пользователя
     */
    public Long selectIdByName(SessionStorage session, String name) {
        return userDao.selectIdByName(session, name);
    }

    /**
     * Добавление пользователя
     *
     * @param session - SessionStorage
     * @param user - пользователь
     */
    public void insert(final SessionStorage session, final User user) {
        if (user.getName()==null || user.getName().isEmpty()){
            throw new NotNullConstrainViolationException(USER_NAME_NOT_NULL);
        }
        if (user.getUserStatusId()==null){
            throw new NotNullConstrainViolationException(USER_STATUS_ID_NOT_NULL);
        }
        if (!userStatusDao.containsById(session, user.getUserStatusId())) {
            throw new ForeignKeyViolationException(USER_STATUS_ID_FK);
        }
        if (userDao.selectIdByName(session, user.getName()) != null) {
            throw new UniqueConstraintViolationException(USER_NAME_UNIQUE);
        }

        userDao.insert(session, user);

        final UserTree userTree = new UserTree();
        userTree.setParentUserId(user.getId());
        userTree.setChildUserId(user.getId());
        userTree.setDistance(0);
        userTreeDao.insert(session, userTree);
    }
}
