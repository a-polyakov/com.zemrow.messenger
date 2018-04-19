package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.MessageTag;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для MessageTagDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class MessageTagDaoTest extends AbstractTest {

    private MessageTagDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new MessageTagDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final MessageTag entity = new MessageTag();
            entity.setMessageId(IgniteUuid.randomUuid());
            entity.setTagId(IgniteUuid.randomUuid());
            entity.setValue("value");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final MessageTag entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getMessageId(), entity2.getMessageId());
            Assert.assertEquals(entity.getTagId(), entity2.getTagId());
            Assert.assertEquals(entity.getValue(), entity2.getValue());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setValue(entity2.getValue() + "1");

            dao.update(session, entity2);
            final MessageTag entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getMessageId(), entity3.getMessageId());
            Assert.assertEquals(entity2.getTagId(), entity3.getTagId());
            Assert.assertEquals(entity2.getValue(), entity3.getValue());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final MessageTag entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}