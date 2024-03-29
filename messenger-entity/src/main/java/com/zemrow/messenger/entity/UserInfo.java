package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.UserStatusEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;

/**
 * Класс сгенерирован автоматически, для таблицы UserInfo(Пользователь) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserInfo extends AbstractEntityWithId {

    /**
     * Наименование пользователя
     */
    private String name;

    /**
     * Тип пользователя. Например: физическое лицо, отдел, компания
     */
    private UserTypeEnum userType;

    /**
     * Ссылка на таблицу file где хранится аватар
     */
    private Long avatarId;

    /**
     * Json с дополнительными полями
     */
    private String publicInfo;

    /**
     * Состояние пользователя. Не в сети, В сети
     */
    private UserStatusEnum userStatus;

    /**
     * Статус который указал пользователь
     */
    private String userStatusLabel;

    /**
     * Язык
     */
    private java.util.Locale locale;

    /**
     * Часовой пояс
     */
    private java.time.ZoneId timeZone;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Дата обновления записи
     */
    private Long updateTime;

    /**
     * Пользователь обновивший запись
     */
    private Long updatedBy;

    /**
     * Дата удаления записи
     */
    private Long deleteTime;

    /**
     * Пользователь удаливший запись
     */
    private Long deletedBy;

    /**
     * Создать Пользователь
     */
    public UserInfo() {
    }

    /**
     * Создать Пользователь
     * @param id ID записи
     * @param name Наименование пользователя
     * @param userType Тип пользователя. Например: физическое лицо, отдел, компания
     * @param avatarId Ссылка на таблицу file где хранится аватар
     * @param publicInfo Json с дополнительными полями
     * @param userStatus Состояние пользователя. Не в сети, В сети
     * @param userStatusLabel Статус который указал пользователь
     * @param locale Язык
     * @param timeZone Часовой пояс
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public UserInfo(Long id, String name, UserTypeEnum userType, Long avatarId, String publicInfo, UserStatusEnum userStatus, String userStatusLabel, java.util.Locale locale, java.time.ZoneId timeZone, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.avatarId = avatarId;
        this.publicInfo = publicInfo;
        this.userStatus = userStatus;
        this.userStatusLabel = userStatusLabel;
        this.locale = locale;
        this.timeZone = timeZone;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.updateTime = updateTime;
        this.updatedBy = updatedBy;
        this.deleteTime = deleteTime;
        this.deletedBy = deletedBy;
    }

    @Override
    public void preInsert(SessionStorage session) {
        if (createTime == null) {
            createTime = System.currentTimeMillis();
        }
        if (createdBy == null) {
            createdBy = session.getUserId();
        }
        updateTime = System.currentTimeMillis();
        updatedBy = session.getUserId();
    }

    @Override
    public void preUpdate(SessionStorage session) {
        updateTime = System.currentTimeMillis();
        updatedBy = session.getUserId();
    }

    @Override
    public void preDelete(SessionStorage session) {
        if (deleteTime == null) {
            deleteTime = System.currentTimeMillis();
        }
        if (deletedBy == null) {
            deletedBy = session.getUserId();
        }
    }

    /**
     * Получение наименование пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Установить наименование пользователя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получение тип пользователя. например: физическое лицо, отдел, компания
     */
    public UserTypeEnum getUserType() {
        return userType;
    }

    /**
     * Установить тип пользователя. например: физическое лицо, отдел, компания
     */
    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    /**
     * Получение ссылка на таблицу file где хранится аватар
     */
    public Long getAvatarId() {
        return avatarId;
    }

    /**
     * Установить ссылка на таблицу file где хранится аватар
     */
    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    /**
     * Получение json с дополнительными полями
     */
    public String getPublicInfo() {
        return publicInfo;
    }

    /**
     * Установить json с дополнительными полями
     */
    public void setPublicInfo(String publicInfo) {
        this.publicInfo = publicInfo;
    }

    /**
     * Получение состояние пользователя. не в сети, в сети
     */
    public UserStatusEnum getUserStatus() {
        return userStatus;
    }

    /**
     * Установить состояние пользователя. не в сети, в сети
     */
    public void setUserStatus(UserStatusEnum userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * Получение статус который указал пользователь
     */
    public String getUserStatusLabel() {
        return userStatusLabel;
    }

    /**
     * Установить статус который указал пользователь
     */
    public void setUserStatusLabel(String userStatusLabel) {
        this.userStatusLabel = userStatusLabel;
    }

    /**
     * Получение язык
     */
    public java.util.Locale getLocale() {
        return locale;
    }

    /**
     * Установить язык
     */
    public void setLocale(java.util.Locale locale) {
        this.locale = locale;
    }

    /**
     * Получение часовой пояс
     */
    public java.time.ZoneId getTimeZone() {
        return timeZone;
    }

    /**
     * Установить часовой пояс
     */
    public void setTimeZone(java.time.ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Получение дата создания записи
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * Установить дата создания записи
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * Получение пользователь создавший запись
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * Установить пользователь создавший запись
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Получение дата обновления записи
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * Установить дата обновления записи
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Получение пользователь обновивший запись
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Установить пользователь обновивший запись
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Получение дата удаления записи
     */
    public Long getDeleteTime() {
        return deleteTime;
    }

    /**
     * Установить дата удаления записи
     */
    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * Получение пользователь удаливший запись
     */
    public Long getDeletedBy() {
        return deletedBy;
    }

    /**
     * Установить пользователь удаливший запись
     */
    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserInfo\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (name != null) {
            result.append(", name = \"").append(name).append('"');
        }
        if (userType != null) {
            result.append(", userType = \"").append(userType).append('"');
        }
        if (avatarId != null) {
            result.append(", avatarId = \"").append(avatarId).append('"');
        }
        if (publicInfo != null) {
            result.append(", publicInfo = \"").append(publicInfo).append('"');
        }
        if (userStatus != null) {
            result.append(", userStatus = \"").append(userStatus).append('"');
        }
        if (userStatusLabel != null) {
            result.append(", userStatusLabel = \"").append(userStatusLabel).append('"');
        }
        if (locale != null) {
            result.append(", locale = \"").append(locale).append('"');
        }
        if (timeZone != null) {
            result.append(", timeZone = \"").append(timeZone).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
        }
        if (updateTime != null) {
            result.append(", updateTime = \"").append(updateTime).append('"');
        }
        if (updatedBy != null) {
            result.append(", updatedBy = \"").append(updatedBy).append('"');
        }
        if (deleteTime != null) {
            result.append(", deleteTime = \"").append(deleteTime).append('"');
        }
        if (deletedBy != null) {
            result.append(", deletedBy = \"").append(deletedBy).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

