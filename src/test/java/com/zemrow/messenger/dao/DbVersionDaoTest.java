package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для DbVersionDao
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class DbVersionDaoTest extends AbstractTest {

    private DbVersionDao dao;

    @Test
    public void test() {
        try (final DataBase dataBase = getDataBase()) {
            dao = new DbVersionDao(dataBase);

            Assert.assertEquals(0, dao.get());
            Assert.assertEquals(1, dao.incrementAndGet());
            Assert.assertEquals(1, dao.get());
        }
    }
}
