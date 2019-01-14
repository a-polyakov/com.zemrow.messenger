package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.MessageLog;
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
        try (final DataBase dataBase = getDataBase()) {
            dao = new MessageLogDao(dataBase);

            final SessionStorage session = getSession();
            final MessageLog entity = new MessageLog();
            entity.setMessageId(IdConstant.FIRST_ID_MESSAGE);
            entity.setOldText("text");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final MessageLog entity2 = dao.select(entity.getKey());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getMessageId(), entity2.getMessageId());
            Assert.assertEquals(entity.getOldText(), entity2.getOldText());
        }
    }
}