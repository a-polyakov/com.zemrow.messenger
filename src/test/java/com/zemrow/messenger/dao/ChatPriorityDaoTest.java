package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.ChatPriority;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Тест для ChatPriorityDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class ChatPriorityDaoTest extends AbstractTest {

    private ChatPriorityDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new ChatPriorityDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final UUID uuid = UUID.randomUUID();

            final ChatPriority entity1 = new ChatPriority();
            entity1.setId(new IgniteUuid(uuid, 1L));
            entity1.setPriority(1L);

            final IgniteUuid id1 = entity1.getId();
            System.out.println("Before insert " + entity1);
            dao.insert(session, id1, entity1.getPriority());
            System.out.println("After insert " + entity1);

            final Long priority2 = dao.select(session, id1);
            Assert.assertNotNull(priority2);
            Assert.assertEquals(entity1.getPriority(), priority2);

            entity1.setPriority(entity1.getPriority() + 1);

            dao.update(session, id1, entity1.getPriority());
            final Long priority3 = dao.select(session, id1);
            Assert.assertNotNull(priority3);
            Assert.assertEquals(entity1.getPriority(), priority3);

            dao.update(session, id1, 1L);
            final IgniteUuid id2 = new IgniteUuid(uuid, 2L);
            dao.insert(session, id2, 2L);
            final IgniteUuid id3 = new IgniteUuid(uuid, 3L);
            dao.insert(session, id3, 3L);
            final IgniteUuid id4 = new IgniteUuid(uuid, 4L);
            dao.insert(session, id4, 4L);
            final IgniteUuid id5 = new IgniteUuid(uuid, 5L);
            dao.insert(session, id5, 5L);

            dao.up(session, id5, id1);
            Assert.assertEquals(1L, (long) dao.select(session, id5));
            Assert.assertEquals(2L, (long) dao.select(session, id1));
            Assert.assertEquals(3L, (long) dao.select(session, id2));
            Assert.assertEquals(4L, (long) dao.select(session, id3));
            Assert.assertEquals(5L, (long) dao.select(session, id4));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.up(session, id5, id2);
            Assert.assertEquals(1L, (long) dao.select(session, id1));
            Assert.assertEquals(2L, (long) dao.select(session, id5));
            Assert.assertEquals(3L, (long) dao.select(session, id2));
            Assert.assertEquals(4L, (long) dao.select(session, id3));
            Assert.assertEquals(5L, (long) dao.select(session, id4));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.up(session, id3, id1);
            Assert.assertEquals(1L, (long) dao.select(session, id3));
            Assert.assertEquals(2L, (long) dao.select(session, id1));
            Assert.assertEquals(3L, (long) dao.select(session, id2));
            Assert.assertEquals(4L, (long) dao.select(session, id4));
            Assert.assertEquals(5L, (long) dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.up(session, id3, id2);
            Assert.assertEquals(1L, (long) dao.select(session, id1));
            Assert.assertEquals(2L, (long) dao.select(session, id3));
            Assert.assertEquals(3L, (long) dao.select(session, id2));
            Assert.assertEquals(4L, (long) dao.select(session, id4));
            Assert.assertEquals(5L, (long) dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id3, id4);
            Assert.assertEquals(1L, (long) dao.select(session, id1));
            Assert.assertEquals(2L, (long) dao.select(session, id2));
            Assert.assertEquals(3L, (long) dao.select(session, id4));
            Assert.assertEquals(4L, (long) dao.select(session, id3));
            Assert.assertEquals(5L, (long) dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id3, id5);
            Assert.assertEquals(1L, (long) dao.select(session, id1));
            Assert.assertEquals(2L, (long) dao.select(session, id2));
            Assert.assertEquals(3L, (long) dao.select(session, id4));
            Assert.assertEquals(4L, (long) dao.select(session, id5));
            Assert.assertEquals(5L, (long) dao.select(session, id3));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id1, id2);
            Assert.assertEquals(1L, (long) dao.select(session, id2));
            Assert.assertEquals(2L, (long) dao.select(session, id1));
            Assert.assertEquals(3L, (long) dao.select(session, id3));
            Assert.assertEquals(4L, (long) dao.select(session, id4));
            Assert.assertEquals(5L, (long) dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id1, id5);
            Assert.assertEquals(1L, (long) dao.select(session, id2));
            Assert.assertEquals(2L, (long) dao.select(session, id3));
            Assert.assertEquals(3L, (long) dao.select(session, id4));
            Assert.assertEquals(4L, (long) dao.select(session, id5));
            Assert.assertEquals(5L, (long) dao.select(session, id1));
        }
    }
}