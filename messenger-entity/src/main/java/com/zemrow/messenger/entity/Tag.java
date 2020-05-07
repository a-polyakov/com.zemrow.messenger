package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.enums.TagTypeEnum;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.TagGroupEnum;

/**
 * Класс сгенерирован автоматически, для таблицы Tag(Полный перечень тегов) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.05.07
 */
public class Tag extends AbstractEntityWithId {

    /**
     * Тег
     */
    private String tag;

    /**
     * Тип тега для связки наименование тега с логикой
     */
    private TagTypeEnum tagType;

    /**
     * Описание тега для автокомплита
     */
    private String description;

    /**
     * показывать ли в левом меню
     */
    private Boolean leftMenuShow;

    /**
     * Показывать ли в хеадере
     */
    private Boolean headerShow;

    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    private TagGroupEnum tagGroup;

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
     * Создать Полный перечень тегов
     */
    public Tag() {
    }

    /**
     * Создать Полный перечень тегов
     * @param id ID записи
     * @param tag Тег
     * @param tagType Тип тега для связки наименование тега с логикой
     * @param description Описание тега для автокомплита
     * @param leftMenuShow показывать ли в левом меню
     * @param headerShow Показывать ли в хеадере
     * @param tagGroup Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public Tag(Long id, String tag, TagTypeEnum tagType, String description, Boolean leftMenuShow, Boolean headerShow, TagGroupEnum tagGroup, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.tag = tag;
        this.tagType = tagType;
        this.description = description;
        this.leftMenuShow = leftMenuShow;
        this.headerShow = headerShow;
        this.tagGroup = tagGroup;
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
     * Получение тег
     */
    public String getTag() {
        return tag;
    }

    /**
     * Установить тег
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Получение тип тега для связки наименование тега с логикой
     */
    public TagTypeEnum getTagType() {
        return tagType;
    }

    /**
     * Установить тип тега для связки наименование тега с логикой
     */
    public void setTagType(TagTypeEnum tagType) {
        this.tagType = tagType;
    }

    /**
     * Получение описание тега для автокомплита
     */
    public String getDescription() {
        return description;
    }

    /**
     * Установить описание тега для автокомплита
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получение показывать ли в левом меню
     */
    public Boolean getLeftMenuShow() {
        return leftMenuShow;
    }

    /**
     * Установить показывать ли в левом меню
     */
    public void setLeftMenuShow(Boolean leftMenuShow) {
        this.leftMenuShow = leftMenuShow;
    }

    /**
     * Получение показывать ли в хеадере
     */
    public Boolean getHeaderShow() {
        return headerShow;
    }

    /**
     * Установить показывать ли в хеадере
     */
    public void setHeaderShow(Boolean headerShow) {
        this.headerShow = headerShow;
    }

    /**
     * Получение группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public TagGroupEnum getTagGroup() {
        return tagGroup;
    }

    /**
     * Установить группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public void setTagGroup(TagGroupEnum tagGroup) {
        this.tagGroup = tagGroup;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.Tag\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (tag != null) {
            result.append(", tag = \"").append(tag).append('"');
        }
        if (tagType != null) {
            result.append(", tagType = \"").append(tagType).append('"');
        }
        if (description != null) {
            result.append(", description = \"").append(description).append('"');
        }
        if (leftMenuShow != null) {
            result.append(", leftMenuShow = \"").append(leftMenuShow).append('"');
        }
        if (headerShow != null) {
            result.append(", headerShow = \"").append(headerShow).append('"');
        }
        if (tagGroup != null) {
            result.append(", tagGroup = \"").append(tagGroup).append('"');
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

