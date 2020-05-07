package com.zemrow.messenger.entity;

/**
 * Запись БД c идентификатором "id"
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public abstract class AbstractEntityWithId extends AbstractEntity {
    /**
     * ID записи
     */
    protected Long id;

    /**
     * Получение id записи
     */
    public Long getId() {
        return id;
    }

    /**
     * Установить id записи
     */
    public void setId(Long id) {
        this.id = id;
    }
}
