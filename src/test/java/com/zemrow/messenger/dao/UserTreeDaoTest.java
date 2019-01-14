package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserTree;
import com.zemrow.messenger.entity.UserTreeKey;
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
        try (final DataBase DataBase = getDataBase()) {
            dao = new UserTreeDao(DataBase);

            final SessionStorage session = getSession();

            final UserTree entity = new UserTree();
            entity.setParentUserId(session.getUserId());
            entity.setChildUserId(session.getUserId() + IdConstant.DELTA_ID);
            entity.setDistance(1);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserTreeKey id = entity.getKey();
            final UserTree entity2 = dao.select(id);
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getParentUserId(), entity2.getParentUserId());
            Assert.assertEquals(entity.getChildUserId(), entity2.getChildUserId());
            Assert.assertEquals(entity.getDistance(), entity2.getDistance());

            dao.delete(session, id);
            final UserTree entity3 = dao.select(id);
            Assert.assertNull(entity3);
        }
    }
}