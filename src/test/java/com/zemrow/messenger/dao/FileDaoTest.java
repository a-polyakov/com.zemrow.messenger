package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.File;
import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Тест для FileDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class FileDaoTest extends AbstractTest {

    private FileDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new FileDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IgniteUuid.randomUuid());

            final File entity = new File();
            entity.setName("file");
            entity.setMimeType("text");
            entity.setFileSize(1000L);
            entity.setPath(UUID.randomUUID().toString());
            entity.setFileAccessType(FileAccessTypeEnum.MESSAGE);
            entity.setCrc32(2000);
            entity.setLastOpenTime(System.currentTimeMillis());
            entity.setGzipOn(false);

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final File entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getName(), entity2.getName());
            Assert.assertEquals(entity.getMimeType(), entity2.getMimeType());
            Assert.assertEquals(entity.getFileSize(), entity2.getFileSize());
            Assert.assertEquals(entity.getPath(), entity2.getPath());
            Assert.assertEquals(entity.getFileAccessType(), entity2.getFileAccessType());
            Assert.assertEquals(entity.getCrc32(), entity2.getCrc32());
            Assert.assertEquals(entity.getLastOpenTime(), entity2.getLastOpenTime());
            Assert.assertEquals(entity.getGzipOn(), entity2.getGzipOn());
            Assert.assertNull(entity2.getDeleteTime());

            entity2.setName(entity2.getName() + "1");

            dao.update(session, entity2);
            final File entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getName(), entity3.getName());
            Assert.assertEquals(entity2.getMimeType(), entity3.getMimeType());
            Assert.assertEquals(entity2.getFileSize(), entity3.getFileSize());
            Assert.assertEquals(entity2.getPath(), entity3.getPath());
            Assert.assertEquals(entity2.getFileAccessType(), entity3.getFileAccessType());
            Assert.assertEquals(entity2.getCrc32(), entity3.getCrc32());
            Assert.assertEquals(entity2.getLastOpenTime(), entity3.getLastOpenTime());
            Assert.assertEquals(entity2.getGzipOn(), entity3.getGzipOn());
            Assert.assertNull(entity3.getDeleteTime());

            dao.markAsDeleted(session, entity.getId());
            final File entity4 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity4);
            Assert.assertNotNull(entity4.getDeleteTime());
        }
    }
}