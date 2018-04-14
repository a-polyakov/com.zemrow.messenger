package com.zemrow.messenger.entity.enums;

/**
 * Части интерфейса системы для применения фильтра
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum FilterGridEnum {
    /**
     * Список контактов
     */
    CONTACTS_LIST,
    /**
     * Список последних чатов
     */
    LAST_CHAT_LIST,
    /**
     * Список заданий, поставленных мной
     */
    MY_ISSUE_LIST,
    /**
     * Список заданий, назначенных на меня
     */
    ISSUE_ON_ME_LIST,
    /**
     * Календарь на панели аналитики
     */
    ANALYTICS_CALENDAR,
    /**
     * Вкладка "Личное" на панели ситуационной обстановки
     */
    PERSONAL,
    /**
     * Вкладка "Другое" на панели ситуационной обстановки
     */
    OTHER;
}
