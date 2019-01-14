package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserContactDao;
import com.zemrow.messenger.dao.UserDao;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.logic.abstracts.AbstractLogic;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2019.01.09
 */
public class UserContactLogic extends AbstractLogic {

    private final UserContactDao userContactDao;
    private final UserDao userDao;

    public UserContactLogic(
            UserContactDao userContactDao,
            UserDao userDao
    ) {
        this.userContactDao = userContactDao;
        this.userDao = userDao;
    }

    /**
     * Добавить в контакт пользователя
     *
     * @param session      TODO
     * @param parentUserId TODO
     * @param childUserId  TODO
     * @param chatId       TODO
     * @param validate     TODO
     */
    public UserContact insert(SessionStorage session, long parentUserId, long childUserId, long chatId, boolean validate) {
        final UserContact result = new UserContact();
        result.setParentUserId(parentUserId);
        result.setChildUserId(childUserId);
        result.setValidate(validate);
        final User user = userDao.select(childUserId);
        result.setLabel(user.getName());
        result.setChatId(chatId);
        userContactDao.insert(session, result);
        return result;
    }
}
