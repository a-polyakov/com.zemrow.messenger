package com.zemrow.messenger.dao.helper;

import com.zemrow.messenger.DataBase;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.PartitionLossPolicy;
import org.apache.ignite.configuration.CacheConfiguration;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2019.01.09
 */
public class DaoHelper {
    /**
     * Создать кеш
     *
     * @param dataBase    TODO
     * @param cacheName   Наименование кеша
     * @param keyClass    Класс ключа
     * @param entityClass Класс значения
     * @param backups     Количество резервных копий на других узлах
     */
    public static <KEY, VALUE> IgniteCache<KEY, VALUE> createCache(DataBase dataBase, String cacheName, Class<KEY> keyClass, Class<VALUE> entityClass, int backups) {
        final CacheConfiguration cacheCfg = new CacheConfiguration(cacheName + "Cache");
        cacheCfg.setSqlSchema("messenger");
        if (backups >= 0) {
            // Способ распределения данных по кластеру
            cacheCfg.setCacheMode(CacheMode.PARTITIONED);
            // Количество резервных копий на других узлах
            cacheCfg.setBackups(backups);
        } else {
            // Все узлы должны содержать полный набор записей
            cacheCfg.setCacheMode(CacheMode.REPLICATED);
        }
        // остановить запись если из кластера порерялись данные (умерли основные ноды и ноды с копиями)
        cacheCfg.setPartitionLossPolicy(PartitionLossPolicy.READ_ONLY_SAFE);
        // TODO можно попробывать обработать эту ситуацию
        // ignite.events().localListen( , EventType.EVT_CACHE_REBALANCE_PART_DATA_LOST);
        cacheCfg.setIndexedTypes(keyClass, entityClass);
        cacheCfg.setTypes(keyClass, entityClass);
        cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL_SNAPSHOT);
        cacheCfg.setStoreKeepBinary(true);
        return dataBase.getIgnite().getOrCreateCache(cacheCfg);
    }
}
