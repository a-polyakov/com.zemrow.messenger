package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
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
        try (final DataBase dataBase = getDataBase()) {
            dao = new UserEntryPointDao(dataBase);

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

            final UserEntryPoint entity2 = dao.select(entity.getId());
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
            final UserEntryPoint entity3 = dao.select(entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getValidate(), entity3.getValidate());
            Assert.assertEquals(entity2.getEntryPointType(), entity3.getEntryPointType());
            Assert.assertEquals(entity2.getClientId(), entity3.getClientId());
            Assert.assertEquals(entity2.getCredential(), entity3.getCredential());
            Assert.assertNull(entity3.getDeleteTime());

            UserEntryPoint entity4 = dao.selectByLoginAndPassword(entity.getClientId(), entity.getCredential());
            Assert.assertNull(entity4);

            entity4 = dao.selectByLoginAndPassword(entity2.getClientId(), entity2.getCredential());
            Assert.assertNotNull(entity4);
            Assert.assertEquals(entity2.getId(), entity4.getId());
            Assert.assertEquals(entity2.getValidate(), entity4.getValidate());
            Assert.assertEquals(entity2.getEntryPointType(), entity4.getEntryPointType());
            Assert.assertEquals(entity2.getClientId(), entity4.getClientId());
            Assert.assertEquals(entity2.getCredential(), entity4.getCredential());
            Assert.assertNull(entity4.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final UserEntryPoint entity5 = dao.select(entity.getId());
            Assert.assertNotNull(entity5);
            Assert.assertNotNull(entity5.getDeleteTime());
        }
    }
}