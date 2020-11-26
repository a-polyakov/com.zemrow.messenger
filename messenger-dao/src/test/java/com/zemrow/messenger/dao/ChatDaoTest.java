package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.ChatToUserLastMessage;
import com.zemrow.messenger.entity.Message;
import com.zemrow.messenger.entity.Numbering;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;
import com.zemrow.messenger.entity.enums.UserContactStatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Тест для ChatDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatDaoTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(ChatDaoTest.class);

    @Test
    public void test() throws Exception {
        final ChatDao dao = new ChatDao();
        final SessionStorage session = getSession();

        final Chat entity = new Chat();
        entity.setId(dao.nextId());
        entity.setChatType(ChatTypeEnum.CHAT);
        entity.setLabel("Chat");
        log.debug("Before insert {}", entity);
        dao.insert(connection, session, entity);
        log.debug("After insert {}", entity);

        final Chat entity2 = dao.select(connection, entity.getId());
        log.debug("Select {}", entity2);
        assertNotNull(entity2);
        assertEquals(entity.getLabel(), entity2.getLabel());
        assertEquals(session.getUserId(), entity2.getCreatedBy());
        assertNotNull(entity2.getCreateTime());
        assertEquals(session.getUserId(), entity2.getUpdatedBy());
        assertNotNull(entity2.getUpdateTime());
        assertNull(entity2.getDeletedBy());
        assertNull(entity2.getDeleteTime());

        entity2.setLabel(entity2.getLabel() + "1");
        log.debug("Before update {}", entity2);
        dao.update(connection, session, entity2);
        log.debug("After update " + entity2);
        final Chat entity3 = dao.select(connection, entity.getId());
        log.debug("Select after update {}", entity3);
        assertNotNull(entity3);
        assertEquals(entity2.getLabel(), entity3.getLabel());
        assertNull(entity3.getDeletedBy());
        assertNull(entity3.getDeleteTime());

        dao.markAsDeleted(connection, session, entity.getId());
        final Chat entity4 = dao.select(connection, entity.getId());
        log.debug("Select after markAsDeleted {}", entity4);
        assertNotNull(entity4);
        assertEquals(session.getUserId(), entity4.getDeletedBy());
        assertNotNull(entity4.getDeleteTime());

        entity4.setDeletedBy(null);
        entity4.setDeleteTime(null);
        dao.update(connection, session, entity4);
        ChatToUserDao chatToUserDao = new ChatToUserDao();
        final ChatToUser chatToUser = new ChatToUser(
                chatToUserDao.nextId(),
                entity4.getId(),
                session.getUserId(),
                false,
                ChatToUserTypeEnum.DEFAULT,
                false,
                null, null, null, null, null, null);
        chatToUserDao.insert(connection, session, chatToUser);
        UserContactDao userContactDao = new UserContactDao();
        final UserContact userContact = new UserContact(
                userContactDao.nextId(),
                session.getUserId(),
                session.getUserId(),
                UserContactStatusEnum.ACCEPT,
                String.valueOf(session.getUserId()), // TODO userName
                entity4.getId(),
                null, null, null, null, null, null
        );
        userContactDao.insert(connection, session, userContact);
        NumberingDao numberingDao = new NumberingDao();
        numberingDao.insert(connection, session, new Numbering(
                numberingDao.nextId(),
                session.getUserId(),
                "T",
                1L,
                null, null, null, null, null, null
        ));
        MessageDao messageDao = new MessageDao();
        final Message message = new Message(
                messageDao.nextId(),
                entity4.getId(),
                "test message",
                null,
                null,
                MessageTypeEnum.SIMPLE,
                null,
                null, null, null, null, null, null
        );
        messageDao.insert(connection, session, message);
        ChatToUserLastMessageDao chatToUserLastMessageDao = new ChatToUserLastMessageDao();
        chatToUserLastMessageDao.insert(connection, session, new ChatToUserLastMessage(
                chatToUser.getId(),
                message.getId()
        ));
// TODO
//        ChatTagGroupDao chatTagGroupDao = new ChatTagGroupDao();
//        MessageTagDao messageTagDao = new MessageTagDao();
//        MessageToUserDao messageToUserDao = new MessageToUserDao();
        final PageNavigationDto<ChatTiledDto> listLast = dao.listLast(connection, session, 0L, 10L);
        log.debug("Select listLast {}", listLast);
        assertNotNull(listLast);

        // TODO selectUserIdByChatId
    }
}