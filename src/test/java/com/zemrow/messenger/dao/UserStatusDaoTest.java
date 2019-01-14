package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserStatusDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserStatusDaoTest extends AbstractTest {

    private UserStatusDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new UserStatusDao(dataBase);

            final SessionStorage session = getSession();

            final UserStatus entity = new UserStatus();
            entity.setLabel("В сети");
            entity.setUserStatusType(UserStatusTypeEnum.ONLINE);
            entity.setWeight(1000);
            entity.setColor(0x00ff00ff);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            UserStatus entity2 = dao.select(entity.getKey());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getLabel(), entity2.getLabel());
            Assert.assertEquals(entity.getUserStatusType(), entity2.getUserStatusType());
            Assert.assertNull(entity2.getDeleteTime());

            Long selectId = dao.selectIdByType(session, UserStatusTypeEnum.OFFLINE);
            Assert.assertNull(selectId);

            selectId = dao.selectIdByType(session, UserStatusTypeEnum.ONLINE);
            Assert.assertEquals(entity.getId(), selectId);

            entity2.setLabel(entity2.getLabel() + "1");
//
            dao.update(session, entity2);
            final UserStatus entity3 = dao.select(entity.getKey());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity2.getLabel(), entity3.getLabel());
            Assert.assertEquals(entity2.getUserStatusType(), entity3.getUserStatusType());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final UserStatus entity4 = dao.select(entity.getKey());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}