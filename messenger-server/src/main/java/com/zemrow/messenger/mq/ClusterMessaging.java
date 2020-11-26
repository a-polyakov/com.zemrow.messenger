package com.zemrow.messenger.mq;

import com.zemrow.messenger.enums.ResponseScopeEnum;

import java.io.Closeable;
import java.io.IOException;

/**
 * Отправка и получение сообщений между узлами кластера.
 *
 * @author Alexandr Polyakov on 2019.01.16
 */
public class ClusterMessaging implements Closeable {

    //private static final String TOPIC_NAME = "MESSAGE_TO_SCOPE";

    public ClusterMessaging() {
    }

    /**
     * Отправить сообщение в остальные узлы кластера, для трансляции на клиентов подключенных к ним.
     *
     * @param scope         Уровень рассылки ответа.
     * @param scopeObjectId Идентификатор объекта к которому привязан ответ (идентификатор пользователя || идентификатор чата).
     * @param json          Сообщение.
     */
    public void publish(ResponseScopeEnum scope, long scopeObjectId, String json) {
        final ClusterMessagingDto dto = new ClusterMessagingDto();
        dto.setScope(scope);
        dto.setScopeObjectId(scopeObjectId);
        dto.setJson(json);
        //TODO send(TOPIC_NAME, dto);
    }

    /**
     * Подписаться на получение сообщений.
     *
     * @param listener Слушатель.
     */
    public void subscribe(ClusterMessagingListener listener) {
        // TODO
    }

    @Override
    public void close() throws IOException {
        // TODO
    }
}
