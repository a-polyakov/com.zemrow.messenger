package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserSessionFail;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserSessionFailDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserSessionFailDaoTest extends AbstractTest {

    private UserSessionFailDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new UserSessionFailDao(dataBase);

            final SessionStorage session = getSession();

            final UserSessionFail entity = new UserSessionFail();
            entity.setUserEntryPointId(IdConstant.FIRST_ID_USER_ENTRY_POINT);
            entity.setIpAddress("123.123.123.123");
            entity.setComment("test");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserSessionFail entity2 = dao.select(entity.getKey());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getUserEntryPointId(), entity2.getUserEntryPointId());
            Assert.assertEquals(entity.getIpAddress(), entity2.getIpAddress());
            Assert.assertEquals(entity.getComment(), entity2.getComment());

            dao.delete(session, entity.getKey());
            final UserSessionFail entity3 = dao.select(entity.getKey());
            Assert.assertNull(entity3);
        }
    }
}