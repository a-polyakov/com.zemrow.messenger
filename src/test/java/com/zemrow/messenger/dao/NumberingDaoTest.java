package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Numbering;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для NumberingDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class NumberingDaoTest extends AbstractTest {

    private NumberingDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new NumberingDao(ignite);

            final SessionStorage session = getSession();

            final Numbering entity = new Numbering();
            entity.setUserId(session.getUserId());
            entity.setChatType(ChatTypeEnum.ISSUE);
            entity.setPrefix("ISSUE");
            entity.setMaxNumber(123L);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final Numbering entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getChatType(), entity2.getChatType());
            Assert.assertEquals(entity.getPrefix(), entity2.getPrefix());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setPrefix(entity2.getPrefix() + "1");

            dao.update(session, entity2);
            final Numbering entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getChatType(), entity3.getChatType());
            Assert.assertEquals(entity2.getPrefix(), entity3.getPrefix());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final Numbering entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}