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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RequestLog{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", token='").append(token).append('\'');
        sb.append(", serviceId='").append(serviceId).append('\'');
        sb.append(", action='").append(action).append('\'');
        sb.append(", startInvoke=").append(startInvoke);
        sb.append(", endInvoke=").append(endInvoke);
        sb.append(", errorStackTrace='").append(errorStackTrace).append('\'');
    }
}
