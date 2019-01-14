package com.zemrow.messenger.dao.abstracts;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.abstracts.AbstractEntityWithId;
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
public abstract class AbstractDaoCreateOnly<E extends AbstractEntityWithId> extends AbstractDaoWithoutId<SimpleKey, E> {

    /**
     * Счётчик
     */
    protected final IgniteAtomicSequence sequence;

    /**
     * @param dataBase
     * @param entityClass Класс значения
     * @param firstId     Первый id для ключа
     * @param backups     Количество резервных копий на других узлах
     */
    protected AbstractDaoCreateOnly(DataBase dataBase, Class<E> entityClass, long firstId, int backups) {
        super(dataBase, SimpleKey.class, entityClass, backups);
        final AtomicConfiguration cfg = new AtomicConfiguration();
        cfg.setAtomicSequenceReserveSize(1_000);
        sequence = dataBase.getIgnite().atomicSequence(cacheName + "Sequence", cfg, firstId, true);
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
        super.insert(session, entity);
    }

    @Override
    protected void preInsert(SessionStorage session, E entity) {
        entity.setCreateTime(System.currentTimeMillis());
        entity.setCreatedBy(session.getUserId());
    }
}
