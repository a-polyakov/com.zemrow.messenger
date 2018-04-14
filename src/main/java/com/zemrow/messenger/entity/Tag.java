package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import com.zemrow.messenger.entity.enums.TagTypeEnum;

/**
 * Полный перечень тегов
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Tag extends AbstractEntity {
    /**
     * Тег
     */
    public String tag;
    /**
     * Тип тега для связки наименование тега с логикой
     */
    public TagTypeEnum tagType;
    /**
     * Описание тега для автокомплита
     */
    public String description;
    /**
     * показывать ли в левом меню
     */
    public Boolean leftMenuShow;
    /**
     * Показывать ли в хеадере
     */
    public Boolean headerShow;
    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public TagGroupEnum tagGroup;

//================================ AUTO GENERATE ==============================

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TagTypeEnum getTagType() {
        return tagType;
    }

    public void setTagType(TagTypeEnum tagType) {
        this.tagType = tagType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getLeftMenuShow() {
        return leftMenuShow;
    }

    public void setLeftMenuShow(Boolean leftMenuShow) {
        this.leftMenuShow = leftMenuShow;
    }

    public Boolean getHeaderShow() {
        return headerShow;
    }

    public void setHeaderShow(Boolean headerShow) {
        this.headerShow = headerShow;
    }

    public TagGroupEnum getTagGroup() {
        return tagGroup;
    }

    public void setTagGroup(TagGroupEnum tagGroup) {
        this.tagGroup = tagGroup;
    }
}
