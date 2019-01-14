package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.helper.DaoHelper;
import org.apache.ignite.IgniteAtomicLong;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO (data access object) для работы с приоритетом чата
 * <p>
 * TODO проверить как выполнить выборку чатов отсортированых по приоритету
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatPriorityDao {

    protected Logger logger = LoggerFactory.getLogger(ChatPriorityDao.class);

    /**
     * Наименование кеша
     */
    private static final String cacheName = "ChatPriorityCache";

    private final IgniteAtomicLong sequence;
    /**
     * Кеш
     */
    protected final IgniteCache<Long, Long> cache;

    /**
     * @param dataBase
     */
    public ChatPriorityDao(DataBase dataBase) {
        this.sequence = dataBase.getIgnite().atomicLong(cacheName + "Sequence", 0, true);
        this.cache = DaoHelper.createCache(dataBase, cacheName, Long.class, Long.class, 2);
    }

    /**
     * Получить приоритет по идентификатору чата.
     *
     * @param chatId Идентификатор чата.
     * @return Приоритет.
     */
    public Long select(Long chatId) {
        logger.debug("{} select by chatId={}", cacheName, chatId);
        final Long result = cache.get(chatId);
        return result;
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param chatId  Идентификатор чата
     */
    public long insert(final SessionStorage session, Long chatId) {
        logger.debug("{} insert chatId {}", cacheName, chatId);
        final long priority = sequence.incrementAndGet();
        cache.put(chatId, priority);
        return priority;
    }


    /**
     * Обновление записи по id
     *
     * @param session
     * @param chatId   Идентификатор чата
     * @param priority Приоритет
     */
    @Deprecated
    void update(final SessionStorage session, Long chatId, Long priority) {
        logger.debug("{} update chatId={} priority={}", cacheName, chatId, priority);
        cache.put(chatId, priority);
    }


    /**
     * Удаление записи
     *
     * @param session
     * @param chatId  Идентификатор чата
     */
    @Deprecated
    void delete(final SessionStorage session, Long chatId) {
        logger.debug("{} delete by chatId={}", cacheName, chatId);
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
        logger.debug("{} up currentChatId={} beforeChatId={}", cacheName, currentChatId, beforeChatId);
        final Long currentPriority = cache.get(currentChatId);
        final Long beforePriority = cache.get(beforeChatId);
        //TODO if (currentPriority<beforePriority) {throw new IllegalArgumentException();}
        cache.query(new SqlFieldsQuery("update Long set _val=_val+1 where _val>=? and _val<?").setArgs(beforePriority, currentPriority));
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
        logger.debug("{} down currentChatId={} afterChatId={}", cacheName, currentChatId, afterChatId);
        final Long currentPriority = cache.get(currentChatId);
        final Long afterPriority = cache.get(afterChatId);
        //TODO if (currentPriority>beforePriority) {throw new IllegalArgumentException();}
        cache.query(new SqlFieldsQuery("update Long set _val=_val-1 where _val>? and _val<=?").setArgs(currentPriority, afterPriority));
        cache.put(currentChatId, afterPriority);
    }
}
