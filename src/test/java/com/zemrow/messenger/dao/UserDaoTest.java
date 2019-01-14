package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import org.apache.ignite.transactions.Transaction;
import org.apache.ignite.transactions.TransactionConcurrency;
import org.apache.ignite.transactions.TransactionIsolation;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Тест для UserDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserDaoTest extends AbstractTest {

    private UserDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new UserDao(dataBase);
            final UserStatusDao userStatusDao = new UserStatusDao(dataBase);

            try (Transaction tx = dataBase.getIgnite().transactions().txStart(TransactionConcurrency.PESSIMISTIC, TransactionIsolation.REPEATABLE_READ)) {

                final SessionStorage session = getSession();

                User entity = new User();
                entity.setId(session.getUserId());
                entity.setAvatarId(IdConstant.FIRST_ID_FILE);
                entity.setName("admin");
                entity.setUserType(UserTypeEnum.ADMIN);
                entity.setInfo(new HashMap<>());

                final UserStatus userStatus = new UserStatus();
                userStatus.setLabel("В сети");
                userStatus.setUserStatusType(UserStatusTypeEnum.ONLINE);
                userStatus.setWeight(1000);
                userStatus.setColor(0x00ff00ff);

                userStatusDao.insert(session, userStatus);

                entity.setUserStatusId(userStatus.getId());
                System.out.println(entity);
                dao.insert(session, entity);
                System.out.println(entity);

                User entity2 = dao.select(entity.getId());
                Assert.assertNotNull(entity2);
                Assert.assertEquals(entity.getAvatarId(), entity2.getAvatarId());
                Assert.assertEquals(entity.getName(), entity2.getName());
                Assert.assertNull(entity2.getDeleteTime());

                entity2.setAvatarId(IdConstant.FIRST_ID_FILE + IdConstant.DELTA_ID);
                entity2.setName(entity2.getName() + "1");

                dao.update(session, entity2);
                final User entity3 = dao.select(entity.getId());
                Assert.assertNotNull(entity2);
                Assert.assertEquals(entity2.getAvatarId(), entity3.getAvatarId());
                Assert.assertEquals(entity2.getName(), entity3.getName());
                Assert.assertNull(entity3.getDeleteTime());

                dao.markAsDeleted(session, entity.getId());
                final User entity4 = dao.select(entity.getId());
                Assert.assertNotNull(entity4);
                Assert.assertNotNull(entity4.getDeleteTime());

                final Long id = dao.selectIdByName(entity.getName());
                Assert.assertNull(id);

                final Long id2 = dao.selectIdByName(entity2.getName());
                Assert.assertEquals(entity2.getId(), id2);

                tx.setRollbackOnly();
            }
        }
    }
}