package com.zemrow.messenger.server;

import com.zemrow.messenger.constants.DBConst;

/**
 * Конфигурация приложения
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class ServerConfiguration {
    /**
     * TODO
     */
    private String databaseUrl = DBConst.DEFAULT_URL;
    /**
     * TODO
     */
    private String databaseUsername = DBConst.DEFAULT_USER;
    /**
     * TODO
     */
    private String databasePassword = DBConst.DEFAULT_PASSWORD;
    /**
     * TODO
     */
    private int webServerPort = 80;

    public ServerConfiguration(String[] args) {
        //TODO применение параметров командной строки к конфигурации
    }

//================================ AUTO GENERATE ==============================

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public int getWebServerPort() {
        return webServerPort;
    }

    public void setWebServerPort(int webServerPort) {
        this.webServerPort = webServerPort;
    }
}
