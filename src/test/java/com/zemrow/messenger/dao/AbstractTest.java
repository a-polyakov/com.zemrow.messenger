package com.zemrow.messenger.dao;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.DeploymentMode;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.configuration.TransactionConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

import java.util.Arrays;

/**
 * Общая часть тестов
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public abstract class AbstractTest {

    protected Ignite getIgnite() {
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
        tcpDiscoveryVmIpFinder.setAddresses(Arrays.asList(new String[]{"127.0.0.1:47700..47710"}));
        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
        tcpDiscoverySpi.setLocalPort(47700);
        tcpDiscoverySpi.setLocalPortRange(10);
        cfg.setDiscoverySpi(tcpDiscoverySpi);
        // настройка хранения на диске
//        final DataStorageConfiguration storageCfg = new DataStorageConfiguration();
//        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
        // данные не потеряются, но требует записи лога на диск
//        storageCfg.setWalMode(WALMode.FSYNC); // https://apacheignite.readme.io/docs/write-ahead-log
//        cfg.setDataStorageConfiguration(storageCfg);

        cfg.setTransactionConfiguration(new TransactionConfiguration());
        final Ignite ignite = Ignition.start(cfg);
        ignite.cluster().active(true);
        return ignite;
    }
}
