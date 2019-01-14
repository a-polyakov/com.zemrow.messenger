package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatToUserLastMessage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для ChatToUserLastMessageDao
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatToUserLastMessageDaoTest extends AbstractTest {

    private ChatToUserLastMessageDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new ChatToUserLastMessageDao(dataBase);

            final SessionStorage session = getSession();

            final ChatToUserLastMessage entity = new ChatToUserLastMessage();
            entity.setChatToUserId(IdConstant.FIRST_ID_CHAT_TO_USER);
            entity.setMessageId(IdConstant.FIRST_ID_MESSAGE);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final ChatToUserLastMessage entity2 = dao.select(entity.getKey());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getChatToUserId(), entity2.getChatToUserId());
            Assert.assertEquals(entity.getMessageId(), entity2.getMessageId());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setMessageId(IdConstant.FIRST_ID_MESSAGE + IdConstant.DELTA_ID);

            dao.update(session, entity2);
            final ChatToUserLastMessage entity3 = dao.select(entity.getKey());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getChatToUserId(), entity3.getChatToUserId());
            Assert.assertEquals(entity2.getMessageId(), entity3.getMessageId());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final ChatToUserLastMessage entity4 = dao.select(entity.getKey());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}