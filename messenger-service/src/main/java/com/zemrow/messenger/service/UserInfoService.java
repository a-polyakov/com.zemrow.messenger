package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.Triplet;
import com.zemrow.messenger.dto.UserInsertRequest;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import com.zemrow.messenger.entity.enums.UserContactStatusEnum;
import com.zemrow.messenger.entity.enums.UserStatusEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import com.zemrow.messenger.exception.NotNullConstraintViolationException;
import com.zemrow.messenger.logic.ChatLogic;
import com.zemrow.messenger.logic.PasswordLogic;
import com.zemrow.messenger.logic.UserContactLogic;
import com.zemrow.messenger.logic.UserEntryPointLogic;
import com.zemrow.messenger.logic.UserInfoLogic;
import com.zemrow.messenger.logic.UserSessionLogic;
import com.zemrow.messenger.logic.UserStatusLogic;
import com.zemrow.messenger.logic.UserTreeLogic;
import com.zemrow.messenger.service.transaction.DataBase;
import com.zemrow.messenger.service.transaction.ReadOnly;
import com.zemrow.messenger.service.transaction.Transaction;

import java.sql.Connection;
import java.time.ZoneId;
import java.util.Locale;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserInfoService extends AbstractService<UserInfoLogic> {

    private final ChatLogic chatLogic;
    private final PasswordLogic passwordLogic;
    private final UserContactLogic userContactLogic;
    private final UserEntryPointLogic userEntryPointLogic;
    private final UserSessionLogic userSessionLogic;
    //TODO
    private final UserStatusLogic userStatusLogic;
    //TODO
    private final UserTreeLogic userTreeLogic;

    public UserInfoService(
            DataBase dataBase,
            ChatLogic chatLogic,
            PasswordLogic passwordLogic,
            UserContactLogic userContactLogic,
            UserEntryPointLogic userEntryPointLogic,
            UserInfoLogic userInfoLogic,
            UserSessionLogic userSessionLogic,
            UserStatusLogic userStatusLogic,
            UserTreeLogic userTreeLogic
    ) {
        super(dataBase, userInfoLogic);
        this.chatLogic = chatLogic;
        this.passwordLogic = passwordLogic;
        this.userContactLogic = userContactLogic;
        this.userEntryPointLogic = userEntryPointLogic;
        this.userSessionLogic = userSessionLogic;
        this.userStatusLogic = userStatusLogic;
        this.userTreeLogic = userTreeLogic;
    }

    /**
     * Регистрация пользователя.
     *
     * @param request Имя пользователя, пароль пользователя, язык, часовой пояс.
     */
    public Triplet<UserInfo, UserEntryPoint, UserSession> insert(UserInsertRequest request) throws Exception {
        // TODO проверка сложности логина, пароля
        if (request.getUsername() == null) {
            throw new NotNullConstraintViolationException(UserInsertRequest.USERNAME_NOTNULL);
        }
        final String username = request.getUsername().trim();
        if (username.isEmpty()) {
            throw new NotNullConstraintViolationException(UserInsertRequest.USERNAME_NOTNULL);
        }
        if (request.getPassword() == null) {
            throw new NotNullConstraintViolationException(UserInsertRequest.PASSWORD_NOTNULL);
        }
        final String password = request.getPassword().trim();
        if (password.isEmpty()) {
            throw new NotNullConstraintViolationException(UserInsertRequest.PASSWORD_NOTNULL);
        }
        if (request.getLocale() == null) {
            throw new NotNullConstraintViolationException(UserInsertRequest.LOCALE_NOTNULL);
        }
        if (request.getTimeZone() == null) {
            throw new NotNullConstraintViolationException(UserInsertRequest.TIME_ZONE_NOTNULL);
        }
        final Locale locale = Locale.forLanguageTag(request.getLocale());
        final ZoneId timeZone = ZoneId.of(request.getTimeZone());

        final SessionStorage session = new SessionStorage(
                userSessionLogic.nextId(),
                logic.nextId(),
                locale,
                timeZone);
        try (Transaction transaction = transaction()) {
            final Connection connection = transaction.getConnection();

            final UserInfo user = new UserInfo();
            user.setId(session.getUserId());
            user.setName(username);
            user.setUserType(UserTypeEnum.USER);
            user.setPublicInfo("{}");
            user.setUserStatus(UserStatusEnum.ONLINE);
            user.setLocale(locale);
            user.setTimeZone(timeZone);
            logic.insert(connection, session, user);

            final UserEntryPoint userEntryPoint = new UserEntryPoint();
            userEntryPoint.setId(session.getUserId());
            userEntryPoint.setUserId(user.getId());
            userEntryPoint.setValidate(true);
            userEntryPoint.setEntryPointType(EntryPointTypeEnum.LOGIN_PASSWORD);
            userEntryPoint.setClientId(username);
            userEntryPoint.setCredential(passwordLogic.getCredential(username, password));
            userEntryPointLogic.insert(connection, session, userEntryPoint);

            final UserSession userSession = userSessionLogic.insert(connection, session.getToken(), userEntryPoint.getId());

            // создание контакта с собой
            final Chat chat = chatLogic.insert(connection, session, ChatTypeEnum.CONTACT, user.getId());
            userContactLogic.insert(connection, session, user.getId(), user.getId(), chat.getId(), UserContactStatusEnum.ACCEPT);

            transaction.commit();
            return new Triplet<>(user, userEntryPoint, userSession);
        }
    }

    /**
     * Получить информацию о пользователе.
     *
     * @param session TODO
     * @param userId  идентификатор пользователя.
     */
    public UserInfo select(final SessionStorage session, Long userId) throws Exception {
        if (userId == null) {
            userId = session.getUserId();
        }
        //TODO разграничение доступа: какую информацию может видеть любой человек какую из списка контактов
        try(final ReadOnly readOnly = readOnly()) {
            return logic.select(readOnly.getConnection(), userId);
        }
    }

    /**
     * Найти пользователей.
     *
     * @param session  TODO
     * @param userLike TODO
     * @param offset   TODO
     * @param limit    TODO
     * @return TODO
     */
    public PageNavigationDto<UserTiledDto> find(SessionStorage session, String userLike, Long offset, Long limit) throws Exception {
        userLike=userLike.trim();
        try (Transaction transaction = transaction()) {
            return logic.find(transaction.getConnection(), session, userLike, offset, limit);
        }
    }
}
