package com.zemrow.messenger.server;

import com.zemrow.messenger.controller.ChatController;
import com.zemrow.messenger.controller.MessageController;
import com.zemrow.messenger.controller.NumberingController;
import com.zemrow.messenger.controller.TagController;
import com.zemrow.messenger.controller.UserContactController;
import com.zemrow.messenger.controller.UserController;
import com.zemrow.messenger.controller.UserInsertController;
import com.zemrow.messenger.controller.UserSessionController;
import com.zemrow.messenger.controller.UserSessionInsertController;
import com.zemrow.messenger.controller.UserStatusController;
import com.zemrow.messenger.dao.ChatDao;
import com.zemrow.messenger.dao.ChatPriorityDao;
import com.zemrow.messenger.dao.ChatToUserDao;
import com.zemrow.messenger.dao.ChatTreeDao;
import com.zemrow.messenger.dao.UserContactDao;
import com.zemrow.messenger.dao.UserEntryPointDao;
import com.zemrow.messenger.dao.UserInfoDao;
import com.zemrow.messenger.dao.UserSessionDao;
import com.zemrow.messenger.dao.UserStatusDao;
import com.zemrow.messenger.dao.UserTreeDao;
import com.zemrow.messenger.json.JsonMapper;
import com.zemrow.messenger.logic.ChatLogic;
import com.zemrow.messenger.logic.ChatToUserLogic;
import com.zemrow.messenger.logic.PasswordLogic;
import com.zemrow.messenger.logic.UserContactLogic;
import com.zemrow.messenger.logic.UserEntryPointLogic;
import com.zemrow.messenger.logic.UserInfoLogic;
import com.zemrow.messenger.logic.UserSessionLogic;
import com.zemrow.messenger.logic.UserStatusLogic;
import com.zemrow.messenger.logic.UserTreeLogic;
import com.zemrow.messenger.mq.ClusterMessaging;
import com.zemrow.messenger.service.ChatService;
import com.zemrow.messenger.service.UserContactService;
import com.zemrow.messenger.service.UserInfoService;
import com.zemrow.messenger.service.UserSessionService;
import com.zemrow.messenger.service.transaction.DataBase;
import com.zemrow.messenger.websocket.MessengerWebSocketListener;

import java.io.Closeable;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class ServerContext implements Closeable {

    private final ChatDao chatDao;
    private final ChatPriorityDao chatPriorityDao;
    private final ChatToUserDao chatToUserDao;
    private final ChatTreeDao chatTreeDao;
    private final UserContactDao userContactDao;
    private final UserEntryPointDao userEntryPointDao;
    private final UserInfoDao userInfoDao;
    private final UserSessionDao userSessionDao;
    private final UserStatusDao userStatusDao;
    private final UserTreeDao userTreeDao;

    private final ChatToUserLogic chatToUserLogic;
    private final ChatLogic chatLogic;
    private final PasswordLogic passwordLogic;
    private final UserContactLogic userContactLogic;
    private final UserEntryPointLogic userEntryPointLogic;
    private final UserInfoLogic userInfoLogic;
    private final UserSessionLogic userSessionLogic;
    private final UserStatusLogic userStatusLogic;
    private final UserTreeLogic userTreeLogic;

    private final DataBase dataBase;

    private final ChatService chatService;
    private final UserContactService userContactService;
    private final UserInfoService userInfoService;
    private final UserSessionService userSessionService;

    private final JsonMapper jsonMapper;

    private final ChatController chatController;
    private final MessageController messageController;
    private final NumberingController numberingController;
    private final TagController tagController;
    private final UserContactController userContactController;
    private final UserController userController;
    private final UserInsertController userInsertController;
    private final UserSessionController userSessionController;
    private final UserSessionInsertController userSessionInsertController;
    private final UserStatusController userStatusController;

    private final MessengerRout rout;

    private final ClusterMessaging clusterMessaging;
    private final MessengerWebSocketListener webSocketListener;
    private final WebServer webServer;

    public ServerContext(ServerConfiguration serverConfiguration) {
        try {
            //            TODO
            // Инициализация логера
            //            SLF4JBridgeHandler.install();
            System.setProperty("org.jboss.logging.provider", "slf4j");

            chatDao = new ChatDao();
            chatPriorityDao = new ChatPriorityDao();
            chatToUserDao = new ChatToUserDao();
            chatTreeDao = new ChatTreeDao();
            userContactDao = new UserContactDao();
            userEntryPointDao = new UserEntryPointDao();
            userInfoDao = new UserInfoDao();
            userSessionDao = new UserSessionDao();
            userStatusDao = new UserStatusDao();
            userTreeDao = new UserTreeDao();

            chatToUserLogic = new ChatToUserLogic(chatToUserDao);
            userInfoLogic = new UserInfoLogic(userInfoDao, userTreeDao);
            chatLogic = new ChatLogic(chatToUserLogic, userInfoLogic, chatDao, chatPriorityDao, chatTreeDao);
            passwordLogic = new PasswordLogic();
            userContactLogic = new UserContactLogic(userContactDao, userInfoDao);
            userEntryPointLogic = new UserEntryPointLogic(userEntryPointDao);
            userSessionLogic = new UserSessionLogic(userSessionDao);
            userStatusLogic = new UserStatusLogic(userStatusDao);
            userTreeLogic = new UserTreeLogic(userTreeDao);

            dataBase = new DataBase(serverConfiguration.getDatabaseUrl(), serverConfiguration.getDatabaseUsername(),
                    serverConfiguration.getDatabasePassword());

            chatService = new ChatService(dataBase, chatLogic);
            userContactService = new UserContactService(dataBase, userContactLogic, chatLogic);
            userInfoService = new UserInfoService(dataBase, chatLogic, passwordLogic, userContactLogic, userEntryPointLogic,
                    userInfoLogic, userSessionLogic, userStatusLogic, userTreeLogic);
            userSessionService = new UserSessionService(dataBase, passwordLogic, userEntryPointLogic, userInfoLogic, userSessionLogic);

            jsonMapper = new JsonMapper();

            chatController = new ChatController(chatService);
            messageController = new MessageController();
            numberingController = new NumberingController();
            tagController = new TagController();
            userContactController = new UserContactController(userContactService);
            userController = new UserController(userInfoService);
            userInsertController = new UserInsertController(jsonMapper, userInfoService);
            userSessionController = new UserSessionController(userSessionService);
            userSessionInsertController = new UserSessionInsertController(jsonMapper, userSessionService);
            userStatusController = new UserStatusController();

            rout = new MessengerRout(chatController, messageController, numberingController, tagController, userContactController,
                    userController, userSessionController, userStatusController);

            clusterMessaging = new ClusterMessaging();
            webSocketListener = new MessengerWebSocketListener(jsonMapper, rout, userSessionController, chatController, clusterMessaging);
            webServer = new WebServer(serverConfiguration, userInsertController, userSessionInsertController, webSocketListener);
        } catch (Throwable e) {
            close();
            throw e;
        }

        //TODO
        //        new Timer(true).schedule(new TimerTask() {
        //            @Override
        //            public void run() {
        //            }
        //        }, 5000, 5000);
    }

    @Override
    public void close() {
        close(webServer);
        close(clusterMessaging);
        close(dataBase);
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                //TODO
                e.printStackTrace();
            }
        }
    }

//================================ AUTO GENERATE ==============================

}
