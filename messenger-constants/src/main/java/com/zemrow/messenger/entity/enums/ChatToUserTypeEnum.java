package com.zemrow.messenger.entity.enums;

/**
 * Типа участника чата: обычный, скрытый только для чтения, скрытый полный доступ
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum ChatToUserTypeEnum {
    /**
     * обычный
     */
    DEFAULT,
    /**
     * скрытый только для чтения
     */
    HIDDEN_READ_ONLY,
    /**
     * скрытый полный доступ
     */
    HIDDEN_FULL_ACCESS
}
