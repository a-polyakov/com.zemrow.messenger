package com.zemrow.messenger.entity.enums;

/**
 * Тип связи (содержит, подчинение, другие в голову не приходят)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public enum UserLinkEnum {
    /**
     * Содержит (Например отдел состоит из Иванов, Сидоров, ...)
     */
    CONTAINS,
    /**
     * Подчинение (Например Иванов подчиняется Сидорову)
     */
    SUBORDINATION,
    /**
     * Начальник (Например: начальник отдела, глава компании)
     */
    HEAD,
    /**
     * Секретарь - сотрудник принимающий обращения в компанию/отдел
     */
    SECRETARY,
    /**
     * Администратор компании (с правом приглашения и редактирования списков сотрудников компании)
     */
    COMPANY_ADMIN;
}
