package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserInfoDao;
import com.zemrow.messenger.dao.UserTreeDao;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.UserTree;

import java.sql.Connection;
import java.util.List;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserInfoLogic extends AbstractLogicWithId<UserInfoDao> {

    //TODO выполнять проверки при сохранении
    //    private static final NotNullConstrain USER_NAME_NOT_NULL = new NotNullConstrain(UserInfo.class, UserConst.NAME);
    //    private static final UniqueConstrain USER_NAME_UNIQUE = new UniqueConstrain(UserInfo.class, UserConst.NAME);
    //    private static final NotNullConstrain USER_STATUS_ID_NOT_NULL = new NotNullConstrain(UserInfo.class, UserConst.STATUS);
    //    private static final ForeignKeyConstrain USER_STATUS_ID_FK = new ForeignKeyConstrain(UserInfo.class, UserConst.STATUS, UserStatus.class);

    private final UserTreeDao userTreeDao;

    public UserInfoLogic(UserInfoDao userInfoDao, UserTreeDao userTreeDao) {
        super(userInfoDao);
        this.userTreeDao = userTreeDao;
    }

    /**
     * TODO
     * @param connection TODO
     * @param session TODO
     * @param userIdList TODO
     * @return TODO
     */
    public String selectJoinNameById(final Connection connection, SessionStorage session, long... userIdList){
        final Long userIdList2[]=new Long[userIdList.length];
        for (int i=0; i<userIdList.length;i++){
            userIdList2[i]=userIdList[i];
        }
        final List<String> userNameList=dao.selectNameById(connection, session, userIdList2);
        final StringBuilder label=new StringBuilder();
        for (String  name:userNameList){
            label.append(name);
            label.append(", ");
        }
        label.setLength(label.length()-2);
        return label.toString();
    }

    /**
     * Получить идентификатор пользователя по его наименованию
     *
     * @param connection TODO
     * @param name       - имя пользователя
     * @return идентификатор пользователя
     */
    public Long selectIdByName(final Connection connection, String name) {
        return dao.selectIdByName(connection, name);
    }

    /**
     * Добавление пользователя
     *
     * @param connection TODO
     * @param session    - SessionStorage
     * @param user       - пользователь
     */
    public void insert(final Connection connection, final SessionStorage session, final UserInfo user) {

        // проверка на существование пользователя с таким логином
//        if (userInfoDao.selectIdByName(user.getName()) != null) {
//            throw new UniqueConstraintViolationException(USER_NAME_UNIQUE);
//        }

        dao.insert(connection, session, user);

        // добавление в иерархию текущего пользователя
        final UserTree userTree = new UserTree(user.getId(), user.getId(), 0);
        userTreeDao.insert(connection, session, userTree);
    }

    /**
     * Получить пользователя по идентификатору.
     *
     * @param connection TODO
     * @param userId     Идентификатор пользователя.
     * @return Пользователь.
     */
    public UserInfo select(final Connection connection, final long userId) {
        return dao.select(connection, userId);
    }

    /**
     * Найти пользователей.
     *
     * @param connection TODO
     * @param session    TODO
     * @param userLike   TODO
     * @param offset     TODO
     * @param limit      TODO
     * @return TODO
     */
    public PageNavigationDto<UserTiledDto> find(final Connection connection, SessionStorage session, String userLike, long offset, long limit) {
        return dao.find(connection, session, userLike, offset, limit);
    }
}
