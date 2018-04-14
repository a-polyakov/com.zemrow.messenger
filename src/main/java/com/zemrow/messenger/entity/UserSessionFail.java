package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;

import java.util.UUID;

/**
 * Неудачные попытки войти в систему
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserSessionFail extends AbstractEntityCreateOnly {
    /**
     * Точка входа пользователя
     */
    public UUID userEntryPointId;
    /**
     * IP адрес клиента
     */
    public String ipAddress;
    /**
     * Сообщение об ошибке
     */
    public String comment;

//================================ AUTO GENERATE ==============================

    public UUID getUserEntryPointId() {
        return userEntryPointId;
    }

    public void setUserEntryPointId(UUID userEntryPointId) {
        this.userEntryPointId = userEntryPointId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
