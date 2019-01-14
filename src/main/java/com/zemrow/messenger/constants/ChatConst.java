package com.zemrow.messenger.constants;

/**
 * Константы
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public interface ChatConst extends AbstractEntityConst {
    /**
     * Наименование чата
     */
    public static final String LABEL = "label";
    /**
     * Тип чата: чат, задание
     */
    public static final String CHAT_TYPE = "chatType";
    /**
     * Использованый нумиратор (для определения префикса)
     */
    public static final String NUMBERING_ID = "numberingId";
    /**
     * Номер чата(документа)
     */
    public static final String ORDER_NUMBER = "orderNumber";
}
