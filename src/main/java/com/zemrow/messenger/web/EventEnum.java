package com.zemrow.messenger.web;

/**
 * Список сообщений поддерживаемых системой
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public enum EventEnum {
    /**
     * Вход в сисему.
     */
    userSession_insert,
    /**
     * Выход из системы (только текущую сессию).
     */
    userSession_delete,

    /**
     * Регистрация пользователя.
     */
    user_insert,
    /**
     * Получить информацию о текущем пользователе.
     */
    user_current,
    /**
     * Получить информацию о пользователе.
     */
    user_select,
    /**
     * Сменить статус пользователя.
     */
    user_updateStatus,
    /**
     * Наити пользователей.
     */
    user_find,

    /**
     * Текущему пользователю добавить контак на указанного пользователя
     */
    userContact_insert,
    /**
     * Список контактов пользователя отсортированных по алфавиту.
     */
    userContact_select,

    /**
     * Получить список чатов пользователя отсортированых по последнему сообщению.
     */
    chat_listLast,
    /**
     * Получить информацию о чате.
     */
    chat_selectById,

    /**
     * Отправить сообщение.
     */
    message_insert,
    /**
     * Получить сообщения чата отсортированые по дате создания.
     */
    message_select,
    /**
     * Обновить статус сообщения.
     */
    message_updateStatus,
    /**
     * Отредактировать текст сообщения.
     */
    message_update,
    /**
     * Удалить сообщение.
     */
    message_delete,

    /**
     * Получить список доступных тегов.
     */
    tag_select,

    /**
     * Получить список доступных статусов.
     */
    userStatus_select
}
