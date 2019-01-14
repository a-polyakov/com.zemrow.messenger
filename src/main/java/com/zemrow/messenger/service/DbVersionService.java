package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.UserDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import com.zemrow.messenger.logic.DbVersionLogic;
import com.zemrow.messenger.logic.UserSessionLogic;
import com.zemrow.messenger.logic.UserStatusLogic;
import com.zemrow.messenger.service.abstracts.AbstractService;
import org.apache.ignite.transactions.Transaction;

/**
 * Работы с версией схемы БД.
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class DbVersionService extends AbstractService {

    private final DbVersionLogic dbVersionLogic;
    private final UserDao userDao;
    private final UserSessionLogic userSessionLogic;
    private final UserStatusLogic userStatusLogic;

    public DbVersionService(DbVersionLogic dbVersionLogic,
                            UserDao userDao,
                            UserSessionLogic userSessionLogic,
                            UserStatusLogic userStatusLogic) {
        this.dbVersionLogic = dbVersionLogic;
        this.userDao = userDao;
        this.userSessionLogic = userSessionLogic;
        this.userStatusLogic = userStatusLogic;

        final long version = dbVersionLogic.get();
        if (version < 1) {
            applyV1();
        }
    }

    private void applyV1() {
        try (Transaction tx = transaction()) {
            // Системный пользователь
            final SessionStorage session = userSessionLogic.getSystemSession();
            final User user = new User();
            user.setId(IdConstant.FIRST_ID_USER);
            user.setName("system");
            user.setUserType(UserTypeEnum.ADMIN);
            user.setUserStatusId(IdConstant.FIRST_ID_USER_STATUS);
            userDao.insert(session, user);

            // Статусы
            UserStatus userStatus = new UserStatus();
            userStatus.setLabel("В сети");
            userStatus.setUserStatusType(UserStatusTypeEnum.ONLINE);
            userStatus.setWeight(1000);
            userStatus.setColor(0x00ff00ff);
            userStatusLogic.insert(session, userStatus);
            userStatus = new UserStatus();
            userStatus.setLabel("Не в сети");
            userStatus.setUserStatusType(UserStatusTypeEnum.OFFLINE);
            userStatus.setWeight(500);
            userStatus.setColor(0xff0000ff);
            userStatusLogic.insert(session, userStatus);

            final long version = dbVersionLogic.incrementAndGet();
            tx.commit();
            logger.info("DB version {} apply", version);
        }
    }
}
