package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.ChatTree;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteBiTuple;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для ChatTreeDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatTreeDaoTest extends AbstractTest {

    private ChatTreeDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new ChatTreeDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final ChatTree entity = new ChatTree();
            entity.setParentChatId(IgniteUuid.randomUuid());
            entity.setChildChatId(IgniteUuid.randomUuid());
            entity.setDistance(1);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final IgniteBiTuple id = new IgniteBiTuple(entity.getParentChatId(), entity.getChildChatId());
            final ChatTree entity2 = dao.select(session, id);
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getParentChatId(), entity2.getParentChatId());
            Assert.assertEquals(entity.getChildChatId(), entity2.getChildChatId());
            Assert.assertEquals(entity.getDistance(), entity2.getDistance());

            dao.delete(session, id);
            final ChatTree entity3 = dao.select(session, id);
            Assert.assertNull(entity3);
        }
    }
}