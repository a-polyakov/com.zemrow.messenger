package com.zemrow.messenger.controller;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
//TODO
public class MessageController {
}
/*
extends AbstractController<MessageService> {

    public MessageController(MessageService service) {
        super(service);
    }

    */
/**
 * Отправить сообщение.
 * <p>
 * Получить сообщения чата отсортированные по дате создания.
 * <p>
 * Обновить статус сообщения.
 * <p>
 * Отредактировать текст сообщения.
 * <p>
 * Удалить сообщение.
 * {@inheritDoc EventEnum#message_delete}
 * <p>
 * Получить сообщения чата отсортированные по дате создания.
 * <p>
 * Обновить статус сообщения.
 * <p>
 * Отредактировать текст сообщения.
 * <p>
 * Удалить сообщение.
 * {@inheritDoc EventEnum#message_delete}
 *//*

    public void insert(SessionStorage session, Map json) {
        long chatId = json.get(ATTR_CHAT_ID).asLong();
        String messageText = json.get("messageText").asText();
        service.insert(chatId, messageText);
    }

    */
/**
 * Получить сообщения чата отсортированные по дате создания.
 *//*

    public void select(SessionStorage session, Map json) {
        long chatId = json.get(ATTR_CHAT_ID).asLong();
        int offset = json.get(ATTR_OFFSET).asInt();
        int limit = json.get(ATTR_LIMIT).asInt();
        service.select(chatId, offset, limit);
    }

    */
/**
 * Обновить статус сообщения.
 *//*

    public void updateStatus(SessionStorage session, Map json) {
        long messageId = json.get(ATTR_MESSAGE_ID).asLong();
        MessageStatusEnum status = MessageStatusEnum.valueOf(json.get("status").asText());
        service.updateStatus(messageId, status);
    }

    */
/**
 * Отредактировать текст сообщения.
 *//*

    public void update(SessionStorage session, Map json) {
        long messageId = json.get(ATTR_MESSAGE_ID).asLong();
        String messageText = json.get("messageText").asText();
        service.update(messageId, messageText);
    }

    */
/**
 * Удалить сообщение.
 * {@inheritDoc EventEnum#message_delete}
 *//*

    public void delete(SessionStorage session, Map json) {
        long messageId = json.get(ATTR_MESSAGE_ID).asLong();
        service.delete(messageId);
    }
}
*/
