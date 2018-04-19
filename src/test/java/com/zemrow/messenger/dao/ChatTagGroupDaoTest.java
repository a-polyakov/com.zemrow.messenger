package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.ChatTagGroup;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для ChatTagGroupDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatTagGroupDaoTest extends AbstractTest {

    private ChatTagGroupDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new ChatTagGroupDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final ChatTagGroup entity = new ChatTagGroup();
            entity.setChatId(IgniteUuid.randomUuid());
            entity.setTagGroup(TagGroupEnum.STATUS);
            entity.setMessageTagId(IgniteUuid.randomUuid());

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final ChatTagGroup entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getChatId(), entity2.getChatId());
            Assert.assertEquals(entity.getTagGroup(), entity2.getTagGroup());
            Assert.assertEquals(entity.getMessageTagId(), entity2.getMessageTagId());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setMessageTagId(IgniteUuid.randomUuid());

            dao.update(session, entity2);
            final ChatTagGroup entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getChatId(), entity3.getChatId());
            Assert.assertEquals(entity2.getTagGroup(), entity3.getTagGroup());
            Assert.assertNotEquals(entity2.getMessageTagId(), entity3.getMessageTagId());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final ChatTagGroup entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}