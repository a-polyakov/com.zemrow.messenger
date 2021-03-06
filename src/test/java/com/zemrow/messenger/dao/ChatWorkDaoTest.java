package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatWork;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для ChatWorkDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatWorkDaoTest extends AbstractTest {

    private ChatWorkDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new ChatWorkDao(dataBase);

            final SessionStorage session = getSession();

            final ChatWork entity = new ChatWork();
            entity.setChatId(IdConstant.FIRST_ID_CHAT);
            entity.setUserId(session.getUserId());
            entity.setStartTime(System.currentTimeMillis());

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final ChatWork entity2 = dao.select(entity.getKey());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getChatId(), entity2.getChatId());
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getStartTime(), entity2.getStartTime());
            Assert.assertNull(entity2.getEndTime());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setEndTime(System.currentTimeMillis());

            dao.update(session, entity2);
            final ChatWork entity3 = dao.select(entity.getKey());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getChatId(), entity3.getChatId());
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getStartTime(), entity3.getStartTime());
            Assert.assertEquals(entity2.getEndTime(), entity3.getEndTime());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final ChatWork entity4 = dao.select(entity.getKey());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}