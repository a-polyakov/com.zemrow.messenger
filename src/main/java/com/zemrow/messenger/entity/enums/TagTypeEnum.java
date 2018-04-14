package com.zemrow.messenger.entity.enums;

/**
 * Тип тега для связки произвольного тега с логикой
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum TagTypeEnum {
    /**
     * Простой текстовый тег
     */
    SIMPLE,
    /**
     * Создать задание
     */
    CREATE_ISSUE,
    /**
     * Установить исполнителя
     */
    EXECUTOR,
    /**
     * Установить срок выполнения
     */
    DEADLINE,
    /**
     * Добавить контакт к чату
     */
    ADD_CONTACT_TO_CHAT,
    /**
     * Добавить контакт к чату с показом истории сообщений
     */
    ADD_CONTACT_TO_CHAT_WITH_HISTORY,
    /**
     * Удалить контакт из чата
     */
    DELETE_CONTACT_FROM_CHAT,
    /**
     * Удалить контакт из чата и скрыть историю сообщений
     */
    DELETE_CONTACT_FROM_CHAT_WITH_HISTORY,
    /**
     * Покинуть чат
     */
    LEAVE_CHAT,
    /**
     * Приоритет
     */
    PRIORITY,
    /**
     * Приступить к работе
     */
    START,
    /**
     * Завершить работу
     */
    STOP,
    /**
     * Новое название задания
     */
    NAME,
    /**
     * Приостановить работу
     */
    PAUSE,
    /**
     * приватный_чат
     */
    PRIVATE_CHAT,
    /**
     * Оценка затрат времени на выполнение задания
     */
    ESTIMATE,
    /**
     * приватная переписка
     */
    PRIVATE_CHAT_MESSAGE_LIST,
    /**
     * Тип статусного тега по-умолчанию (без логики). При необходимости логики на статусном теге создается отдельный тип.
     */
    STATUS_DEFAULT_TYPE,
    /**
     * Описание задачи
     */
    DESCRIPTION,
    /**
     * статус-новый
     */
    STATUS_NEW,
    /**
     * Звонок
     */
    PHONE_CALL;
}
