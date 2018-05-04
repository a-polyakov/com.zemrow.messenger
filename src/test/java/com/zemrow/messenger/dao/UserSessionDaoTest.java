package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserSession;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserSessionDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserSessionDaoTest extends AbstractTest {

    private UserSessionDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new UserSessionDao(ignite);

            final SessionStorage session = getSession();

            final UserSession entity = new UserSession();
            entity.setUserEntryPointId(IdConstant.FIRST_ID_USER_ENTRY_POINT);
            entity.setToken("token");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserSession entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getUserEntryPointId(), entity2.getUserEntryPointId());
            Assert.assertEquals(entity.getToken(), entity2.getToken());
            Assert.assertNull(entity2.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final UserSession entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertNotNull(entity3.getDeleteTime());
        }
    }
}