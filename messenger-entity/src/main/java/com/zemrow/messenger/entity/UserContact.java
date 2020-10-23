package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.UserContactStatusEnum;

/**
 * Класс сгенерирован автоматически, для таблицы UserContact(Контакты пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserContact extends AbstractEntityWithId {

    /**
     * ID пользователя родителя
     */
    private Long parentUserId;

    /**
     * ID пользователя потомка
     */
    private Long childUserId;

    /**
     * Статус контакта (Запрошен, принят, отклонен)
     */
    private UserContactStatusEnum userContactStatus;

    /**
     * Наименование контакта
     */
    private String label;

    /**
     * ID чата
     */
    private Long chatId;

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
     * Создать Контакты пользователя
     */
    public UserContact() {
    }

    /**
     * Создать Контакты пользователя
     * @param id ID записи
     * @param parentUserId ID пользователя родителя
     * @param childUserId ID пользователя потомка
     * @param userContactStatus Статус контакта (Запрошен, принят, отклонен)
     * @param label Наименование контакта
     * @param chatId ID чата
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public UserContact(Long id, Long parentUserId, Long childUserId, UserContactStatusEnum userContactStatus, String label, Long chatId, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.parentUserId = parentUserId;
        this.childUserId = childUserId;
        this.userContactStatus = userContactStatus;
        this.label = label;
        this.chatId = chatId;
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
     * Получение статус контакта (запрошен, принят, отклонен)
     */
    public UserContactStatusEnum getUserContactStatus() {
        return userContactStatus;
    }

    /**
     * Установить статус контакта (запрошен, принят, отклонен)
     */
    public void setUserContactStatus(UserContactStatusEnum userContactStatus) {
        this.userContactStatus = userContactStatus;
    }

    /**
     * Получение наименование контакта
     */
    public String getLabel() {
        return label;
    }

    /**
     * Установить наименование контакта
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Получение id чата
     */
    public Long getChatId() {
        return chatId;
    }

    /**
     * Установить id чата
     */
    public void setChatId(Long chatId) {
        this.chatId = chatId;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserContact\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (parentUserId != null) {
            result.append(", parentUserId = \"").append(parentUserId).append('"');
        }
        if (childUserId != null) {
            result.append(", childUserId = \"").append(childUserId).append('"');
        }
        if (userContactStatus != null) {
            result.append(", userContactStatus = \"").append(userContactStatus).append('"');
        }
        if (label != null) {
            result.append(", label = \"").append(label).append('"');
        }
        if (chatId != null) {
            result.append(", chatId = \"").append(chatId).append('"');
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

