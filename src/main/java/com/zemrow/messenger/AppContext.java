package com.zemrow.messenger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemrow.messenger.controller.*;
import com.zemrow.messenger.dao.*;
import com.zemrow.messenger.logic.*;
import com.zemrow.messenger.service.*;
import com.zemrow.messenger.web.MessengerRout;
import com.zemrow.messenger.web.WebServer;
import com.zemrow.messenger.web.websocket.MessengerWebSocketListener;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.io.Closeable;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class AppContext implements Closeable {

    private final DataBase dataBase;

    private final ChatDao chatDao;
    private final ChatPriorityDao chatPriorityDao;
    private final ChatRemindersDao chatRemindersDao;
    private final ChatTagGroupDao chatTagGroupDao;
    private final ChatToUserDao chatToUserDao;
    private final ChatToUserLastMessageDao chatToUserLastMessageDao;
    private final ChatTreeDao chatTreeDao;
    private final ChatWorkDao chatWorkDao;
    private final DbVersionDao dbVersionDao;
    private final FileDao fileDao;
    private final MessageDao messageDao;
    private final MessageLogDao messageLogDao;
    private final MessageTagDao messageTagDao;
    private final MessageToUserDao messageToUserDao;
    private final NumberingDao numberingDao;
    private final RequestLogDao requestLogDao;
    private final TagDao tagDao;
    private final UserContactDao userContactDao;
    private final UserDao userDao;
    private final UserEntryPointDao userEntryPointDao;
    private final UserFilterDao userFilterDao;
    private final UserLinkDao userLinkDao;
    private final UserLogDao userLogDao;
    private final UserSessionDao userSessionDao;
    private final UserSessionFailDao userSessionFailDao;
    private final UserStatusDao userStatusDao;
    private final UserTreeDao userTreeDao;

    private final ChatLogic chatLogic;
    private final DbVersionLogic dbVersionLogic;
    private final PasswordLogic passwordLogic;
    private final UserContactLogic userContactLogic;
    private final UserEntryPointLogic userEntryPointLogic;
    private final UserLogic userLogic;
    private final UserSessionLogic userSessionLogic;
    private final UserStatusLogic userStatusLogic;

    private final ChatService chatService;
    private final DbVersionService dbVersionService;
    private final MessageService messageService;
    private final NumberingService numberingService;
    private final TagService tagService;
    private final UserContactService userContactService;
    private final UserService userService;
    private final UserSessionService userSessionService;
    private final UserStatusService userStatusService;

    private final ChatController chatController;
    private final MessageController messageController;
    private final NumberingController numberingController;
    private final TagController tagController;
    private final UserContactController userContactController;
    private final UserController userController;
    private final UserSessionController userSessionController;
    private final UserStatusController userStatusController;

    private final MessengerRout rout;
    private final ObjectMapper jsonMapper;
    private final MessengerWebSocketListener webSocketListener;
    private final WebServer webServer;

    public AppContext(AppConfiguration appConfiguration) {
        try {
            // Инициализация логера
            SLF4JBridgeHandler.install();

            jsonMapper = new ObjectMapper();
            jsonMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            jsonMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

            dataBase = new DataBase(appConfiguration);

            chatDao = new ChatDao(dataBase);
            chatPriorityDao = new ChatPriorityDao(dataBase);
            chatRemindersDao = new ChatRemindersDao(dataBase);
            chatTagGroupDao = new ChatTagGroupDao(dataBase);
            chatToUserDao = new ChatToUserDao(dataBase);
            chatToUserLastMessageDao = new ChatToUserLastMessageDao(dataBase);
            chatTreeDao = new ChatTreeDao(dataBase);
            chatWorkDao = new ChatWorkDao(dataBase);
            dbVersionDao = new DbVersionDao(dataBase);
            fileDao = new FileDao(dataBase);
            messageDao = new MessageDao(dataBase);
            messageLogDao = new MessageLogDao(dataBase);
            messageTagDao = new MessageTagDao(dataBase);
            messageToUserDao = new MessageToUserDao(dataBase);
            numberingDao = new NumberingDao(dataBase);
            requestLogDao = new RequestLogDao(dataBase);
            tagDao = new TagDao(dataBase);
            userContactDao = new UserContactDao(dataBase);
            userDao = new UserDao(dataBase);
            userEntryPointDao = new UserEntryPointDao(dataBase);
            userFilterDao = new UserFilterDao(dataBase);
            userLinkDao = new UserLinkDao(dataBase);
            userLogDao = new UserLogDao(dataBase);
            userSessionDao = new UserSessionDao(dataBase);
            userSessionFailDao = new UserSessionFailDao(dataBase);
            userStatusDao = new UserStatusDao(dataBase);
            userTreeDao = new UserTreeDao(dataBase);

            chatLogic = new ChatLogic(chatDao, chatPriorityDao, chatToUserDao, chatTreeDao);
            dbVersionLogic = new DbVersionLogic(dbVersionDao);
            passwordLogic = new PasswordLogic();
            userContactLogic = new UserContactLogic(userContactDao, userDao);
            userEntryPointLogic = new UserEntryPointLogic(userEntryPointDao);
            userLogic = new UserLogic(userDao, userTreeDao, userStatusDao);
            userSessionLogic = new UserSessionLogic(userSessionDao);
            userStatusLogic = new UserStatusLogic(userStatusDao);

            chatService = new ChatService(chatLogic);
            dbVersionService = new DbVersionService(dbVersionLogic, userDao, userSessionLogic, userStatusLogic);
            messageService = new MessageService();
            numberingService = new NumberingService();
            tagService = new TagService();
            userContactService = new UserContactService(chatLogic, userContactLogic);
            userService = new UserService(chatLogic, passwordLogic, userContactLogic, userEntryPointLogic, userLogic, userSessionLogic, userStatusLogic);
            userSessionService = new UserSessionService(passwordLogic, userEntryPointLogic, userLogic, userSessionLogic);
            userStatusService = new UserStatusService();

            chatController = new ChatController(jsonMapper, chatService);
            messageController = new MessageController(messageService);
            numberingController = new NumberingController(numberingService);
            tagController = new TagController(tagService);
            userContactController = new UserContactController(jsonMapper, userContactService);
            userController = new UserController(jsonMapper, userService);
            userSessionController = new UserSessionController(jsonMapper, userSessionService);
            userStatusController = new UserStatusController(userStatusService);

            rout = new MessengerRout(chatController, messageController, numberingController,
                    tagController, userContactController, userController,
                    userSessionController, userStatusController);

            webSocketListener = new MessengerWebSocketListener(jsonMapper, rout, userSessionController);
            webServer = new WebServer(appConfiguration, jsonMapper, rout, webSocketListener);
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
        if (webServer != null) {
            webServer.close();
        }
        if (dataBase != null) {
            dataBase.close();
        }
    }

//================================ AUTO GENERATE ==============================


    public ChatService getChatService() {
        return chatService;
    }

    public DbVersionService getDbVersionService() {
        return dbVersionService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public NumberingService getNumberingService() {
        return numberingService;
    }

    public TagService getTagService() {
        return tagService;
    }

    public UserContactService getUserContactService() {
        return userContactService;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserSessionService getUserSessionService() {
        return userSessionService;
    }

    public UserStatusService getUserStatusService() {
        return userStatusService;
    }
}
