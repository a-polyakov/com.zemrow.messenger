package com.zemrow.messenger.mq;

import com.zemrow.messenger.enums.ResponseScopeEnum;

/**
 * Сообщение для передачи между узлами кластера.
 *
 * @author Alexandr Polyakov on 2019.01.16
 */
public class ClusterMessagingDto {
    /**
     * Уровень рассылки ответа.
     */
    private ResponseScopeEnum scope;
    /**
     * Идентификатор объекта к которому привязан ответ (идентификатор пользователя || идентификатор чата).
     */
    private long scopeObjectId;
    /**
     * Сообщение.
     */
    private String json;

//================================ AUTO GENERATE ==============================

    public ResponseScopeEnum getScope() {
        return scope;
    }

    public void setScope(ResponseScopeEnum scope) {
        this.scope = scope;
    }

    public long getScopeObjectId() {
        return scopeObjectId;
    }

    public void setScopeObjectId(long scopeObjectId) {
        this.scopeObjectId = scopeObjectId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
