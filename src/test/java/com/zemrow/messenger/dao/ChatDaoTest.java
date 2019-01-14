package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Chat;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для ChatDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatDaoTest extends AbstractTest {

    private ChatDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new ChatDao(dataBase);

            final SessionStorage session = getSession();

            final Chat entity = new Chat();
            entity.setLabel("Chat");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final Chat entity2 = dao.select(entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getLabel(), entity2.getLabel());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setLabel(entity2.getLabel() + "1");

            dao.update(session, entity2);
            final Chat entity3 = dao.select(entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getLabel(), entity3.getLabel());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final Chat entity4 = dao.select(entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}