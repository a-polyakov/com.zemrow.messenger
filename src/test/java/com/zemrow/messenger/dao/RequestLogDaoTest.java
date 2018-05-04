package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.RequestLog;
import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для RequestLogDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class RequestLogDaoTest extends AbstractTest {

    private RequestLogDao dao;

    @Test
    public void test() {
        try (final Ignite ignite = getIgnite()) {
            dao = new RequestLogDao(ignite);

            final SessionStorage session = getSession();

            final RequestLog entity = new RequestLog();
            entity.setToken("token");
            entity.setServiceId("service");
            entity.setAction("action");
            entity.setStartInvoke(System.currentTimeMillis());

            System.out.println("Before insert " + entity);
            dao.insert(session, entity);
            System.out.println("After insert " + entity);

            final RequestLog entity2 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity2);
            Assert.assertEquals(entity.getToken(), entity2.getToken());
            Assert.assertEquals(entity.getServiceId(), entity2.getServiceId());
            Assert.assertEquals(entity.getAction(), entity2.getAction());
            Assert.assertEquals(entity.getStartInvoke(), entity2.getStartInvoke());
            Assert.assertNull(entity2.getEndInvoke());

            entity2.setEndInvoke(System.currentTimeMillis());

            dao.update(session, entity2);
            final RequestLog entity3 = dao.select(session, entity.getId());
            Assert.assertNotNull(entity3);
            Assert.assertEquals(entity2.getToken(), entity3.getToken());
            Assert.assertEquals(entity2.getServiceId(), entity3.getServiceId());
            Assert.assertEquals(entity2.getAction(), entity3.getAction());
            Assert.assertEquals(entity2.getStartInvoke(), entity3.getStartInvoke());
            Assert.assertEquals(entity2.getEndInvoke(), entity3.getEndInvoke());

        }
    }
}