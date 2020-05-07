package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Запись БД
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public abstract class AbstractEntity {
    public void preInsert(final SessionStorage session) {
    }

    public void preUpdate(final SessionStorage session) {
    }

    public void preDelete(final SessionStorage session) {
    }
}
