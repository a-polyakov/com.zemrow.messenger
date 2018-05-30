package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Tag;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import com.zemrow.messenger.entity.enums.TagTypeEnum;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для TagDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class TagDaoTest extends AbstractTest {

    private TagDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new TagDao(ignite);

            final SessionStorage session = getSession();

            final Tag entity = new Tag();
            entity.setTag("tag");
            entity.setTagType(TagTypeEnum.START);
            entity.setDescription("description");
            entity.setLeftMenuShow(true);
            entity.setHeaderShow(false);
            entity.setTagGroup(TagGroupEnum.WORK_LOG);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final Tag entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getTag(), entity2.getTag());
            Assert.assertEquals(entity.getTagType(), entity2.getTagType());
            Assert.assertEquals(entity.getDescription(), entity2.getDescription());
            Assert.assertEquals(entity.getLeftMenuShow(), entity2.getLeftMenuShow());
            Assert.assertEquals(entity.getHeaderShow(), entity2.getHeaderShow());
            Assert.assertEquals(entity.getTagGroup(), entity2.getTagGroup());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setDescription(entity2.getDescription() + "1");

            dao.update(session, entity2);
            final Tag entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getTag(), entity3.getTag());
            Assert.assertEquals(entity2.getTagType(), entity3.getTagType());
            Assert.assertEquals(entity2.getDescription(), entity3.getDescription());
            Assert.assertEquals(entity2.getLeftMenuShow(), entity3.getLeftMenuShow());
            Assert.assertEquals(entity2.getHeaderShow(), entity3.getHeaderShow());
            Assert.assertEquals(entity2.getTagGroup(), entity3.getTagGroup());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final Tag entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}