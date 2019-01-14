package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import org.apache.ignite.IgniteAtomicLong;

/**
 * DAO (data access object) для работы с версией схемы БД
 *
 * @author Alexandr Polyakov on 2018.08.07
 */
public class DbVersionDao {
    public static final String TABLE = "DB_VERSION";

    private final IgniteAtomicLong dbVersion;

    public DbVersionDao(DataBase dataBase) {
        dbVersion = dataBase.getIgnite().atomicLong(TABLE, 0, true);
    }

    public long get() {
        return dbVersion.get();
    }

    public long incrementAndGet() {
        return dbVersion.incrementAndGet();
    }
}
