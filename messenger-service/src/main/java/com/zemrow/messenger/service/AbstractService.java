package com.zemrow.messenger.service;

import com.zemrow.messenger.logic.AbstractLogic;
import com.zemrow.messenger.service.transaction.DataBase;
import com.zemrow.messenger.service.transaction.ReadOnly;
import com.zemrow.messenger.service.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

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
    private final DataBase dataBase;
    /**
     * TODO
     */
    protected final LOGIC logic;

    /**
     * TODO
     */
    public AbstractService(DataBase dataBase, LOGIC logic) {
        this.dataBase = dataBase;
        this.logic = logic;
    }

    /**
     * Начать новую транзакцию.
     *
     * @return Транзакция.
     */
    protected Transaction transaction() throws SQLException {
        return dataBase.transaction();
    }

    //TODO
    public ReadOnly readOnly() throws SQLException {
        return dataBase.readOnly();
    }
}
