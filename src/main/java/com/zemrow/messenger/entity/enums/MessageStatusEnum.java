package com.zemrow.messenger.entity.enums;

/**
 * Сотояние сообщения
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum MessageStatusEnum {
    /**
     * Сообщение не отправлено (актуально для мобильного ПО)
     */
    NOT_SEND,
    /**
     * Сообщение отправлено на сервер
     */
    SEND,
    /**
     * Сервер нашел активное соединение с получателем и передал сообщение ему
     */
    DELIVERED,
    /**
     * Получатель просмотрел сообщение
     */
    READ;
}
