package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Тест для ChatToUserDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatToUserDaoTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(ChatToUserDaoTest.class);

    @Test
    public void test() throws Exception {
        final ChatToUserDao dao = new ChatToUserDao();
        final ChatDao chatDao = new ChatDao();
        final SessionStorage session = getSession();
        final Chat chat = insertChat(chatDao, session);

        final ChatToUser entity = new ChatToUser();
        entity.setId(dao.nextId());
        entity.setChatId(chat.getId());
        entity.setUserId(session.getUserId());
        entity.setChatToUserType(ChatToUserTypeEnum.DEFAULT);
        entity.setFavorite(false);
        entity.setMute(false);
        log.debug("Before insert {}", entity);
        dao.insert(connection, session, entity);
        log.debug("After insert {}", entity);

        final ChatToUser entity2 = dao.select(connection, entity.getId());
        log.debug("Select {}", entity2);
        assertNotNull(entity2);
        assertEquals(entity.getChatId(), entity2.getChatId());
        assertEquals(entity.getUserId(), entity2.getUserId());
        assertEquals(entity.getChatToUserType(), entity2.getChatToUserType());
        assertEquals(entity.getFavorite(), entity2.getFavorite());
        assertEquals(entity.getMute(), entity2.getMute());
        assertNull(entity2.getDeleteTime());

        entity2.setChatToUserType(ChatToUserTypeEnum.HIDDEN_FULL_ACCESS);
        entity2.setFavorite(true);
        log.debug("Before update {}", entity2);
        dao.update(connection, session, entity2);
        log.debug("After update " + entity2);
        final ChatToUser entity3 = dao.select(connection, entity.getId());
        assertNotNull(entity3);
        assertEquals(entity2.getChatId(), entity3.getChatId());
        assertEquals(entity2.getUserId(), entity3.getUserId());
        assertEquals(entity2.getChatToUserType(), entity3.getChatToUserType());
        assertEquals(entity2.getFavorite(), entity3.getFavorite());
        assertNull(entity3.getDeleteTime());

        dao.markAsDeleted(connection, session, entity.getId());
        final ChatToUser entity4 = dao.select(connection, entity.getId());
        log.debug("Select after markAsDeleted {}", entity4);
        assertNotNull(entity4);
        assertNotNull(entity4.getDeleteTime());
    }
}