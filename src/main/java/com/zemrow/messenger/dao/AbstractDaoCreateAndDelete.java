package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;

import java.util.logging.Level;

/**
 * Универсальное DAO (data access object) реализующее базовые методы работы с хранилищем
 * - Получить entity по id
 * - Добавление записи
 * - Обновление записи
 * - Удаление записи
 * - Пометить запись как удаленная
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public abstract class AbstractDaoCreateAndDelete<E extends AbstractEntityCreateAndDelete> extends AbstractDaoCreateOnly<E> {

    /**
     * @param ignite
     * @param backups Количество резервных копий на других узлах
     */
    protected AbstractDaoCreateAndDelete(Ignite ignite, Class<E> entityClass, int backups) {
        super(ignite, entityClass, backups);
    }

    /**
     * Пометить запись как удаленная
     *
     * @param session
     * @param id
     */
    public void markAsDeleted(final SessionStorage session, IgniteUuid id) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " markAsDeleted by id=" + id);
        }
        final E entity = cache.get(id);
        markAsDeleted(session, entity);
    }

    /**
     * Пометить запись как удаленная (работает медленно)
     *
     * @param session
     * @param entity
     */
    public void markAsDeleted(final SessionStorage session, E entity) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(cacheName + " markAsDeleted " + entity);
        }
        entity.setDeleteTime(System.currentTimeMillis());
        entity.setDeletedBy(session.getUserId());
        cache.put(entity.getId(), entity);
    }

}
