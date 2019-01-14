package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithId;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Неудачные попытки войти в систему
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserSessionFail extends AbstractEntityWithId {
    /**
     * Точка входа пользователя
     */
    @QuerySqlField(notNull = true)
    public Long userEntryPointId;
    /**
     * IP адрес клиента
     */
    @QuerySqlField(notNull = true)
    public String ipAddress;
    /**
     * Сообщение об ошибке
     */
    @QuerySqlField(notNull = true)
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
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", userEntryPointId='").append(userEntryPointId).append('\'');
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", comment='").append(comment).append('\'');
    }
}
