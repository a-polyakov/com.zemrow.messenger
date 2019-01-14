package com.zemrow.messenger.service.abstracts;

import org.apache.ignite.Ignition;
import org.apache.ignite.transactions.Transaction;
import org.apache.ignite.transactions.TransactionConcurrency;
import org.apache.ignite.transactions.TransactionIsolation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public abstract class AbstractService {
    protected Logger logger = LoggerFactory.getLogger(AbstractService.class);

    /**
     * Начать новую транзакцию.
     *
     * @return Транзакция.
     */
    protected Transaction transaction() {
        return Ignition.ignite().transactions().txStart(TransactionConcurrency.PESSIMISTIC, TransactionIsolation.REPEATABLE_READ);
    }
}
