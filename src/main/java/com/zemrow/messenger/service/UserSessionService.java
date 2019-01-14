package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.abstracts.Pair;
import com.zemrow.messenger.logic.PasswordLogic;
import com.zemrow.messenger.logic.UserEntryPointLogic;
import com.zemrow.messenger.logic.UserLogic;
import com.zemrow.messenger.logic.UserSessionLogic;
import com.zemrow.messenger.service.abstracts.AbstractService;
import org.apache.ignite.transactions.Transaction;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.10
 */
public class UserSessionService extends AbstractService {

    private final PasswordLogic passwordLogic;
    private final UserEntryPointLogic userEntryPointLogic;
    private final UserLogic userLogic;
    private final UserSessionLogic userSessionLogic;

    public UserSessionService(
            PasswordLogic passwordLogic,
            UserEntryPointLogic userEntryPointLogic,
            UserLogic userLogic,
            UserSessionLogic userSessionLogic) {
        this.passwordLogic = passwordLogic;
        this.userEntryPointLogic = userEntryPointLogic;
        this.userLogic = userLogic;
        this.userSessionLogic = userSessionLogic;
    }

    /**
     * Вход в систему.
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     */
    public Pair<UserEntryPoint, UserSession> insert(String username, String password) {
        Pair<UserEntryPoint, UserSession> result = null;
        //TODO проверка сложности логина, пароля
        //TODO
        try (Transaction tx = transaction()) {
            final String credential = passwordLogic.getCredential(username, password);
            final UserEntryPoint userEntryPoint = userEntryPointLogic.selectByLoginAndPassword(username, credential);
            if (userEntryPoint != null) {
                final SessionStorage session = userSessionLogic.getSystemSession();
                //TODO
//                sessionStorage.setUserType();
//                sessionStorage.setLocale();
//                sessionStorage.setTimeZone();

                UserSession userSession = new UserSession();
                userSession.setUserEntryPointId(userEntryPoint.getId());
                userSessionLogic.insert(session, userSession);

                tx.commit();
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
    public void delete(SessionStorage session) {
        try (Transaction transaction = transaction()) {
            userSessionLogic.delete(session, session.getToken());

            transaction.commit();
        }
    }

    /**
     * Создать сессию пользователя (проверить token).
     *
     * @param token Идентификатор сессии.
     * @return Сессия.
     */
    public SessionStorage getSessionStorage(String token) {
        SessionStorage result = null;
        if (token != null) {
            final UserSession userSession = userSessionLogic.select(token);
            if (userSession != null) {
                if (userSession.getDeleteTime() == null || userSession.getDeleteTime() > System.currentTimeMillis()) {
                    final UserEntryPoint userEntryPoint = userEntryPointLogic.select(userSession.getUserEntryPointId());
                    if (userEntryPoint != null) {
                        final User user = userLogic.select(userEntryPoint.getUserId());
                        if (user != null) {
                            result = new SessionStorage(user.getId());
                            result.setToken(token);
                            result.setUserType(user.getUserType());
                            //TODO
//                            result.setLocale(user.get());
//                            result.setTimeZone(user.get());
                        }
                    }
                }
            }
        }
        return result;
    }
}
