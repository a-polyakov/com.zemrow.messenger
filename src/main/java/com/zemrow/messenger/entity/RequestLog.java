package com.zemrow.messenger.entity;

import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.entity.abstracts.AbstractEntityWithId;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Логи вызовов сервисов
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class RequestLog extends AbstractEntityWithId {
    /**
     * Уникальный идентификатор сессии пользователя
     */
    @QuerySqlField(notNull = true)
    public String token;
    /**
     * Идентификатор сервиса
     */
    @QuerySqlField(notNull = true)
    public String eventId;
    /**
     * Время запуска
     */
    @QuerySqlField(notNull = true)
    public Long startInvoke;
    /**
     * Время окончания
     */
    @QuerySqlField
    public Long endInvoke;
    /**
     * Ошибка если была (stacktrace)
     */
    @QuerySqlField
    public String errorStackTrace;

//================================ AUTO GENERATE ==============================

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", " + UserSessionConst.TOKEN + "='").append(token).append('\'');
        sb.append(", eventId='").append(eventId).append('\'');
        sb.append(", startInvoke=").append(startInvoke);
        sb.append(", endInvoke=").append(endInvoke);
        sb.append(", errorStackTrace='").append(errorStackTrace).append('\'');
    }
}
