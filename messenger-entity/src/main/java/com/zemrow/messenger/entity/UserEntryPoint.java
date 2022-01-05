package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;

/**
 * Класс сгенерирован автоматически, для таблицы UserEntryPoint(Способы авторизации пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserEntryPoint extends AbstractEntityWithId {

    /**
     * ID пользователя
     */
    private Long userId;

    /**
     * Прошел ли подтверждение
     */
    private Boolean validate;

    /**
     * Способ авторизации. Например: логин_пароль, vk.com, google, ...
     */
    private EntryPointTypeEnum entryPointType;

    /**
     * Идентификатор в системе авторизации (логин)
     */
    private String clientId;

    /**
     * Удостоверение личности в системе авторизации (пароль)
     */
    private String credential;

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
     * Создать Способы авторизации пользователя
     */
    public UserEntryPoint() {
    }

    /**
     * Создать Способы авторизации пользователя
     * @param id ID записи
     * @param userId ID пользователя
     * @param validate Прошел ли подтверждение
     * @param entryPointType Способ авторизации. Например: логин_пароль, vk.com, google, ...
     * @param clientId Идентификатор в системе авторизации (логин)
     * @param credential Удостоверение личности в системе авторизации (пароль)
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public UserEntryPoint(Long id, Long userId, Boolean validate, EntryPointTypeEnum entryPointType, String clientId, String credential, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.userId = userId;
        this.validate = validate;
        this.entryPointType = entryPointType;
        this.clientId = clientId;
        this.credential = credential;
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
     * Получение id пользователя
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Установить id пользователя
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Получение прошел ли подтверждение
     */
    public Boolean getValidate() {
        return validate;
    }

    /**
     * Установить прошел ли подтверждение
     */
    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    /**
     * Получение способ авторизации. например: логин_пароль, vk.com, google, ...
     */
    public EntryPointTypeEnum getEntryPointType() {
        return entryPointType;
    }

    /**
     * Установить способ авторизации. например: логин_пароль, vk.com, google, ...
     */
    public void setEntryPointType(EntryPointTypeEnum entryPointType) {
        this.entryPointType = entryPointType;
    }

    /**
     * Получение идентификатор в системе авторизации (логин)
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Установить идентификатор в системе авторизации (логин)
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Получение удостоверение личности в системе авторизации (пароль)
     */
    public String getCredential() {
        return credential;
    }

    /**
     * Установить удостоверение личности в системе авторизации (пароль)
     */
    public void setCredential(String credential) {
        this.credential = credential;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserEntryPoint\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (userId != null) {
            result.append(", userId = \"").append(userId).append('"');
        }
        if (validate != null) {
            result.append(", validate = \"").append(validate).append('"');
        }
        if (entryPointType != null) {
            result.append(", entryPointType = \"").append(entryPointType).append('"');
        }
        if (clientId != null) {
            result.append(", clientId = \"").append(clientId).append('"');
        }
        if (credential != null) {
            result.append(", credential = \"").append(credential).append('"');
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

