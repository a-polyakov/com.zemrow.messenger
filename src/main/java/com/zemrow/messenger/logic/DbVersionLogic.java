package com.zemrow.messenger.logic;

import com.zemrow.messenger.dao.DbVersionDao;
import com.zemrow.messenger.logic.abstracts.AbstractLogic;

/**
 * Работы с версией схемы БД.
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class DbVersionLogic extends AbstractLogic {

    private final DbVersionDao dbVersionDao;

    public DbVersionLogic(DbVersionDao dbVersionDao) {
        this.dbVersionDao = dbVersionDao;
    }

    public long get() {
        return dbVersionDao.get();
    }

    public long incrementAndGet() {
        return dbVersionDao.incrementAndGet();
    }
}
