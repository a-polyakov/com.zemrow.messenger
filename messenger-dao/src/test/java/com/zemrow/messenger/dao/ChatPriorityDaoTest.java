package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.ChatPriority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Тест для ChatPriorityDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatPriorityDaoTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(ChatPriorityDaoTest.class);


    @Test
    public void test() throws Exception {
        final ChatPriorityDao dao = new ChatPriorityDao();

        final SessionStorage session = getSession();

        final ChatDao chatDao = new ChatDao();
        final Chat chat1 = insertChat(chatDao, session);

        final ChatPriority entity = new ChatPriority();
        entity.setChatId(chat1.getId());
        log.debug("Before insert {}", entity);
        dao.insert(connection, session, entity);
        log.debug("After insert {}", entity);

        final long priority1 = dao.selectPriorityByChatId(connection, chat1.getId());
        log.debug("selectPriorityByChatId {}", priority1);
        assertNotNull(priority1);

        final Chat chat2 = insertChat(chatDao, session);
        final long priority2 = insertChatPriority(dao, session, chat2);
        final Chat chat3 = insertChat(chatDao, session);
        final long priority3 = insertChatPriority(dao, session, chat3);
        final Chat chat4 = insertChat(chatDao, session);
        final long priority4 = insertChatPriority(dao, session, chat4);
        final Chat chat5 = insertChat(chatDao, session);
        final long priority5 = insertChatPriority(dao, session, chat5);
        // up the last item to first place
        // dao.up(5, 1);
        dao.up(connection, session, chat5.getId(), chat1.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat2.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat3.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat4.getId()));
        // up the last item to second place
        // dao.up(5, 2);
        dao.up(connection, session, chat4.getId(), chat1.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat4.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat2.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat3.getId()));
        // up the internally item to first place
        // dao.up(3, 1);
        dao.up(connection, session, chat1.getId(), chat5.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat4.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat2.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat3.getId()));
        // up the internally item to second place
        // dao.up(3, 2);
        dao.up(connection, session, chat4.getId(), chat5.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat4.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat2.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat3.getId()));

        // down the internally item to penultimate place
        // dao.down(3, 4);
        dao.down(connection, session, chat5.getId(), chat2.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat4.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat2.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat3.getId()));
        // down the internally item to last place
        // dao.down(3, 5);
        dao.down(connection, session, chat2.getId(), chat3.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat4.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat3.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat2.getId()));
        // down the first item to second place
        // dao.down(1, 2);
        dao.down(connection, session, chat1.getId(), chat4.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat4.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat3.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat2.getId()));
        // down the first item to last place
        // dao.down(1, 5);
        dao.down(connection, session, chat4.getId(), chat2.getId());
        assertEquals(priority1, dao.selectPriorityByChatId(connection, chat1.getId()));
        assertEquals(priority2, dao.selectPriorityByChatId(connection, chat5.getId()));
        assertEquals(priority3, dao.selectPriorityByChatId(connection, chat3.getId()));
        assertEquals(priority4, dao.selectPriorityByChatId(connection, chat2.getId()));
        assertEquals(priority5, dao.selectPriorityByChatId(connection, chat4.getId()));
    }

    public Long insertChatPriority(ChatPriorityDao chatPriorityDao, SessionStorage session, Chat chat) {
        final ChatPriority entity = new ChatPriority();
        entity.setChatId(chat.getId());
        chatPriorityDao.insert(connection, session, entity);
        return chatPriorityDao.selectPriorityByChatId(connection, chat.getId());
    }
}