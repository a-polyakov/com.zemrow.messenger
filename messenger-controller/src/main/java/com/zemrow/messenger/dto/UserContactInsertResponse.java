package com.zemrow.messenger.dto;

/**
 * Добавление контакта пользователю
 *
 * @author Alexandr Polyakov on 2020.12.28
 */
public class UserContactInsertResponse extends AbstractScopeDto {

    /**
     * ID пользователя родителя
     */
    private Long parentUserId;

    /**
     * ID пользователя потомка
     */
    private Long childUserId;

//================================ AUTO GENERATE ==============================

    public Long getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    public Long getChildUserId() {
        return childUserId;
    }

    public void setChildUserId(Long childUserId) {
        this.childUserId = childUserId;
    }
}
