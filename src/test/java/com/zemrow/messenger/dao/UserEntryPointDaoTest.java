package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserEntryPointDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserEntryPointDaoTest extends AbstractTest {

    private UserEntryPointDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new UserEntryPointDao(ignite);

            final SessionStorage session = getSession();

            final UserEntryPoint entity = new UserEntryPoint();
            entity.setUserId(session.getUserId());
            entity.setValidate(true);
            entity.setEntryPointType(EntryPointTypeEnum.LOGIN_PASSWORD);
            entity.setClientId("login");
            entity.setCredential("password");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserEntryPoint entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getValidate(), entity2.getValidate());
            Assert.assertEquals(entity.getEntryPointType(), entity2.getEntryPointType());
            Assert.assertEquals(entity.getClientId(), entity2.getClientId());
            Assert.assertEquals(entity.getCredential(), entity2.getCredential());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setCredential(entity2.getCredential() + "1");
//
            dao.update(session, entity2);
            final UserEntryPoint entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getValidate(), entity3.getValidate());
            Assert.assertEquals(entity2.getEntryPointType(), entity3.getEntryPointType());
            Assert.assertEquals(entity2.getClientId(), entity3.getClientId());
            Assert.assertEquals(entity2.getCredential(), entity3.getCredential());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final UserEntryPoint entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}