package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.lang.IgniteUuid;

import java.util.Map;

/**
 * Пользователь
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class User extends AbstractEntity {
    /**
     * ссылка на таблицу file где хранится аватар
     */
    private IgniteUuid avatarId;
    /**
     * Наименование пользователя
     */
    @QuerySqlField(notNull = true, index = true)
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
    private IgniteUuid userStatusId;
    /**
     * Локаль с которой работает пользователя
     */
    //TODO private Locale locale;

    /**
     * Временная зона пользователя
     */
    //TODO private TimeZone timeZone;

//================================ AUTO GENERATE ==============================
    public IgniteUuid getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(IgniteUuid avatarId) {
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

    public IgniteUuid getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(IgniteUuid userStatusId) {
        this.userStatusId = userStatusId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", avatarId='").append(avatarId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", userType='").append(userType).append('\'');
        sb.append(", info=").append(info);
        sb.append(", userStatusId='").append(userStatusId).append('\'');
    }
}

