package com.zemrow.messenger.entity.enums;

/**
 * Тип пользователя: физическое лицо, отдел, компания
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum UserTypeEnum {
    /**
     * Администратор системы
     */
    ADMIN,
    /**
     * Обычный пользователь (физическое лицо)
     */
    USER,
    /**
     * Отдел (группа пользователей)
     */
    DEPARTMENT,
    /**
     * Компания (юридическое лицо)
     */
    COMPANY,
    /**
     * Призрак (человек пробовал зарегатся, но не закончил)
     */
    GHOST
}
