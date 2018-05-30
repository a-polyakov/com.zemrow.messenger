package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.UserContact;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для UserContactDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserContactDaoTest extends AbstractTest {

    private UserContactDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new UserContactDao(ignite);

            final SessionStorage session = getSession();

            final UserContact entity = new UserContact();
            entity.setParentUserId(session.getUserId());
            entity.setChildUserId(session.getUserId() + IdConstant.DELTA_ID);
            entity.setLabel("contact");
            entity.setFavorite(false);
            entity.setChatId(IdConstant.FIRST_ID_CHAT);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final UserContact entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getParentUserId(), entity2.getParentUserId());
            Assert.assertEquals(entity.getChildUserId(), entity2.getChildUserId());
            Assert.assertEquals(entity.getLabel(), entity2.getLabel());
            Assert.assertEquals(entity.isFavorite(), entity2.isFavorite());
            Assert.assertEquals(entity.getChatId(), entity2.getChatId());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setLabel(entity2.getLabel() + "1");
//
            dao.update(session, entity2);
            final UserContact entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getParentUserId(), entity3.getParentUserId());
            Assert.assertEquals(entity2.getChildUserId(), entity3.getChildUserId());
            Assert.assertEquals(entity2.getLabel(), entity3.getLabel());
            Assert.assertEquals(entity2.isFavorite(), entity3.isFavorite());
            Assert.assertEquals(entity2.getChatId(), entity3.getChatId());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final UserContact entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}