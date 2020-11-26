package com.zemrow.messenger.service.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.10.18
 */
public class Transaction implements AutoCloseable {
    /**
     * TODO
     */
    private final Connection connection;
    //TODO
    private final boolean oldAutoCommit;
    /**
     * TODO
     */
    private boolean rollback = true;

    /**
     * TODO
     */
    public Transaction(Connection connection) throws SQLException {
        this.connection = connection;
        oldAutoCommit=connection.getAutoCommit();
        connection.setAutoCommit(false);
        connection.setReadOnly(false);
    }

    /**
     * TODO
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * TODO
     */
    public void commit() throws SQLException {
        connection.commit();
        rollback = false;
    }

    /**
     * TODO
     */
    public void rollback() throws SQLException {
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        try {
            if (rollback) {
                connection.rollback();
            }
        } finally {
            try {
                connection.setAutoCommit(oldAutoCommit);
            } finally {
                connection.close();
            }
        }
    }
}
