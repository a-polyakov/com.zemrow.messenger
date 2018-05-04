package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;

/**
 * Неудачные попытки войти в систему
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserSessionFail extends AbstractEntityCreateOnly {
    /**
     * Точка входа пользователя
     */
    public Long userEntryPointId;
    /**
     * IP адрес клиента
     */
    public String ipAddress;
    /**
     * Сообщение об ошибке
     */
    public String comment;

//================================ AUTO GENERATE ==============================

    public Long getUserEntryPointId() {
        return userEntryPointId;
    }

    public void setUserEntryPointId(Long userEntryPointId) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSessionFail{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", userEntryPointId='").append(userEntryPointId).append('\'');
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", comment='").append(comment).append('\'');
    }
}
