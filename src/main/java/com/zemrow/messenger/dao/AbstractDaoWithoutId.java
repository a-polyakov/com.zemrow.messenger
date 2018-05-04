package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.PartitionLossPolicy;
import org.apache.ignite.configuration.CacheConfiguration;

/**
 * Универсальное DAO (data access object) реализующее базовые методы работы с хранилищем
 * - Получить entity по id
 * - Добавление записи по id
 * - Обновление записи по id
 * - Удаление записи
 * над обектами у которых отсутствует поле id (первичный ключь состовной)
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public abstract class AbstractDaoWithoutId<K, E extends AbstractEntityWithoutId> {

    protected Logger logger = Logger.getLogger(AbstractDaoWithoutId.class.getSimpleName());

    /**
     * Наименование кеша
     */
    protected final String cacheName;
    protected final Class<E> entityClass;

    /**
     * Кеш
     */
    protected final IgniteCache<K, E> cache;

    /**
     * @param ignite
     * @param keyClass Класс ключа
     * @param entityClass Класс значения
     * @param backups Количество резервных копий на других узлах
     */
    protected AbstractDaoWithoutId(Ignite ignite, Class<K> keyClass, Class<E> entityClass, int backups) {
        this.entityClass = entityClass;
        cacheName = entityClass.getSimpleName();
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
        cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        this.cache = ignite.getOrCreateCache(cacheCfg);
    }

    /**
     * @return Класс entity c которым работает DAO
     */
    public final Class<E> getEntityClass() {
        return entityClass;
    }

    /**
     * @return Наименование кеша
     */
    public final String getCacheName() {
        return cacheName;
    }

    /**
     * Получить entity по id
     *
     * @param session
     * @param id
     * @return
     */
    public E select(final SessionStorage session, K id) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " select by id=" + id);
        }
        final E result = cache.get(id);
        return result;
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param id
     * @param entity
     */
    protected void insert(final SessionStorage session, K id, E entity) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " insert " + entity);
        }
        preInsert(session, entity);
        cache.put(id, entity);
    }

    /**
     * Обработка перед записью нового значения
     *
     * @param session
     * @param entity
     */
    protected void preInsert(SessionStorage session, E entity) {
    }

    /**
     * Обновление записи по id
     *
     * @param session
     * @param id
     * @param entity
     */
    protected void update(final SessionStorage session, K id, E entity) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " update " + entity);
        }
        preUpdate(session, entity);
        cache.put(id, entity);
    }

    /**
     * Обработка перед обновлением
     *
     * @param session
     * @param entity
     */
    protected void preUpdate(SessionStorage session, E entity) {
    }

    /**
     * Удаление записи
     *
     * @param session
     * @param id
     */
    public void delete(final SessionStorage session, K id) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " delete by id=" + id);
        }
        preDelete(session, id);
        cache.remove(id);
    }

    /**
     * Обработка перед удалением
     *
     * @param session
     * @param id
     */
    protected void preDelete(SessionStorage session, K id) {
    }
}
