package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserContactDao;
import com.zemrow.messenger.dao.UserInfoDao;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.enums.UserContactStatusEnum;

import java.sql.Connection;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2019.01.09
 */
public class UserContactLogic extends AbstractLogicWithId<UserContactDao> {

    private final UserInfoDao userInfoDao;

    public UserContactLogic(UserContactDao userContactDao, UserInfoDao userInfoDao) {
        super(userContactDao);
        this.userInfoDao = userInfoDao;
    }

    /**
     * Добавить в контакт пользователя
     *
     * @param connection        TODO
     * @param session           TODO
     * @param parentUserId      TODO
     * @param childUserId       TODO
     * @param chatId            TODO
     * @param userContactStatus TODO
     */
    public UserContact insert(final Connection connection, SessionStorage session, long parentUserId, long childUserId, long chatId, UserContactStatusEnum userContactStatus) {
        final UserContact result = new UserContact();
        result.setId(nextId());
        result.setParentUserId(parentUserId);
        result.setChildUserId(childUserId);
        result.setUserContactStatus(userContactStatus);
        final UserInfo user = userInfoDao.select(connection, childUserId);
        result.setLabel(user.getName());
        result.setChatId(chatId);
        dao.insert(connection, session, result);
        return result;
    }

    /**
     * TODO
     * @param connection TODO
     * @param session TODO
     * @param userId идентификатор пользователя
     * @return контакт пользователя
     */
    public UserContact select(Connection connection, SessionStorage session, long userId) {
        return dao.selectByParentUserIdAndChildUserId(connection, session.getUserId(), userId);
    }
}
