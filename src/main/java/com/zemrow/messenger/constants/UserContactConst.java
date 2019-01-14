package com.zemrow.messenger.constants;

/**
 * Константы
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public interface UserContactConst extends AbstractEntityConst {
    /**
     * ID пользователя родителя
     */
    public static final String PARENT_USER_ID = "parentUserId";
    /**
     * ID пользователя потомка
     */
    public static final String CHILD_USER_ID = "childUserId";
    /**
     * Прошел ли подтверждение запрос на добавление
     * TODO Добавить логику черного списка
     */
    public static final String VALIDATE = "validate";
    /**
     * Наименование контакта
     */
    public static final String LABEL = "label";
    /**
     * ID чата
     */
    public static final String CHAT_ID = "chatId";
}
