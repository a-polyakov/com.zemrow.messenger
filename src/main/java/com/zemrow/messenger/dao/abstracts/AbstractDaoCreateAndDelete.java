package com.zemrow.messenger.dao.abstracts;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;

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
     * @param dataBase
     * @param entityClass Класс значения
     * @param firstId     Первый id для ключа
     * @param backups     Количество резервных копий на других узлах
     */
    protected AbstractDaoCreateAndDelete(DataBase dataBase, Class<E> entityClass, long firstId, int backups) {
        super(dataBase, entityClass, firstId, backups);
    }

    /**
     * Пометить запись как удаленная
     *
     * @param session
     * @param id
     */
    public void markAsDeleted(final SessionStorage session, long id) {
        logger.debug("{} markAsDeleted by id={}", cacheName, id);
        final E entity = cache.get(new SimpleKey(id));
        markAsDeleted(session, entity);
    }

    /**
     * Пометить запись как удаленная (работает медленно)
     *
     * @param session
     * @param entity
     */
    public void markAsDeleted(final SessionStorage session, E entity) {
        logger.debug("{} markAsDeleted {}", cacheName, entity);
        entity.setDeleteTime(System.currentTimeMillis());
        entity.setDeletedBy(session.getUserId());
        cache.put(entity.getKey(), entity);
    }

}
