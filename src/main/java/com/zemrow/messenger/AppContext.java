package com.zemrow.messenger;

import com.zemrow.messenger.controller.UserController;
import com.zemrow.messenger.dao.ChatDao;
import com.zemrow.messenger.dao.ChatPriorityDao;
import com.zemrow.messenger.dao.ChatRemindersDao;
import com.zemrow.messenger.dao.ChatTagGroupDao;
import com.zemrow.messenger.dao.ChatToUserDao;
import com.zemrow.messenger.dao.ChatTreeDao;
import com.zemrow.messenger.dao.ChatWorkDao;
import com.zemrow.messenger.dao.FileDao;
import com.zemrow.messenger.dao.MessageDao;
import com.zemrow.messenger.dao.MessageLogDao;
import com.zemrow.messenger.dao.MessageTagDao;
import com.zemrow.messenger.dao.MessageToUserDao;
import com.zemrow.messenger.dao.NumberingDao;
import com.zemrow.messenger.dao.RequestLogDao;
import com.zemrow.messenger.dao.TagDao;
import com.zemrow.messenger.dao.UserContactDao;
import com.zemrow.messenger.dao.UserDao;
import com.zemrow.messenger.dao.UserEntryPointDao;
import com.zemrow.messenger.dao.UserFilterDao;
import com.zemrow.messenger.dao.UserLinkDao;
import com.zemrow.messenger.dao.UserLogDao;
import com.zemrow.messenger.dao.UserSessionDao;
import com.zemrow.messenger.dao.UserSessionFailDao;
import com.zemrow.messenger.dao.UserStatusDao;
import com.zemrow.messenger.dao.UserTreeDao;
import com.zemrow.messenger.logic.UserLogic;
import com.zemrow.messenger.logic.UserSessionLogic;
import com.zemrow.messenger.service.UserService;
import java.util.Arrays;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.DeploymentMode;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.configuration.TransactionConfiguration;
import org.apache.ignite.configuration.WALMode;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class AppContext {

    private final Ignite ignite;

    private final RequestLogDao requestLogDao;
    private final UserLogDao userLogDao;
    private final TagDao tagDao;
    private final UserSessionDao userSessionDao;
    private final UserLinkDao userLinkDao;
    private final ChatRemindersDao chatRemindersDao;
    private final MessageTagDao messageTagDao;
    private final UserFilterDao userFilterDao;
    private final ChatTagGroupDao chatTagGroupDao;
    private final UserStatusDao userStatusDao;
    private final ChatTreeDao chatTreeDao;
    private final NumberingDao numberingDao;
    private final ChatWorkDao chatWorkDao;
    private final UserTreeDao userTreeDao;
    private final UserContactDao userContactDao;
    private final MessageToUserDao messageToUserDao;
    private final MessageDao messageDao;
    private final UserDao userDao;
    private final ChatPriorityDao chatPriorityDao;
    private final ChatToUserDao chatToUserDao;
    private final UserSessionFailDao userSessionFailDao;
    private final UserEntryPointDao userEntryPointDao;
    private final MessageLogDao messageLogDao;
    private final ChatDao chatDao;
    private final FileDao fileDao;

    private final UserLogic userLogic;
    private final UserSessionLogic userSessionLogic;

    private final UserService userService;

    private final UserController userController;

    public AppContext() {
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
        tcpDiscoveryVmIpFinder.setAddresses(Arrays.asList(new String[] {"127.0.0.1:47700..47701"}));
        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
        tcpDiscoverySpi.setLocalPort(47700);
        tcpDiscoverySpi.setLocalPortRange(1);
        cfg.setDiscoverySpi(tcpDiscoverySpi);
        // настройка хранения на диске
        final DataStorageConfiguration storageCfg = new DataStorageConfiguration();
        storageCfg.setStoragePath("C:\\temp\\ignite\\data");
        storageCfg.setWalPath("C:\\temp\\ignite\\wal");
        storageCfg.setWalArchivePath("C:\\temp\\ignite\\walArchive");
        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
        // данные не потеряются, но требует записи лога на диск
        storageCfg.setWalMode(WALMode.BACKGROUND); // https://apacheignite.readme.io/docs/write-ahead-log
        cfg.setDataStorageConfiguration(storageCfg);

        cfg.setTransactionConfiguration(new TransactionConfiguration());

        ignite = Ignition.start(cfg);

        requestLogDao = new RequestLogDao(ignite);
        userLogDao = new UserLogDao(ignite);
        tagDao = new TagDao(ignite);
        userSessionDao = new UserSessionDao(ignite);
        userLinkDao = new UserLinkDao(ignite);
        chatRemindersDao = new ChatRemindersDao(ignite);
        messageTagDao = new MessageTagDao(ignite);
        userFilterDao = new UserFilterDao(ignite);
        chatTagGroupDao = new ChatTagGroupDao(ignite);
        userStatusDao = new UserStatusDao(ignite);
        chatTreeDao = new ChatTreeDao(ignite);
        numberingDao = new NumberingDao(ignite);
        chatWorkDao = new ChatWorkDao(ignite);
        userTreeDao = new UserTreeDao(ignite);
        userContactDao = new UserContactDao(ignite);
        messageToUserDao = new MessageToUserDao(ignite);
        messageDao = new MessageDao(ignite);
        userDao = new UserDao(ignite);
        chatPriorityDao = new ChatPriorityDao(ignite);
        chatToUserDao = new ChatToUserDao(ignite);
        userSessionFailDao = new UserSessionFailDao(ignite);
        userEntryPointDao = new UserEntryPointDao(ignite);
        messageLogDao = new MessageLogDao(ignite);
        chatDao = new ChatDao(ignite);
        fileDao = new FileDao(ignite);

        userLogic=new UserLogic(userDao, userTreeDao, userStatusDao);
        userSessionLogic=new UserSessionLogic();

        userService=new UserService(userLogic, userSessionLogic);

        userController=new UserController();
    }

//================================ AUTO GENERATE ==============================

}
