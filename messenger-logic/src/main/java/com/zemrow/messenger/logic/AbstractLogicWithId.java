package com.zemrow.messenger.logic;

import com.zemrow.messenger.dao.AbstractDaoWithId;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.12.06
 */
public abstract class AbstractLogicWithId<DAO extends AbstractDaoWithId> extends AbstractLogic<DAO> {
    /**
     * TODO
     */
    public AbstractLogicWithId(DAO dao) {
        super(dao);
    }

    /**
     * Получить следующий идентификатор
     */
    public long nextId() {
        return dao.nextId();
    }
}
