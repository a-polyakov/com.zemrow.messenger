package com.zemrow.messenger.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import com.zemrow.messenger.service.MessageService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class MessageController extends AbstractController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    /**
     * Отправить сообщение.
     */
    public void insert(SessionStorage session, ObjectNode json) {
        long chatId = json.get(ATTR_CHAT_ID).asLong();
        String messageText = json.get("messageText").asText();
        service.insert(chatId, messageText);
    }

    /**
     * Получить сообщения чата отсортированые по дате создания.
     */
    public void select(SessionStorage session, ObjectNode json) {
        long chatId = json.get(ATTR_CHAT_ID).asLong();
        int offset = json.get(ATTR_OFFSET).asInt();
        int limit = json.get(ATTR_LIMIT).asInt();
        service.select(chatId, offset, limit);
    }

    /**
     * Обновить статус сообщения.
     */
    public void updateStatus(SessionStorage session, ObjectNode json) {
        long messageId = json.get(ATTR_MESSAGE_ID).asLong();
        MessageStatusEnum status = MessageStatusEnum.valueOf(json.get("status").asText());
        service.updateStatus(messageId, status);
    }

    /**
     * Отредактировать текст сообщения.
     */
    public void update(SessionStorage session, ObjectNode json) {
        long messageId = json.get(ATTR_MESSAGE_ID).asLong();
        String messageText = json.get("messageText").asText();
        service.update(messageId, messageText);
    }

    /**
     * Удалить сообщение.
     * {@inheritDoc EventEnum#message_delete}
     */
    public void delete(SessionStorage session, ObjectNode json) {
        long messageId = json.get(ATTR_MESSAGE_ID).asLong();
        service.delete(messageId);
    }
}
