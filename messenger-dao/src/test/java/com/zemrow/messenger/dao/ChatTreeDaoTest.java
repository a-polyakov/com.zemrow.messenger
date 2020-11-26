package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.ChatTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Тест для ChatTreeDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatTreeDaoTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(ChatTreeDaoTest.class);

    @Test
    public void test() throws Exception {
        final ChatTreeDao dao = new ChatTreeDao();
        final ChatDao chatDao = new ChatDao();
        final SessionStorage session = getSession();
        final Chat chat1 = insertChat(chatDao, session);
        final Chat chat2 = insertChat(chatDao, session);

        final ChatTree entity = new ChatTree();
        entity.setParentChatId(chat1.getId());
        entity.setChildChatId(chat2.getId());
        entity.setDistance(1);
        log.debug("Before insert {}", entity);
        dao.insert(connection, session, entity);
        log.debug("After insert {}", entity);

        final ChatTree entity2 = dao.select(connection, entity.getParentChatId(), entity.getChildChatId());
        log.debug("Select {}", entity2);
        assertNotNull(entity2);
        assertEquals(entity.getParentChatId(), entity2.getParentChatId());
        assertEquals(entity.getChildChatId(), entity2.getChildChatId());
        assertEquals(entity.getDistance(), entity2.getDistance());

        dao.delete(connection, entity.getParentChatId(), entity.getChildChatId());
        final ChatTree entity3 = dao.select(connection, entity.getParentChatId(), entity.getChildChatId());
        log.debug("Select after deleted {}", entity3);
        assertNull(entity3);
    }
}