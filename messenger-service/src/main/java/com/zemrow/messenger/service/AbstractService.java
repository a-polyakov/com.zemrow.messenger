package com.zemrow.messenger.service;

import com.zemrow.messenger.logic.AbstractLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public abstract class AbstractService<LOGIC extends AbstractLogic> {
    protected Logger logger = LoggerFactory.getLogger(AbstractService.class);
    /**
     * TODO
     */
    protected final LOGIC logic;

    /**
     * TODO
     */
    public AbstractService(LOGIC logic) {
        this.logic = logic;
    }

    /**
     * Начать новую транзакцию.
     *
     * @return Транзакция.
     */
    protected Transaction transaction() {
        // TODO
        return null;
    }
}
