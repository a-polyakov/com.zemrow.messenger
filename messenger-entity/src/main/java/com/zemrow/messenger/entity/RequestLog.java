package com.zemrow.messenger.entity;

/**
 * Класс сгенерирован автоматически, для таблицы RequestLog(Логи вызовов сервисов) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class RequestLog extends AbstractEntityWithId {

    /**
     * Уникальный идентификатор сессии пользователя
     */
    private String token;

    /**
     * Идентификатор события
     */
    private String eventId;

    /**
     * Время запуска
     */
    private Long startInvoke;

    /**
     * Время окончания
     */
    private Long endInvoke;

    /**
     * Ошибка. Если была - stacktrace.
     */
    private String errorStackTrace;

    /**
     * Создать Логи вызовов сервисов
     */
    public RequestLog() {
    }

    /**
     * Создать Логи вызовов сервисов
     * @param id ID записи
     * @param token Уникальный идентификатор сессии пользователя
     * @param eventId Идентификатор события
     * @param startInvoke Время запуска
     * @param endInvoke Время окончания
     * @param errorStackTrace Ошибка. Если была - stacktrace.
     */
    public RequestLog(Long id, String token, String eventId, Long startInvoke, Long endInvoke, String errorStackTrace) {
        this.id = id;
        this.token = token;
        this.eventId = eventId;
        this.startInvoke = startInvoke;
        this.endInvoke = endInvoke;
        this.errorStackTrace = errorStackTrace;
    }

    /**
     * Получение уникальный идентификатор сессии пользователя
     */
    public String getToken() {
        return token;
    }

    /**
     * Установить уникальный идентификатор сессии пользователя
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Получение идентификатор события
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * Установить идентификатор события
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * Получение время запуска
     */
    public Long getStartInvoke() {
        return startInvoke;
    }

    /**
     * Установить время запуска
     */
    public void setStartInvoke(Long startInvoke) {
        this.startInvoke = startInvoke;
    }

    /**
     * Получение время окончания
     */
    public Long getEndInvoke() {
        return endInvoke;
    }

    /**
     * Установить время окончания
     */
    public void setEndInvoke(Long endInvoke) {
        this.endInvoke = endInvoke;
    }

    /**
     * Получение ошибка. если была - stacktrace.
     */
    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    /**
     * Установить ошибка. если была - stacktrace.
     */
    public void setErrorStackTrace(String errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.RequestLog\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (token != null) {
            result.append(", token = \"").append(token).append('"');
        }
        if (eventId != null) {
            result.append(", eventId = \"").append(eventId).append('"');
        }
        if (startInvoke != null) {
            result.append(", startInvoke = \"").append(startInvoke).append('"');
        }
        if (endInvoke != null) {
            result.append(", endInvoke = \"").append(endInvoke).append('"');
        }
        if (errorStackTrace != null) {
            result.append(", errorStackTrace = \"").append(errorStackTrace).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

