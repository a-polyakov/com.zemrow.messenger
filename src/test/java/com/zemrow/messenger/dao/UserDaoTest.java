package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import java.util.HashMap;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserDaoTest extends AbstractTest {

    private UserDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new UserDao(ignite);
            final UserStatusDao userStatusDao = new UserStatusDao(ignite);

            //TODO при наличии транзакции не выполняется sql
//            try (Transaction tx = ignite.transactions().txStart(TransactionConcurrency.PESSIMISTIC, TransactionIsolation.REPEATABLE_READ)) {

            final SessionStorage session = getSession();

            User entity = new User();
            entity.setId(session.getUserId());
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

            User entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getName(), entity2.getName());
            Assert.assertNull(entity2.getDeleteTime());
            entity2.setName(entity2.getName() + "1");
//
//        final long count2 = dao.selectCount(session, null);
//        Assert.assertTrue(count + 1 == count2);
//
            dao.update(session, entity2);
            final User entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity2.getName(), entity3.getName());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final User entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());

            final Long id = dao.selectIdByName(session, entity.getName());
            Assert.assertNull(id);

            final Long id2 = dao.selectIdByName(session, entity2.getName());
            Assert.assertNotNull(id2);

//                tx.setRollbackOnly();
//            }
        }
    }
}