package com.zemrow.messenger.constants;

/**
 * Константы
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public interface MessageTagConst extends AbstractEntityConst {
    /**
     * ID сообщения
     */
    public static final String MESSAGE_ID = "messageId";
    /**
     * ID тега
     */
    public static final String TAG_ID = "tagId";
    /**
     * Скрытое значение тега (ID чата, дата в ms, ID пользователя в зависимости от типа тега)
     */
    public static final String VALUE = "value";
}
