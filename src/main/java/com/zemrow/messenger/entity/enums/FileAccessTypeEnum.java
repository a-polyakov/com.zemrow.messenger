package com.zemrow.messenger.entity.enums;

/**
 * Тип доступов к файлу
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum FileAccessTypeEnum {
    /**
     * Доступ разрешен всем
     */
    PUBLIC,
    /**
     * Доступ разрешен только при наличии доступа к сообщению, в котором был отправлен файл
     */
    MESSAGE;
}
