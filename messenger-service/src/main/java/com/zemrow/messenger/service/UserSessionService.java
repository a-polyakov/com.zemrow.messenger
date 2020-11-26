package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.Pair;
import com.zemrow.messenger.dto.UserSessionInsertRequest;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.exception.NotAuthorizedException;
import com.zemrow.messenger.exception.NotNullConstraintViolationException;
import com.zemrow.messenger.logic.PasswordLogic;
import com.zemrow.messenger.logic.UserEntryPointLogic;
import com.zemrow.messenger.logic.UserInfoLogic;
import com.zemrow.messenger.logic.UserSessionLogic;
import com.zemrow.messenger.service.transaction.DataBase;
import com.zemrow.messenger.service.transaction.ReadOnly;
import com.zemrow.messenger.service.transaction.Transaction;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.10
 */
public class UserSessionService extends AbstractService<UserSessionLogic> {

    private final PasswordLogic passwordLogic;
    private final UserEntryPointLogic userEntryPointLogic;
    private final UserInfoLogic userInfoLogic;

    public UserSessionService(
            DataBase dataBase,
            PasswordLogic passwordLogic,
            UserEntryPointLogic userEntryPointLogic,
            UserInfoLogic userInfoLogic,
            UserSessionLogic userSessionLogic) {
        super(dataBase, userSessionLogic);
        this.passwordLogic = passwordLogic;
        this.userEntryPointLogic = userEntryPointLogic;
        this.userInfoLogic = userInfoLogic;
    }

    /**
     * Вход в систему.
     *
     * @param request Имя пользователя, пароль пользователя.
     */
    public Pair<UserEntryPoint, UserSession> insert(UserSessionInsertRequest request) throws Exception {
        Pair<UserEntryPoint, UserSession> result = null;
        if (request.getUsername() == null) {
            throw new NotNullConstraintViolationException(UserSessionInsertRequest.USERNAME_NOTNULL);
        }
        final String username = request.getUsername().trim();
        if (username.isEmpty()) {
            throw new NotNullConstraintViolationException(UserSessionInsertRequest.USERNAME_NOTNULL);
        }
        if (request.getPassword() == null) {
            throw new NotNullConstraintViolationException(UserSessionInsertRequest.PASSWORD_NOTNULL);
        }
        final String password = request.getPassword().trim();
        if (password.isEmpty()) {
            throw new NotNullConstraintViolationException(UserSessionInsertRequest.PASSWORD_NOTNULL);
        }
        // TODO добавлять таймаут если были неудачные попытки
        //TODO
        try (Transaction transaction = transaction()) {
            final String credential = passwordLogic.getCredential(username, password);
            final UserEntryPoint userEntryPoint = userEntryPointLogic.selectByLoginAndPassword(transaction.getConnection(), username, credential);
            if (userEntryPoint != null) {
                final UserSession userSession = logic.insert(transaction.getConnection(), logic.nextId(), userEntryPoint.getId());
                transaction.commit();
                result = new Pair<>(userEntryPoint, userSession);
            }
        }
        return result;
    }

    /**
     * Выход из системы (только текущую сессию)
     *
     * @param session TODO
     */
    public void delete(SessionStorage session) throws Exception {
        try (Transaction transaction = transaction()) {
            logic.delete(transaction.getConnection(), session, session.getToken());

            transaction.commit();
        }
    }

    /**
     * Создать контекст сессии пользователя (проверить token).
     *
     * @param token Идентификатор сессии.
     * @return Сессия.
     */
    public SessionStorage getSessionStorage(String token) throws Exception {
        SessionStorage result = null;
        if (token != null) {
            try (ReadOnly readOnly = readOnly()) {
                // TODO оптимизировать: выполнять одним запросом
                // TODO добавить кеширование
                final UserSession userSession = logic.select(readOnly.getConnection(), token);
                if (userSession != null) {
                    if (userSession.getDeleteTime() == null || userSession.getDeleteTime() > System.currentTimeMillis()) {
                        final UserEntryPoint userEntryPoint = userEntryPointLogic.select(readOnly.getConnection(), userSession.getUserEntryPointId());
                        if (userEntryPoint != null) {
                            final UserInfo user = userInfoLogic.select(readOnly.getConnection(), userEntryPoint.getUserId());
                            if (user != null) {
                                result = new SessionStorage(token, user.getId(), user.getLocale(), user.getTimeZone());
                            }
                        }
                    }
                }
            }
        }
        if (result == null) {
            throw new NotAuthorizedException("TODO");
        }
        return result;
    }
}
