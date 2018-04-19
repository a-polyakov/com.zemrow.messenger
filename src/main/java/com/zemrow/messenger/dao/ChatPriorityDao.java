package com.zemrow.messenger.dao;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.lang.IgniteUuid;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO (data access object) для работы с приоритетом чата
 * <p>
 * TODO проверить как выполнить выборку чатов итсортированых по приоритету
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatPriorityDao {

    protected Logger logger = Logger.getLogger(ChatPriorityDao.class.getSimpleName());

    /**
     * Наименование кеша
     */
    protected static final String cacheName = "ChatPriorityCache";
    /**
     * Кеш
     */
    protected final IgniteCache<IgniteUuid, Long> cache;

    /**
     * @param ignite
     */
    public ChatPriorityDao(Ignite ignite) {
        final CacheConfiguration cacheCfg = new CacheConfiguration(cacheName);
        cacheCfg.setSqlSchema("messenger");
        // Способ распределения данных по кластеру
        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
        // Количество резервных копий на других узлах
        cacheCfg.setBackups(2);
        cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        this.cache = ignite.getOrCreateCache(cacheCfg);
    }

    /**
     * @return Наименование кеша
     */
    public final String getCacheName() {
        return cacheName;
    }

    /**
     * Получить приоритет по идентификатору чата
     *
     * @param session
     * @param chatId
     * @return
     */
    public Long select(final SessionStorage session, IgniteUuid chatId) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " select by chatId=" + chatId);
        }
        final Long result = cache.get(chatId);
        return result;
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param chatId   Идентификатор чата
     * @param priority Приоритет
     */
    public void insert(final SessionStorage session, IgniteUuid chatId, Long priority) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " insert chatId " + chatId + " priority " + priority);
        }
        cache.put(chatId, priority);
    }


    /**
     * Обновление записи по id
     *
     * @param session
     * @param chatId   Идентификатор чата
     * @param priority Приоритет
     */
    public void update(final SessionStorage session, IgniteUuid chatId, Long priority) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " update chatId " + chatId + " priority " + priority);
        }
        cache.put(chatId, priority);
    }


    /**
     * Удаление записи
     *
     * @param session
     * @param chatId  Идентификатор чата
     */
    public void delete(final SessionStorage session, IgniteUuid chatId) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " delete by chatId=" + chatId);
        }
        cache.remove(chatId);
    }

    /**
     * Изменить приоритет чата
     *
     * @param session
     * @param currentChatId идентификатор чата который передвигаем
     * @param beforeChatId  идентификатор чаты перед которым нужно расположить
     */
    public void up(final SessionStorage session, IgniteUuid currentChatId, IgniteUuid beforeChatId) {
        final Long currentPriority = cache.get(currentChatId);
        final Long beforePriority = cache.get(beforeChatId);
        //TODO if (currentPriority<beforePriority) {throw new IllegalArgumentException();}
        cache.query(new SqlFieldsQuery("update ChatPriority set priority=priority+1 where priority>=? and priority<?").setArgs(beforePriority, currentPriority));
        cache.put(currentChatId, beforePriority);
    }

    /**
     * Изменить приоритет чата
     *
     * @param session
     * @param currentChatId идентификатор чата который передвигаем
     * @param afterChatId   идентификатор чаты после которого нужно расположить
     */
    public void down(final SessionStorage session, IgniteUuid currentChatId, IgniteUuid afterChatId) {
        final Long currentPriority = cache.get(currentChatId);
        final Long afterPriority = cache.get(currentChatId);
        //TODO if (currentPriority>beforePriority) {throw new IllegalArgumentException();}
        cache.query(new SqlFieldsQuery("update ChatPriority set priority=priority-1 where priority>? and priority<=?").setArgs(currentPriority, afterPriority));
        cache.put(currentChatId, afterPriority);
    }
}
