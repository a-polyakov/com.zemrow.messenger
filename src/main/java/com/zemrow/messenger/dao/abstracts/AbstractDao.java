package com.zemrow.messenger.dao.abstracts;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.abstracts.AbstractEntity;

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
public abstract class AbstractDao<E extends AbstractEntity> extends AbstractDaoCreateAndDelete<E> {

    /**
     * @param dataBase
     * @param entityClass Класс значения
     * @param firstId Первый id для ключа
     * @param backups Количество резервных копий на других узлах
     */
    protected AbstractDao(DataBase dataBase, Class<E> entityClass, long firstId, int backups) {
        super(dataBase, entityClass, firstId, backups);
    }

    @Override
    protected void preInsert(SessionStorage session, E entity) {
        super.preInsert(session, entity);
        entity.setUpdateTime(entity.getCreateTime());
        entity.setUpdatedBy(entity.getCreatedBy());
    }

    @Override
    protected void preUpdate(SessionStorage session, E entity) {
        super.preUpdate(session, entity);
        entity.setUpdateTime(System.currentTimeMillis());
        entity.setUpdatedBy(session.getUserId());
    }
}
