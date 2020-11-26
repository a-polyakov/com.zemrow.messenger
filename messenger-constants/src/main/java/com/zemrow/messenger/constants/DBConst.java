package com.zemrow.messenger.constants;

/**
 * Константы для подключения к БД
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class DBConst {
    /**
     * Имя класса драйвера
     */
    public static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    /**
     * Адрес БД по умолчанию
     */
    public static final String DEFAULT_URL = "jdbc:postgresql://localhost/messenger";
    /**
     * Логин пользователя к БД по умолчанию
     */
    public static final String DEFAULT_USER = "postgres";
    /**
     * Пароль пользователя к БД по умолчанию
     */
    public static final String DEFAULT_PASSWORD = "pgadmin";
}
