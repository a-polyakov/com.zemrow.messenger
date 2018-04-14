package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;

/**
 * Логи вызовов сервисов
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class RequestLog extends AbstractEntityCreateOnly {
    /**
     * Уникальный идентификатор сессии пользователя
     */
    public String token;
    /**
     * Идентификатор сервиса
     */
    public String serviceId;
    /**
     * Имя метода
     */
    public String action;
    /**
     * Время запуска
     */
    public Long startInvoke;
    /**
     * Время окончания
     */
    public Long endInvoke;
    /**
     * Ошибка если была (stacktrace)
     */
    public String errorStackTrace;

//================================ AUTO GENERATE ==============================

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getStartInvoke() {
        return startInvoke;
    }

    public void setStartInvoke(Long startInvoke) {
        this.startInvoke = startInvoke;
    }

    public Long getEndInvoke() {
        return endInvoke;
    }

    public void setEndInvoke(Long endInvoke) {
        this.endInvoke = endInvoke;
    }

    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    public void setErrorStackTrace(String errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }
}
