package com.zemrow.messenger.dao.abstracts;

import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicSequence;
import org.apache.ignite.configuration.AtomicConfiguration;

/**
 * Универсальное DAO (data access object) реализующее базовые методы работы с хранилищем
 * - Получить entity по id
 * - Добавление записи
 * - Обновление записи
 * - Удаление записи
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public abstract class AbstractDaoCreateOnly<E extends AbstractEntityCreateOnly> extends AbstractDaoWithoutId<Long, E> {

    /**
     * Счётчик
     */
    protected final IgniteAtomicSequence sequence;

    /**
     * @param ignite
     * @param entityClass Класс значения
     * @param firstId Первый id для ключа
     * @param backups Количество резервных копий на других узлах
     */
    protected AbstractDaoCreateOnly(Ignite ignite, Class<E> entityClass, long firstId, int backups) {
        super(ignite, Long.class, entityClass, backups);
        final AtomicConfiguration cfg = new AtomicConfiguration();
        cfg.setAtomicSequenceReserveSize(1_000_000);
        sequence = ignite.atomicSequence(cacheName + "Sequence", cfg, firstId, true);
    }

    /**
     * Добавление записи
     *
     * @param session - SessionStorage
     * @param entity
     */
    public void insert(final SessionStorage session, E entity) {
        if (entity.getId() == null) {
            entity.setId(sequence.addAndGet(IdConstant.DELTA_ID));
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
