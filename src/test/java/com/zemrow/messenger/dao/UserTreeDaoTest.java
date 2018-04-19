package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserTree;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteBiTuple;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserTreeDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserTreeDaoTest extends AbstractTest {

    private UserTreeDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new UserTreeDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final UserTree entity = new UserTree();
            entity.setParentUserId(IgniteUuid.randomUuid());
            entity.setChildUserId(IgniteUuid.randomUuid());
            entity.setDistance(1);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final IgniteBiTuple id = new IgniteBiTuple(entity.getParentUserId(), entity.getChildUserId());
            final UserTree entity2 = dao.select(session, id);
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getParentUserId(), entity2.getParentUserId());
            Assert.assertEquals(entity.getChildUserId(), entity2.getChildUserId());
            Assert.assertEquals(entity.getDistance(), entity2.getDistance());

            dao.delete(session, id);
            final UserTree entity3 = dao.select(session, id);
            Assert.assertNull(entity3);
        }
    }
}