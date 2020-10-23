package com.zemrow.messenger.logic;

import com.zemrow.messenger.dao.AbstractDao;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.11.28
 */
public abstract class AbstractLogic<DAO extends AbstractDao> {
    /**
     * DAO (data access object) реализует методы работы с БД
     */
    protected final DAO dao;
    /**
     * TODO
     */
    public AbstractLogic(DAO dao) {
        this.dao = dao;
    }
}
