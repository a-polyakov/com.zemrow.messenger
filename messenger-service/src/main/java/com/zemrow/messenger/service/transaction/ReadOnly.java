package com.zemrow.messenger.service.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.10.18
 */
public class ReadOnly implements AutoCloseable {
    /**
     * TODO
     */
    private final Connection connection;

    /**
     * TODO
     */
    public ReadOnly(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setReadOnly(true);
    }

    /**
     * TODO
     */
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
