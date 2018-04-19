package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.Message;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для MessageDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class MessageDaoTest extends AbstractTest {

    private MessageDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new MessageDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final Message entity = new Message();
            entity.setChatId(IgniteUuid.randomUuid());
            entity.setText("text");
            entity.setMessageType(MessageTypeEnum.SIMPLE);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final Message entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getChatId(), entity2.getChatId());
            Assert.assertEquals(entity.getText(), entity2.getText());
            Assert.assertEquals(entity.getMessageType(), entity2.getMessageType());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setText(entity2.getText() + "1");

            dao.update(session, entity2);
            final Message entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getChatId(), entity3.getChatId());
            Assert.assertEquals(entity2.getText(), entity3.getText());
            Assert.assertEquals(entity2.getMessageType(), entity3.getMessageType());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final Message entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}