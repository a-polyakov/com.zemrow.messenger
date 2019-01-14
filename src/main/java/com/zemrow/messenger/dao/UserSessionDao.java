package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoWithoutId;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.UserSessionKey;

/**
 * DAO (data access object) для работы с сесиями пользователя
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class UserSessionDao extends AbstractDaoWithoutId<UserSessionKey, UserSession> {

    public static final String TABLE = "UserSession";

    public UserSessionDao(DataBase dataBase) {
        super(dataBase, UserSessionKey.class, UserSession.class, -1);
    }

    @Override
    public void insert(SessionStorage session, UserSession entity) {
        super.insert(session, entity);
    }

    //TODO doc
    @Override
    protected void preInsert(SessionStorage session, UserSession entity) {
        entity.setCreateTime(System.currentTimeMillis());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserSession select(UserSessionKey id) {
        return super.select(id);
    }

    /**
     * Пометить запись как удаленная
     *
     * @param session TODO
     * @param token   TODO
     */
    public void markAsDeleted(final SessionStorage session, String token) {
        logger.debug("{} markAsDeleted by token={}", cacheName, token);
        final UserSession entity = cache.get(new UserSessionKey(token));
        markAsDeleted(session, entity);
    }

    /**
     * Пометить запись как удаленная (работает медленно)
     *
     * @param session TODO
     * @param entity  TODO
     */
    public void markAsDeleted(final SessionStorage session, UserSession entity) {
        logger.debug("{} markAsDeleted {}", cacheName, entity);
        entity.setDeleteTime(System.currentTimeMillis());
        entity.setDeletedBy(session.getUserId());
        cache.put(entity.getKey(), entity);
    }

    /**
     * Получить сессию пользователя.
     *
     * @param token Идентификатор сессии.
     * @return Сессия.
     */
    public UserSession select(String token) {
        return super.select(new UserSessionKey(token));
    }
}
