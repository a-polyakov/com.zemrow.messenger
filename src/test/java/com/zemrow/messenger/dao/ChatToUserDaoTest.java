package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для ChatToUserDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatToUserDaoTest extends AbstractTest {

    private ChatToUserDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new ChatToUserDao(ignite);

            final SessionStorage session = getSession();

            final ChatToUser entity = new ChatToUser();
            entity.setChatId(IdConstant.FIRST_ID_CHAT);
            entity.setUserId(session.getUserId());
            entity.setChatToUserType(ChatToUserTypeEnum.DEFAULT);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final ChatToUser entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getChatId(), entity2.getChatId());
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getChatToUserType(), entity2.getChatToUserType());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setChatToUserType(ChatToUserTypeEnum.HIDDEN_FULL_ACCESS);

            dao.update(session, entity2);
            final ChatToUser entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getChatId(), entity3.getChatId());
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getChatToUserType(), entity3.getChatToUserType());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final ChatToUser entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}