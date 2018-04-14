package com.zemrow.messenger.entity.abstracts;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

/**
 * Костяк сущности (с информацией о создании)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public abstract class AbstractEntityCreateOnly {
    /**
     * ID записи
     */
    private UUID id;
    /**
     * Дата создания записи
     */
    @QuerySqlField(notNull = true)
    private Long createTime;
    /**
     * Пользователь создавший запись
     */
    @QuerySqlField(notNull = true)
    private UUID createdBy;

//================================ AUTO GENERATE ==============================

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

}
