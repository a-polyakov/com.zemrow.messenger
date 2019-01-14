package com.zemrow.messenger;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.*;
import org.apache.ignite.logger.slf4j.Slf4jLogger;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

/**
 * Конфигурация приложения
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class DataBase implements Closeable {

    protected Logger logger = LoggerFactory.getLogger(DataBase.class);

    private final Ignite ignite;

    public DataBase(Ignite ignite) {
        this.ignite = ignite;
    }

    public DataBase(AppConfiguration appConfiguration) {
        final IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setClientMode(false);
        // подгрузка классав (в теории одна новая нода должна обновить все остальные)
        cfg.setPeerClassLoadingEnabled(true);
        // метод распространения новой версии класса
        cfg.setDeploymentMode(DeploymentMode.ISOLATED); // https://apacheignite.readme.io/docs/deployment-modes

//        cfg.setIncludeEventTypes(EventType.EVTS_TASK_EXECUTION);
//        cfg.setIncludeEventTypes(EventType.EVTS_CACHE);

        // настройка критериев поиска узлов в кластере
        final TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
        final TcpDiscoveryVmIpFinder tcpDiscoveryVmIpFinder = new TcpDiscoveryVmIpFinder(true);
        tcpDiscoveryVmIpFinder.setAddresses(appConfiguration.getIgniteAddresses());
        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
        tcpDiscoverySpi.setLocalPort(appConfiguration.getIgniteLocalPort());
        tcpDiscoverySpi.setLocalPortRange(appConfiguration.getIgniteLocalPortRange());
        cfg.setDiscoverySpi(tcpDiscoverySpi);
        // настройка хранения на диске
        final DataStorageConfiguration storageCfg = new DataStorageConfiguration();
        storageCfg.setStoragePath(appConfiguration.getIgniteStoragePath());
        storageCfg.setWalPath(appConfiguration.getIgniteWalPath());
        storageCfg.setWalArchivePath(appConfiguration.getIgniteWalArchivePath());
        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
        // данные не потеряются, но требует записи лога на диск
        storageCfg.setWalMode(WALMode.BACKGROUND); // https://apacheignite.readme.io/docs/write-ahead-log
        cfg.setDataStorageConfiguration(storageCfg);

        cfg.setTransactionConfiguration(new TransactionConfiguration());

        final Slf4jLogger gridLogger = new Slf4jLogger();
        cfg.setGridLogger(gridLogger);

        final AtomicConfiguration atomicCfg = new AtomicConfiguration();
        atomicCfg.setCacheMode(CacheMode.REPLICATED);
        cfg.setAtomicConfiguration(atomicCfg);

        ignite = Ignition.start(cfg);
        if (!ignite.cluster().active()) {
            ignite.cluster().active(true);
        } else {
            // TODO проверить добавление узла в топологю
        }
    }

    @Override
    public void close() {
        if (ignite != null) {
            try {
                ignite.close();
            } catch (Throwable e) {
                logger.error("Error ignite close", e);
            }
        }
    }

//================================ AUTO GENERATE ==============================

    public Ignite getIgnite() {
        return ignite;
    }
}
