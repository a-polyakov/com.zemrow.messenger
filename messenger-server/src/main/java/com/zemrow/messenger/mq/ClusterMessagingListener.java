package com.zemrow.messenger.mq;


import com.zemrow.messenger.enums.ResponseScopeEnum;

/**
 * Слушатель сообщений передаваемых между узлами кластера.
 *
 * @author Alexandr Polyakov on 2019.01.16
 */
public interface ClusterMessagingListener {
    /**
     * Принять сообщение
     *
     * @param scope         Уровень рассылки ответа.
     * @param scopeObjectId Идентификатор объекта к которому привязан ответ (идентификатор пользователя || идентификатор чата).
     * @param json          Сообщение.
     */
    public void onMessage(ResponseScopeEnum scope, Long scopeObjectId, String json) throws Exception;
}
