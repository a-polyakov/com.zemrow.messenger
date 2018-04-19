package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;
import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteUuid;

/**
 * Универсальное DAO (data access object) реализующее базовые методы работы с хранилищем
 * - Получить entity по id
 * - Добавление записи
 * - Обновление записи
 * - Удаление записи
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public abstract class AbstractDaoCreateOnly<E extends AbstractEntityCreateOnly> extends AbstractDaoWithoutId<IgniteUuid, E> {

    /**
     * @param ignite
     * @param backups Количество резервных копий на других узлах
     */
    protected AbstractDaoCreateOnly(Ignite ignite, Class<E> entityClass, int backups) {
        super(ignite, IgniteUuid.class, entityClass, backups);
    }

    /**
     * Добавление записи
     *
     * @param session
     * @param entity
     */
    public void insert(final SessionStorage session, E entity) {
        if (entity.getId() == null) {
            entity.setId(IgniteUuid.randomUuid());
        }
        insert(session, entity.getId(), entity);
    }

    @Override
    protected void preInsert(SessionStorage session, E entity) {
        entity.setCreateTime(System.currentTimeMillis());
        entity.setCreatedBy(session.getUserId());
    }

    /**
     * Обновление записи по id
     *
     * @param session
     * @param entity
     */
    public void update(final SessionStorage session, E entity) {
        update(session, entity.getId(), entity);
    }
}
