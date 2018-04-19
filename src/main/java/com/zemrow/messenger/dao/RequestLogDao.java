package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.RequestLog;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с логированием запросов
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class RequestLogDao extends AbstractDaoCreateOnly<RequestLog> {

    public RequestLogDao(Ignite ignite) {
        super(ignite, RequestLog.class, 1);
    }
}
