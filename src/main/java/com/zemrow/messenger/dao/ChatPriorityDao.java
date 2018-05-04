package com.zemrow.messenger.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;

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
    protected final IgniteCache<Long, Long> cache;

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
        cacheCfg.setIndexedTypes(Long.class, Long.class);
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
    public Long select(final SessionStorage session, Long chatId) {
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
    public void insert(final SessionStorage session, Long chatId, Long priority) {
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
    public void update(final SessionStorage session, Long chatId, Long priority) {
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
    public void delete(final SessionStorage session, Long chatId) {
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
    public void up(final SessionStorage session, Long currentChatId, Long beforeChatId) {
        final Long currentPriority = cache.get(currentChatId);
        final Long beforePriority = cache.get(beforeChatId);
        //TODO if (currentPriority<beforePriority) {throw new IllegalArgumentException();}
        cache.query(new SqlFieldsQuery("update Long set _val=_val+1 where _val>=? and _val<?").setArgs(beforePriority, currentPriority));
//        cache.query(new SqlFieldsQuery("update Long set longValue=longValue+1 where longValue>=? and longValue<?").setArgs(beforePriority, currentPriority));
        cache.put(currentChatId, beforePriority);
    }

    /**
     * Изменить приоритет чата
     *
     * @param session
     * @param currentChatId идентификатор чата который передвигаем
     * @param afterChatId   идентификатор чаты после которого нужно расположить
     */
    public void down(final SessionStorage session, Long currentChatId, Long afterChatId) {
        final Long currentPriority = cache.get(currentChatId);
        final Long afterPriority = cache.get(afterChatId);
        //TODO if (currentPriority>beforePriority) {throw new IllegalArgumentException();}
        cache.query(new SqlFieldsQuery("update Long set _val=_val-1 where _val>? and _val<=?").setArgs(currentPriority, afterPriority));
        cache.put(currentChatId, afterPriority);
    }
}
