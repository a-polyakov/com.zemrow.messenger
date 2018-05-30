package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.constants.IdConstant;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UserSessionLogic {

    public SessionStorage getSystemSession(){
        SessionStorage session = new SessionStorage();
        session.setUserId(IdConstant.FIRST_ID_USER);
        return session;
    }
}
