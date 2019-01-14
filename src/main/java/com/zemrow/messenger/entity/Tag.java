package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import com.zemrow.messenger.entity.enums.TagTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Полный перечень тегов
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Tag extends AbstractEntity {
    /**
     * Тег
     */
    @QuerySqlField(notNull = true, index = true)
    public String tag;
    /**
     * Тип тега для связки наименование тега с логикой
     */
    @QuerySqlField
    public TagTypeEnum tagType;
    /**
     * Описание тега для автокомплита
     */
    @QuerySqlField
    public String description;
    /**
     * показывать ли в левом меню
     */
    @QuerySqlField(notNull = true)
    public Boolean leftMenuShow;
    /**
     * Показывать ли в хеадере
     */
    @QuerySqlField(notNull = true)
    public Boolean headerShow;
    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    @QuerySqlField
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

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", tag='").append(tag).append('\'');
        sb.append(", tagType='").append(tagType).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", leftMenuShow=").append(leftMenuShow);
        sb.append(", headerShow=").append(headerShow);
        sb.append(", tagGroup='").append(tagGroup).append('\'');
    }
}
