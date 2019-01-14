package com.zemrow.messenger.constants;

/**
 * Константы
 *
 * @author Alexandr Polyakov on 2018.12.28
 */
public interface UserConst extends AbstractEntityConst {
    /**
     * Ссылка на File где хранится аватар.
     */
    public static final String AVATAR_ID = "avatarId";
    /**
     * Наименование пользователя
     */
    public static final String NAME = "name";
    /**
     * Тип пользователя: физическое лицо, отдел, компания
     */
    public static final String USER_TYPE = "userType";
    /**
     * Дополнительные поля
     * TODO разграничение доступа: какую информацию может видеть лубой человек какую из списка контактов
     */
    public static final String INFO = "info";
    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    public static final String STATUS = "status";

}
