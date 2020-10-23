package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.UserLinkTypeEnum;

/**
 * Класс сгенерирован автоматически, для таблицы UserLink(Организационная структура пользователей) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserLink extends AbstractEntityWithId {

    /**
     * ID пользователя родителя
     */
    private Long parentUserId;

    /**
     * ID пользователя потомка
     */
    private Long childUserId;

    /**
     * Тип связи (подчинение, замена)
     */
    private UserLinkTypeEnum userLinkType;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Дата удаления записи
     */
    private Long deleteTime;

    /**
     * Пользователь удаливший запись
     */
    private Long deletedBy;

    /**
     * Создать Организационная структура пользователей
     */
    public UserLink() {
    }

    /**
     * Создать Организационная структура пользователей
     * @param id ID записи
     * @param parentUserId ID пользователя родителя
     * @param childUserId ID пользователя потомка
     * @param userLinkType Тип связи (подчинение, замена)
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public UserLink(Long id, Long parentUserId, Long childUserId, UserLinkTypeEnum userLinkType, Long createTime, Long createdBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.parentUserId = parentUserId;
        this.childUserId = childUserId;
        this.userLinkType = userLinkType;
        this.createTime = createTime;
        this.createdBy = createdBy;
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
     * Получение id пользователя родителя
     */
    public Long getParentUserId() {
        return parentUserId;
    }

    /**
     * Установить id пользователя родителя
     */
    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    /**
     * Получение id пользователя потомка
     */
    public Long getChildUserId() {
        return childUserId;
    }

    /**
     * Установить id пользователя потомка
     */
    public void setChildUserId(Long childUserId) {
        this.childUserId = childUserId;
    }

    /**
     * Получение тип связи (подчинение, замена)
     */
    public UserLinkTypeEnum getUserLinkType() {
        return userLinkType;
    }

    /**
     * Установить тип связи (подчинение, замена)
     */
    public void setUserLinkType(UserLinkTypeEnum userLinkType) {
        this.userLinkType = userLinkType;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserLink\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (parentUserId != null) {
            result.append(", parentUserId = \"").append(parentUserId).append('"');
        }
        if (childUserId != null) {
            result.append(", childUserId = \"").append(childUserId).append('"');
        }
        if (userLinkType != null) {
            result.append(", userLinkType = \"").append(userLinkType).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
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

