package com.zemrow.messenger;

import com.zemrow.messenger.dao.ChatDao;
import com.zemrow.messenger.dao.ChatPriorityDao;
import com.zemrow.messenger.dao.ChatRemindersDao;
import com.zemrow.messenger.dao.ChatTagGroupDao;
import com.zemrow.messenger.dao.ChatToUserDao;
import com.zemrow.messenger.dao.ChatTreeDao;
import com.zemrow.messenger.dao.ChatWorkDao;
import com.zemrow.messenger.dao.FileDao;
import com.zemrow.messenger.dao.constants.IdConstant;
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
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.ChatTree;
import com.zemrow.messenger.entity.Message;
import com.zemrow.messenger.entity.MessageToUser;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
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
public class RunStress {

    //    private static final int COUNT_USER = 5_000_000;
    private static final int COUNT_USER = 5_000;
    private static final int COUNT_SESSION = 10;
//    private static final int COUNT_USER_CONTACT = 200;
    private static final int COUNT_USER_CONTACT = 20;
//    private static final int COUNT_CHAT_MESSAGE = 500;
    private static final int COUNT_CHAT_MESSAGE = 50;

    public static void main(String[] args) {
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

        AtomicInteger userIndex = new AtomicInteger();
        new Timer(true).schedule(new TimerTask() {
            @Override public void run() {
                System.out.println(userIndex);
            }
        }, 5000, 10000);

        long time = System.currentTimeMillis();
        try (final Ignite ignite = Ignition.start(cfg)) {
            ignite.cluster().active(true);

            ChatDao chatDao = new ChatDao(ignite);
            ChatPriorityDao chatPriorityDao = new ChatPriorityDao(ignite);
            ChatRemindersDao chatRemindersDao = new ChatRemindersDao(ignite);
            ChatTagGroupDao chatTagGroupDao = new ChatTagGroupDao(ignite);
            ChatToUserDao chatToUserDao = new ChatToUserDao(ignite);
            ChatTreeDao chatTreeDao = new ChatTreeDao(ignite);
            ChatWorkDao chatWorkDao = new ChatWorkDao(ignite);
            FileDao fileDao = new FileDao(ignite);
            MessageDao messageDao = new MessageDao(ignite);
            MessageLogDao messageLogDao = new MessageLogDao(ignite);
            MessageTagDao messageTagDao = new MessageTagDao(ignite);
            MessageToUserDao messageToUserDao = new MessageToUserDao(ignite);
            NumberingDao numberingDao = new NumberingDao(ignite);
            RequestLogDao requestLogDao = new RequestLogDao(ignite);
            TagDao tagDao = new TagDao(ignite);
            UserContactDao userContactDao = new UserContactDao(ignite);
            UserDao userDao = new UserDao(ignite);
            UserEntryPointDao userEntryPointDao = new UserEntryPointDao(ignite);
            UserFilterDao userFilterDao = new UserFilterDao(ignite);
            UserLinkDao userLinkDao = new UserLinkDao(ignite);
            UserLogDao userLogDao = new UserLogDao(ignite);
            UserSessionDao userSessionDao = new UserSessionDao(ignite);
            UserSessionFailDao userSessionFailDao = new UserSessionFailDao(ignite);
            UserStatusDao userStatusDao = new UserStatusDao(ignite);
            UserTreeDao userTreeDao = new UserTreeDao(ignite);

            final SessionStorage session = new SessionStorage();
            session.setUserId(IdConstant.FIRST_ID_USER);

            // Статусы
            UserStatus userStatus = new UserStatus();
            userStatus.setLabel("В сети");
            userStatus.setUserStatusType(UserStatusTypeEnum.ONLINE);
            userStatus.setWeight(1000);
            userStatus.setColor(0x00ff00ff);
            userStatusDao.insert(session, userStatus);
            final long userStatusOnline = userStatus.getId();
            userStatus = new UserStatus();
            userStatus.setLabel("Не в сети");
            userStatus.setUserStatusType(UserStatusTypeEnum.OFFLINE);
            userStatus.setWeight(500);
            userStatus.setColor(0xff0000ff);
            userStatusDao.insert(session, userStatus);
            final long userStatusOffline = userStatus.getId();

            System.out.println("Пользователи");
            final List<Long> userIdList = new ArrayList<>(COUNT_USER);
            for (int i = 0; i < COUNT_USER; i++) {
                userIndex.set(i);
                final User user = new User();
                user.setName("username" + i);
                user.setUserType(UserTypeEnum.USER);
                user.setInfo(new HashMap<>());
                if (i % 4 == 0) {
                    user.setUserStatusId(userStatusOnline);
                }
                else {
                    user.setUserStatusId(userStatusOffline);
                }
                userDao.insert(session, user);
                userIdList.add(user.getId());



                // Способы авторизации пользователя
                final UserEntryPoint userEntryPoint = new UserEntryPoint();
                userEntryPoint.setUserId(user.getId());
                userEntryPoint.setValidate(true);
                userEntryPoint.setEntryPointType(EntryPointTypeEnum.LOGIN_PASSWORD);
                userEntryPoint.setClientId(user.getName());
                userEntryPoint.setCredential("password" + i);
                userEntryPointDao.insert(session, userEntryPoint);
                // Сессия пользователя
                for (int j = 0; j < COUNT_SESSION; j++) {
                    final UserSession userSession = new UserSession();
                    userSession.setUserEntryPointId(userEntryPoint.getId());
                    userSession.setToken(UUID.randomUUID().toString() + UUID.randomUUID().toString());
                    userSessionDao.insert(session, userSession);
                }
            }

            System.out.println("Чаты");
            int otherUserIndex = 0;
            for (int i = 0; i < COUNT_USER; i++) {
                userIndex.set(i);
                for (int j = 0; j < COUNT_USER_CONTACT; j++) {
                    final Long parentUserId = userIdList.get(i);
                    otherUserIndex++;
                    if (i == otherUserIndex) {
                        otherUserIndex++;
                    }
                    if (otherUserIndex >= COUNT_USER) {
                        otherUserIndex = 0;
                    }
                    final long childUserId = userIdList.get(otherUserIndex);

                    UserContact userContact = userContactDao.selectByParentUserIdAndChildUserId(session, parentUserId, childUserId);
                    if (userContact == null) {

                        userContact = userContactDao.selectByParentUserIdAndChildUserId(session, childUserId, parentUserId);
                        final long chatId;
                        if (userContact == null) {
                            final Chat chat = new Chat();
                            chat.setLabel(userDao.select(session, childUserId).getName());
                            chat.setChatType(ChatTypeEnum.CHAT);
                            chatDao.insert(session, chat);
                            chatId = chat.getId();

                            if (chat.getChatType() == ChatTypeEnum.ISSUE) {
                                chatPriorityDao.insert(session, chat.getId());
                            }

                            final ChatTree chatTree = new ChatTree();
                            chatTree.setParentChatId(chatId);
                            chatTree.setChildChatId(chatId);
                            chatTree.setDistance(0);
                            chatTreeDao.insert(session, chatTree);

                            ChatToUser chatToUser = new ChatToUser();
                            chatToUser.setChatId(chatId);
                            chatToUser.setUserId(parentUserId);
                            chatToUser.setChatToUserType(ChatToUserTypeEnum.DEFAULT);
                            chatToUserDao.insert(session, chatToUser);

                            chatToUser = new ChatToUser();
                            chatToUser.setChatId(chatId);
                            chatToUser.setUserId(childUserId);
                            chatToUser.setChatToUserType(ChatToUserTypeEnum.DEFAULT);
                            chatToUserDao.insert(session, chatToUser);
                        }
                        else {
                            chatId = userContact.getChatId();
                        }

                        userContact = new UserContact();
                        userContact.setParentUserId(parentUserId);
                        userContact.setChildUserId(childUserId);
                        userContact.setLabel(userDao.select(session, childUserId).getName());
                        userContact.setChatId(chatId);
                        userContactDao.insert(session, userContact);
                    }

                    for (int k = 0; k < COUNT_CHAT_MESSAGE; k++) {
                        final Message message = new Message();
                        message.setChatId(userContact.getChatId());
                        message.setText("message " + parentUserId + " " + childUserId + " " + k);
                        message.setMessageType(MessageTypeEnum.SIMPLE);
                        messageDao.insert(session, message);

                        MessageToUser messageToUser = new MessageToUser();
                        messageToUser.setMessageId(message.getId());
                        messageToUser.setUserId(parentUserId);
                        messageToUser.setMessageStatus(MessageStatusEnum.DELIVERED);
                        messageToUserDao.insert(session, messageToUser);

                        messageToUser = new MessageToUser();
                        messageToUser.setMessageId(message.getId());
                        messageToUser.setUserId(childUserId);
                        messageToUser.setMessageStatus(MessageStatusEnum.DELIVERED);
                        messageToUserDao.insert(session, messageToUser);
                    }
                }
            }

            time = System.currentTimeMillis() - time;
            System.out.println("Finish init " + time + " ms");
            time = System.currentTimeMillis();
        }

        time = System.currentTimeMillis() - time;
        System.out.println("Finish close " + time + " ms");
    }
}
