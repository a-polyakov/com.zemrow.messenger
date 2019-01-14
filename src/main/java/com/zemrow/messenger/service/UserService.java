package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.abstracts.Triplet;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import com.zemrow.messenger.logic.*;
import com.zemrow.messenger.service.abstracts.AbstractService;
import org.apache.ignite.transactions.Transaction;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserService extends AbstractService {

    private final ChatLogic chatLogic;
    private final PasswordLogic passwordLogic;
    private final UserContactLogic userContactLogic;
    private final UserEntryPointLogic userEntryPointLogic;
    private final UserLogic userLogic;
    private final UserSessionLogic userSessionLogic;
    private final UserStatusLogic userStatusLogic;

    public UserService(
            ChatLogic chatLogic,
            PasswordLogic passwordLogic,
            UserContactLogic userContactLogic,
            UserEntryPointLogic userEntryPointLogic,
            UserLogic userLogic,
            UserSessionLogic userSessionLogic,
            UserStatusLogic userStatusLogic
    ) {
        this.chatLogic = chatLogic;
        this.passwordLogic = passwordLogic;
        this.userContactLogic = userContactLogic;
        this.userEntryPointLogic = userEntryPointLogic;
        this.userLogic = userLogic;
        this.userSessionLogic = userSessionLogic;
        this.userStatusLogic = userStatusLogic;
    }

    /**
     * Регистрация пользователя.
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     */
    public Triplet<User, UserEntryPoint, UserSession> insert(String username, String password) {
        final SessionStorage session = userSessionLogic.getSystemSession();
        // TODO проверка сложности логина, пароля
        try (Transaction transaction = transaction()) {
            // TODO проверка на существование пользователя с таким логином
            final User user = new User();
            user.setUserType(UserTypeEnum.USER);
            user.setName(username);
            final Long userStatusId = userStatusLogic.selectIdByType(session, UserStatusTypeEnum.ONLINE);
            user.setUserStatusId(userStatusId);
            userLogic.insert(session, user);

            final UserEntryPoint userEntryPoint = new UserEntryPoint();
            userEntryPoint.setUserId(user.getId());
            userEntryPoint.setValidate(true);
            userEntryPoint.setEntryPointType(EntryPointTypeEnum.LOGIN_PASSWORD);
            userEntryPoint.setClientId(username);
            userEntryPoint.setCredential(passwordLogic.getCredential(username, password));
            userEntryPointLogic.insert(session, userEntryPoint);

            final UserSession userSession = new UserSession();
            userSession.setUserEntryPointId(userEntryPoint.getId());
            userSessionLogic.insert(session, userSession);

            //создание контакта с собой
            final Chat chat = chatLogic.insert(session, ChatTypeEnum.CONTACT, user.getId());
            userContactLogic.insert(session, user.getId(), user.getId(), chat.getId(), true);

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
    public User select(final SessionStorage session, Long userId) {
        if (userId == null) {
            userId = session.getUserId();
        }
        //TODO разграничение доступа: какую информацию может видеть лубой человек какую из списка контактов
        return userLogic.select(userId);
    }

    /**
     * Сменить статус пользователя.
     *
     * @param statusId Идендификатор статуса.
     */
    public void updateStatus(Long statusId) {
        //TODO
    }

    /**
     * Наити пользователей.
     *
     * @param session  TODO
     * @param userLike TODO
     * @param offset   TODO
     * @param limit    TODO
     * @return TODO
     */
    public PageNavigationDto<UserTiledDto> find(SessionStorage session, String userLike, int offset, int limit) {
        try (Transaction transaction = transaction()) {
            return userLogic.find(session, userLike, offset, limit);
        }
    }
}
