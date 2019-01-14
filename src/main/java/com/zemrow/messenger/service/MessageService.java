package com.zemrow.messenger.service;

import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import com.zemrow.messenger.service.abstracts.AbstractService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class MessageService extends AbstractService {
    /**
     * Отправить сообщение.
     *
     * @param chatId      идентификатор чата.
     * @param messageText текст сообщения.
     */
    public void insert(Long chatId, String messageText) {
        //TODO
    }

    /**
     * Получить сообщения чата отсортированые по дате создания.
     *
     * @param chatId идентификатор чата.
     * @param offset
     * @param limit
     */
    public void select(Long chatId, int offset, int limit) {
        //TODO
    }

    /**
     * Обновить статус сообщения.
     *
     * @param messageId
     * @param status
     */
    public void updateStatus(Long messageId, MessageStatusEnum status) {
        //TODO
    }

    /**
     * Отредактировать текст сообщения.
     *
     * @param messageId
     * @param messageText
     */
    public void update(long messageId, String messageText) {
        //TODO
    }

    /**
     * Удалить сообщение.
     * {@inheritDoc EventEnum#message_delete}
     *
     * @param messageId
     */
    public void delete(long messageId) {
        //TODO
    }
}
