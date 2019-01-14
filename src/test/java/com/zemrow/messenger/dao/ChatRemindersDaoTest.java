package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatReminders;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для ChatRemindersDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatRemindersDaoTest extends AbstractTest {

    private ChatRemindersDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new ChatRemindersDao(dataBase);

            final SessionStorage session = getSession();

            final ChatReminders entity = new ChatReminders();
            entity.setChatId(IdConstant.FIRST_ID_CHAT);
            entity.setUserId(session.getUserId());
            entity.setText("Test Reminders");
            entity.setDateTime(System.currentTimeMillis() + 60000);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final ChatReminders entity2 = dao.select(entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getChatId(), entity2.getChatId());
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getText(), entity2.getText());
            Assert.assertEquals(entity.getDateTime(), entity2.getDateTime());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setText(entity2.getText() + "1");

            dao.update(session, entity2);
            final ChatReminders entity3 = dao.select(entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getChatId(), entity3.getChatId());
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getText(), entity3.getText());
            Assert.assertEquals(entity2.getDateTime(), entity3.getDateTime());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final ChatReminders entity4 = dao.select(entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}