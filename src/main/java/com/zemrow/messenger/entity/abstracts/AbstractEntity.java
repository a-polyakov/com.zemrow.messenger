package com.zemrow.messenger.entity.abstracts;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

/**
 * Костяк сущности (с информацией о создании, редактировании и удалении)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public abstract class AbstractEntity extends AbstractEntityCreateAndDelete {
    /**
     * Дата обновления записи
     */
    @QuerySqlField(notNull = true)
    private Long updateTime;
    /**
     * Пользователь обновивший запись
     */
    @QuerySqlField(notNull = true)
    private UUID updatedBy;

//================================ AUTO GENERATE ==============================

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

}
