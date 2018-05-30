package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.User;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import com.zemrow.messenger.exception.UniqueConstraintViolationException;
import com.zemrow.messenger.logic.UserLogic;
import com.zemrow.messenger.logic.UserSessionLogic;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.ignite.Ignition;
import org.apache.ignite.transactions.Transaction;

import static org.apache.ignite.transactions.TransactionConcurrency.PESSIMISTIC;
import static org.apache.ignite.transactions.TransactionIsolation.REPEATABLE_READ;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserService {

    private final UserLogic userLogic;
    private final UserSessionLogic userSessionLogic;

    public UserService(UserLogic userLogic, UserSessionLogic userSessionLogic) {
        this.userLogic = userLogic;
        this.userSessionLogic = userSessionLogic;
    }

    public void registration(String username, String password) {
        try (Transaction tx = Ignition.ignite().transactions().txStart(PESSIMISTIC, REPEATABLE_READ)) {
            final SessionStorage session = userSessionLogic.getSystemSession();
            final User user = new User();
            user.setUserType(UserTypeEnum.USER);
            user.setName(username);
            // TODO
//            user.setUserStatusId();
            userLogic.insert(session, user);

            // TODO
//            UserEntryPoint
//            UserSession


            tx.commit();
        }
    }
}
