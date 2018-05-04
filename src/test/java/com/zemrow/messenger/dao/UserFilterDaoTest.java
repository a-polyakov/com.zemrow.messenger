package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.UserFilter;
import com.zemrow.messenger.entity.enums.FilterGridEnum;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserFilterDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserFilterDaoTest extends AbstractTest {

    private UserFilterDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new UserFilterDao(ignite);

            final SessionStorage session = getSession();

            final UserFilter entity = new UserFilter();
            entity.setUserId(session.getUserId());
            entity.setGridId(FilterGridEnum.MY_ISSUE_LIST);
            entity.setFilterId("test");
            entity.setData("{}");

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserFilter entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getUserId(), entity2.getUserId());
            Assert.assertEquals(entity.getGridId(), entity2.getGridId());
            Assert.assertEquals(entity.getFilterId(), entity2.getFilterId());
            Assert.assertEquals(entity.getData(), entity2.getData());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setData("{status:'ACTIVE'}");
//
            dao.update(session, entity2);
            final UserFilter entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getUserId(), entity3.getUserId());
            Assert.assertEquals(entity2.getGridId(), entity3.getGridId());
            Assert.assertEquals(entity2.getFilterId(), entity3.getFilterId());
            Assert.assertEquals(entity2.getData(), entity3.getData());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final UserFilter entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}