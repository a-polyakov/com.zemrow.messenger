package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateOnly;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.RequestLog;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с логированием запросов
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class RequestLogDao extends AbstractDaoCreateOnly<RequestLog> {

    public RequestLogDao(DataBase dataBase) {
        super(dataBase, RequestLog.class, IdConstant.FIRST_ID_REQUEST_LOG, 1);
    }

    /**
     * TODO
     */
    @Override
    protected RequestLog select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, RequestLog entity) {
        super.update(session, entity);
    }
}
