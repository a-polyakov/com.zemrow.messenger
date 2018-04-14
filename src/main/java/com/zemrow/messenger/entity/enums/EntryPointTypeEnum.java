package com.zemrow.messenger.entity.enums;

/**
 * Способ(система) авторизации: логин_пароль, vk.com, google, ...
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum EntryPointTypeEnum {
    /**
     * Авторизация посредством ввода логина и пароля
     */
    LOGIN_PASSWORD,
    /**
     * Авторизация посредством email
     */
    EMAIL_CONFIRM,
    /**
     * Авторизация посредством телефона и ответной sms на него
     */
    PHONE_SMS;
}
