package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.MessageLog;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для MessageLogDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class MessageLogDaoTest extends AbstractTest {

    private MessageLogDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new MessageLogDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final MessageLog entity = new MessageLog();
            entity.setMessageId(IgniteUuid.randomUuid());
            entity.setOldText("text");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final MessageLog entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getMessageId(), entity2.getMessageId());
            Assert.assertEquals(entity.getOldText(), entity2.getOldText());
        }
    }
}