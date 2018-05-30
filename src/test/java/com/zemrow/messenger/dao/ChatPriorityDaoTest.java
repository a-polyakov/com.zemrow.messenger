package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

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

            final SessionStorage session = getSession();

            final Long id1 = IdConstant.FIRST_ID_CHAT;

            System.out.println("Before insert " + id1);
            dao.insert(session, id1);
            System.out.println("After insert " + id1);

            final long priority2 = dao.select(session, id1);
            Assert.assertNotNull(priority2);
            Assert.assertEquals(1L, priority2);

            dao.update(session, id1, 2L);
            final long priority3 = dao.select(session, id1);
            Assert.assertNotNull(priority3);
            Assert.assertEquals(2L, priority3);

            dao.update(session, id1, 1L);
            final Long id2 = id1 + IdConstant.DELTA_ID;
            Assert.assertEquals(2L, dao.insert(session, id2));
            final Long id3 = id2 + IdConstant.DELTA_ID;
            Assert.assertEquals(3L, dao.insert(session, id3));
            final Long id4 = id3 + IdConstant.DELTA_ID;
            Assert.assertEquals(4L, dao.insert(session, id4));
            final Long id5 = id4 + IdConstant.DELTA_ID;
            Assert.assertEquals(5L, dao.insert(session, id5));

            dao.up(session, id5, id1);
            Assert.assertEquals(1L, (long)dao.select(session, id5));
            Assert.assertEquals(2L, (long)dao.select(session, id1));
            Assert.assertEquals(3L, (long)dao.select(session, id2));
            Assert.assertEquals(4L, (long)dao.select(session, id3));
            Assert.assertEquals(5L, (long)dao.select(session, id4));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.up(session, id5, id2);
            Assert.assertEquals(1L, (long)dao.select(session, id1));
            Assert.assertEquals(2L, (long)dao.select(session, id5));
            Assert.assertEquals(3L, (long)dao.select(session, id2));
            Assert.assertEquals(4L, (long)dao.select(session, id3));
            Assert.assertEquals(5L, (long)dao.select(session, id4));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.up(session, id3, id1);
            Assert.assertEquals(1L, (long)dao.select(session, id3));
            Assert.assertEquals(2L, (long)dao.select(session, id1));
            Assert.assertEquals(3L, (long)dao.select(session, id2));
            Assert.assertEquals(4L, (long)dao.select(session, id4));
            Assert.assertEquals(5L, (long)dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.up(session, id3, id2);
            Assert.assertEquals(1L, (long)dao.select(session, id1));
            Assert.assertEquals(2L, (long)dao.select(session, id3));
            Assert.assertEquals(3L, (long)dao.select(session, id2));
            Assert.assertEquals(4L, (long)dao.select(session, id4));
            Assert.assertEquals(5L, (long)dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id3, id4);
            Assert.assertEquals(1L, (long)dao.select(session, id1));
            Assert.assertEquals(2L, (long)dao.select(session, id2));
            Assert.assertEquals(3L, (long)dao.select(session, id4));
            Assert.assertEquals(4L, (long)dao.select(session, id3));
            Assert.assertEquals(5L, (long)dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id3, id5);
            Assert.assertEquals(1L, (long)dao.select(session, id1));
            Assert.assertEquals(2L, (long)dao.select(session, id2));
            Assert.assertEquals(3L, (long)dao.select(session, id4));
            Assert.assertEquals(4L, (long)dao.select(session, id5));
            Assert.assertEquals(5L, (long)dao.select(session, id3));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id1, id2);
            Assert.assertEquals(1L, (long)dao.select(session, id2));
            Assert.assertEquals(2L, (long)dao.select(session, id1));
            Assert.assertEquals(3L, (long)dao.select(session, id3));
            Assert.assertEquals(4L, (long)dao.select(session, id4));
            Assert.assertEquals(5L, (long)dao.select(session, id5));

            // reset
            dao.update(session, id1, 1L);
            dao.update(session, id2, 2L);
            dao.update(session, id3, 3L);
            dao.update(session, id4, 4L);
            dao.update(session, id5, 5L);

            dao.down(session, id1, id5);
            Assert.assertEquals(1L, (long)dao.select(session, id2));
            Assert.assertEquals(2L, (long)dao.select(session, id3));
            Assert.assertEquals(3L, (long)dao.select(session, id4));
            Assert.assertEquals(4L, (long)dao.select(session, id5));
            Assert.assertEquals(5L, (long)dao.select(session, id1));
        }
    }
}