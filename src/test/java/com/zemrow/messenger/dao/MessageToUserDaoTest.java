package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.MessageToUser;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для MessageToUserDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class MessageToUserDaoTest extends AbstractTest {

    private MessageToUserDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new MessageToUserDao(ignite);

            final SessionStorage session = getSession();

            final MessageToUser entity = new MessageToUser();
            entity.setMessageId(IdConstant.FIRST_ID_MESSAGE);
            entity.setUserId(session.getUserId());
            entity.setMessageStatus(MessageStatusEnum.SEND);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final MessageToUser entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getMessageId(), entity2.getMessageId());
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getMessageStatus(), entity2.getMessageStatus());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setMessageStatus(MessageStatusEnum.READ);

            dao.update(session, entity2);
            final MessageToUser entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getMessageId(), entity3.getMessageId());
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getMessageStatus(), entity3.getMessageStatus());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final MessageToUser entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}