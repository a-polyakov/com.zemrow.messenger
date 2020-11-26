package com.zemrow.messenger.dao;

import com.querydsl.sql.SQLExpressions;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.DBConst;
import com.zemrow.messenger.constants.LocaleConst;
import com.zemrow.messenger.constants.TimeZoneConst;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.constants.ChatConst;
import com.zemrow.messenger.entity.constants.ChatPriorityConst;
import com.zemrow.messenger.entity.constants.ChatToUserConst;
import com.zemrow.messenger.entity.constants.ChatTreeConst;
import com.zemrow.messenger.entity.constants.UserContactConst;
import com.zemrow.messenger.entity.constants.UserEntryPointConst;
import com.zemrow.messenger.entity.constants.UserInfoConst;
import com.zemrow.messenger.entity.constants.UserSessionConst;
import com.zemrow.messenger.entity.constants.UserTreeConst;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.UserStatusEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Общая часть тестов
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class AbstractTest {

    private static final Logger log = LogManager.getLogger(ChatDaoTest.class);
    //TODO
    public static final long TEST_USER_ID = 2L;

    //TODO
    protected Connection connection;

    /**
     * TODO
     */
    protected static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DBConst.DRIVER_CLASS_NAME);
        final String url = DBConst.DEFAULT_URL;
        final String username = DBConst.DEFAULT_USER;
        final String password = DBConst.DEFAULT_PASSWORD;
        final Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        return connection;
    }

    /**
     * TODO
     */
    protected SessionStorage getSession() {
        final SessionStorage session = new SessionStorage("testToken", TEST_USER_ID, LocaleConst.EN, TimeZoneConst.MSK);

        final UserInfoDao userInfoDao = new UserInfoDao();
        UserInfo userInfo = userInfoDao.select(connection, TEST_USER_ID);
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setId(session.getUserId());
            userInfo.setName("test");
            userInfo.setUserType(UserTypeEnum.USER);
            userInfo.setUserStatus(UserStatusEnum.ONLINE);
            userInfo.setPublicInfo("{}");
            userInfo.setLocale(session.getLocale());
            userInfo.setTimeZone(session.getTimeZone());
            userInfoDao.insert(connection, session, userInfo);
        }
        return session;
    }

    @BeforeEach
    public void beforeTest() throws SQLException, ClassNotFoundException {
        connection = getConnection();
    }

    @AfterEach
    public void afterTest() {
        try {
            connection.rollback();
        } catch (Exception e) {
        }
        try {
            connection.close();
        } catch (Exception e) {
        }
    }

    @BeforeAll
    public static void deleteTestUser() throws SQLException, ClassNotFoundException {
        log.debug("BeforeAll begin");
        try (Connection connection = getConnection()) {
            final ChatPriorityConst chatPriority = ChatPriorityConst.ChatPriority;
            final ChatConst chat = ChatConst.Chat;
            SQLDeleteClause query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, chatPriority);
            final SQLQuery<Long> selectChatIdByCreatedUserId = SQLExpressions.select(chat.id).from(chat).where(chat.createdBy.eq(TEST_USER_ID));
            query.where(chatPriority.chatId.in(selectChatIdByCreatedUserId));
            final long deleteChatPriorityCount = query.execute();
            log.debug("deleteChatPriorityCount {}", deleteChatPriorityCount);

            final ChatToUserConst chatToUser = ChatToUserConst.ChatToUser;
            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, chatToUser);
            query.where(chatToUser.chatId.in(selectChatIdByCreatedUserId));
            final long deleteChatToUserCount = query.execute();
            log.debug("deleteChatToUserCount {}", deleteChatToUserCount);

            final ChatTreeConst chatTree = ChatTreeConst.ChatTree;
            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, chatTree);
            query.where(chatTree.parentChatId.in(selectChatIdByCreatedUserId));
            final long deleteChatTreeCount = query.execute();
            log.debug("deleteChatTreeCount {}", deleteChatTreeCount);

            final UserContactConst userContact = UserContactConst.UserContact;
            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, userContact);
            query.where(userContact.parentUserId.eq(TEST_USER_ID));
            final long deleteUserContactCount = query.execute();
            log.debug("deleteUserContactCount {}", deleteUserContactCount);

            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, chat);
            query.where(chat.createdBy.eq(TEST_USER_ID));
            final long deleteChatCount = query.execute();
            log.debug("deleteChatCount {}", deleteChatCount);

            final UserSessionConst userSession = UserSessionConst.UserSession;
            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, userSession);
            final UserEntryPointConst userEntryPoint = UserEntryPointConst.UserEntryPoint;
            final SQLQuery<Long> selectUserEntryPointIdByUserId = SQLExpressions.select(userEntryPoint.id).from(userEntryPoint).where(userEntryPoint.userId.eq(TEST_USER_ID));
            query.where(userSession.userEntryPointId.in(selectUserEntryPointIdByUserId));
            final long deleteUserSessionCount = query.execute();
            log.debug("deleteUserSessionCount {}", deleteUserSessionCount);

            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, userEntryPoint);
            query.where(userEntryPoint.userId.eq(TEST_USER_ID));
            final long deleteUserEntryPointCount = query.execute();
            log.debug("deleteUserEntryPointCount {}", deleteUserEntryPointCount);

            final UserTreeConst userTree = UserTreeConst.UserTree;
            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, userTree);
            query.where(userTree.parentUserId.eq(TEST_USER_ID));
            final long deleteUserTreeCount = query.execute();
            log.debug("deleteUserTreeCount {}", deleteUserTreeCount);

            final UserInfoConst userInfo = UserInfoConst.UserInfo;
            query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, userInfo);
            query.where(userInfo.id.eq(TEST_USER_ID));
            final long deleteUserCount = query.execute();
            log.debug("deleteUserCount {}", deleteUserCount);

            connection.commit();
        }
        log.debug("BeforeAll end");
    }

    /**
     * Создать чат
     *
     * @param chatDao TODO
     * @param session TODO
     * @return chat
     */
    protected Chat insertChat(ChatDao chatDao, SessionStorage session) {
        final Chat chat = new Chat();
        chat.setId(chatDao.nextId());
        chat.setChatType(ChatTypeEnum.CHAT);
        chat.setLabel("Chat");
        chatDao.insert(connection, session, chat);
        return chat;
    }
}