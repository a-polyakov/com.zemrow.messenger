package com.zemrow.messenger.dao.abstracts;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.helper.DaoHelper;
import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;
import com.zemrow.messenger.entity.abstracts.AbstractKey;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Универсальное DAO (data access object) реализующее базовые методы работы с хранилищем
 * над обектами у которых отсутствует поле id (первичный ключь состовной)
 * <ul>
 * <li>Получить entity по ключу</li>
 * <li>Добавление записи по ключу</li>
 * <li>Обновление записи по ключу</li>
 * <li>Удаление записи</li>
 * </ul>
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public abstract class AbstractDaoWithoutId<K extends AbstractKey, E extends AbstractEntityWithoutId<K>> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

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
     * @param dataBase TODO
     * @param keyClass    Класс ключа
     * @param entityClass Класс значения
     * @param backups     Количество резервных копий на других узлах
     */
    protected AbstractDaoWithoutId(DataBase dataBase, Class<K> keyClass, Class<E> entityClass, int backups) {
        this.entityClass = entityClass;
        cacheName = entityClass.getSimpleName();
        cache = DaoHelper.createCache(dataBase, cacheName, keyClass, entityClass, backups);
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
     * Проверка наличия записи по ключу.
     *
     * @param id Первичный ключ.
     * @return Признак наличия записи.
     */
    protected boolean containsById(K id) {
        return cache.containsKey(id);
    }

    /**
     * Получить entity по id.
     *
     * @param id Первичный ключ.
     * @return Entity.
     */
    protected E select(final K id) {
        logger.debug("{} select by id={}", cacheName, id);
        final E result = cache.get(id);
        return result;
    }

    /**
     * Добавление записи
     *
     * @param session TODO
     * @param entity  TODO
     */
    protected void insert(final SessionStorage session, E entity) {
        logger.debug("{} insert {}", cacheName, entity);
        preInsert(session, entity);
        cache.put(entity.getKey(), entity);
    }

    /**
     * Обработка перед записью нового значения
     *
     * @param session TODO
     * @param entity  TODO
     */
    protected void preInsert(SessionStorage session, E entity) {
    }

    /**
     * Обновление записи по id
     *
     * @param session TODO
     * @param entity  TODO
     */
    protected void update(final SessionStorage session, E entity) {
        logger.debug("{} update {}", cacheName, entity);
        preUpdate(session, entity);
        cache.put(entity.getKey(), entity);
    }

    /**
     * Обработка перед обновлением
     *
     * @param session TODO
     * @param entity  TODO
     */
    protected void preUpdate(SessionStorage session, E entity) {
    }

    /**
     * Удаление записи
     *
     * @param session TODO
     * @param id      первичный ключ
     */
    protected void delete(final SessionStorage session, K id) {
        logger.debug("{} delete by id={}", cacheName, id);
        preDelete(session, id);
        cache.remove(id);
    }

    /**
     * Обработка перед удалением
     *
     * @param session
     * @param id      первичный ключ
     */
    protected void preDelete(SessionStorage session, K id) {
    }

    /**
     * Выполнить запрос, результат которого должен быть один элемент
     *
     * @param query Запрос.
     * @param args  SQL arguments.
     * @param <T>
     * @return
     */
    protected <T> T query(String query, Object... args) {
        T result = null;
        try (final FieldsQueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery(query).setArgs(args))) {
            final List<List<?>> all = cursor.getAll();
            if (all.size() == 1) {
                final List<?> row = all.get(0);
                if (row.size() == 1) {
                    result = (T) (row.get(0));
                }
            }
        }
        return result;
    }
}
