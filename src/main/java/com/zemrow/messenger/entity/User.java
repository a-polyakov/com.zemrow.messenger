package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.Map;
import java.util.UUID;

/**
 * Пользователь
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class User extends AbstractEntity {
    /**
     * ссылка на таблицу file где хранится аватар
     */
    private UUID avatarId;
    /**
     * Наименование пользователя
     */
    @QuerySqlField(notNull = true)
    private String name;
    /**
     * Тип пользователя: физическое лицо, отдел, компания
     */
    @QuerySqlField(notNull = true)
    private UserTypeEnum userType;
    /**
     * Дополнительные поля
     */
    private Map<String, String> info;
    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    @QuerySqlField(notNull = true)
    private UUID userStatusId;

//================================ AUTO GENERATE ==============================

    public UUID getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(UUID avatarId) {
        this.avatarId = avatarId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public UUID getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(UUID userStatusId) {
        this.userStatusId = userStatusId;
    }
}

