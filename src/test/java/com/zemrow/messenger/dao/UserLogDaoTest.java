package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserLog;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserLogDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserLogDaoTest extends AbstractTest {

    private UserLogDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new UserLogDao(dataBase);

            final SessionStorage session = getSession();

            final UserLog entity = new UserLog();
            entity.setUserId(session.getUserId());
            entity.setFieldName("name");
            entity.setFieldOldValue("name1");
            entity.setFieldNewValue("name2");
            entity.setComment("rename");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserLog entity2 = dao.select(entity.getKey());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getFieldName(), entity2.getFieldName());
            Assert.assertEquals(entity.getFieldOldValue(), entity2.getFieldOldValue());
            Assert.assertEquals(entity.getFieldNewValue(), entity2.getFieldNewValue());
            Assert.assertEquals(entity.getComment(), entity2.getComment());

            dao.delete(session, entity.getKey());
            final UserLog entity3 = dao.select(entity.getKey());
            Assert.assertNull(entity3);
        }
    }
}