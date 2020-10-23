package com.zemrow.messenger.entity.enums;

/**
 * Статус контакта (Запрошен, принят, отклонен)
 *
 * @author Alexandr Polyakov on 2020.10.15
 */
public enum UserContactStatusEnum {
    /**
     * Запрос
     */
    REQUEST,
    /**
     * Запрос принят
     */
    ACCEPT,
    /**
     * Запрос отклонен
     */
    REJECTED
}
