package com.zemrow.messenger.entity.enums;

/**
 * Тип группы тега
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum TagGroupEnum {
    /**
     * сделать переписку чата приватной или по общим правилам
     */
    CHAT_MESSAGES_PRIVACY,
    /**
     * сделать чат приватным или по общим правилам
     */
    CHAT_PRIVACY,
    /**
     * Полное описание задачи
     */
    DESCRIPTION,
    /**
     * Крайний срок выполнения
     */
    DEADLINE,
    /**
     * Оценка затрат времени на выполнение задания
     */
    ESTIMATE,
    /**
     * исполнитель
     */
    EXECUTOR,
    /**
     * Установить приоритет
     */
    PRIORITY,
    /**
     * Состояние задания
     */
    STATUS,
    /**
     * Создать задание
     */
    WORK_LOG,
    /**
     * место собрания
     */
    MEETING_PLACE,
    /**
     * идеальный конечный результат
     */
    BEST_RESULT;
}

