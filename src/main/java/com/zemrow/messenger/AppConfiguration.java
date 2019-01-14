package com.zemrow.messenger;

import java.util.Arrays;
import java.util.List;

/**
 * Конфигурация приложения
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class AppConfiguration {
    /**
     * TODO
     */
    private List<String> igniteAddresses = Arrays.asList(new String[]{"127.0.0.1:47700..47701"});
    /**
     * TODO
     */
    private int igniteLocalPort = 47700;
    /**
     * TODO
     */
    private int igniteLocalPortRange = 1;
    /**
     * TODO
     */
    private String igniteStoragePath = "C:\\temp\\ignite\\data";
    /**
     * TODO
     */
    private String igniteWalPath = "C:\\temp\\ignite\\wal";
    /**
     * TODO
     */
    private String igniteWalArchivePath = "C:\\temp\\ignite\\walArchive";
    /**
     * TODO
     */
    private int webServerPort = 80;

    public AppConfiguration(String[] args) {
        //TODO применение параметров командной строки к конфигурации
    }

    //================================ AUTO GENERATE ==============================

    public List<String> getIgniteAddresses() {
        return igniteAddresses;
    }

    public void setIgniteAddresses(List<String> igniteAddresses) {
        this.igniteAddresses = igniteAddresses;
    }

    public int getIgniteLocalPort() {
        return igniteLocalPort;
    }

    public void setIgniteLocalPort(int igniteLocalPort) {
        this.igniteLocalPort = igniteLocalPort;
    }

    public int getIgniteLocalPortRange() {
        return igniteLocalPortRange;
    }

    public void setIgniteLocalPortRange(int igniteLocalPortRange) {
        this.igniteLocalPortRange = igniteLocalPortRange;
    }

    public String getIgniteStoragePath() {
        return igniteStoragePath;
    }

    public void setIgniteStoragePath(String igniteStoragePath) {
        this.igniteStoragePath = igniteStoragePath;
    }

    public String getIgniteWalPath() {
        return igniteWalPath;
    }

    public void setIgniteWalPath(String igniteWalPath) {
        this.igniteWalPath = igniteWalPath;
    }

    public String getIgniteWalArchivePath() {
        return igniteWalArchivePath;
    }

    public void setIgniteWalArchivePath(String igniteWalArchivePath) {
        this.igniteWalArchivePath = igniteWalArchivePath;
    }

    public int getWebServerPort() {
        return webServerPort;
    }

    public void setWebServerPort(int webServerPort) {
        this.webServerPort = webServerPort;
    }
}
