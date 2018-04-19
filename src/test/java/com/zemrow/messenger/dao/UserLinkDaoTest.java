package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserLink;
import com.zemrow.messenger.entity.enums.UserLinkEnum;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserLinkDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserLinkDaoTest extends AbstractTest {

    private UserLinkDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new UserLinkDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final UserLink entity = new UserLink();
            entity.setParentUserId(IgniteUuid.randomUuid());
            entity.setChildUserId(IgniteUuid.randomUuid());
            entity.setUserLinkType(UserLinkEnum.CONTAINS);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserLink entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getParentUserId(), entity2.getParentUserId());
            Assert.assertEquals(entity.getChildUserId(), entity2.getChildUserId());
            Assert.assertEquals(entity.getUserLinkType(), entity2.getUserLinkType());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setUserLinkType(UserLinkEnum.SECRETARY);
//
            dao.update(session, entity2);
            final UserLink entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getParentUserId(), entity3.getParentUserId());
            Assert.assertEquals(entity2.getChildUserId(), entity3.getChildUserId());
            Assert.assertEquals(entity2.getUserLinkType(), entity3.getUserLinkType());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final UserLink entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}