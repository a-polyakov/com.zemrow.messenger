package com.zemrow.messenger.entity.abstracts;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.lang.IgniteUuid;

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
    private IgniteUuid updatedBy;

//================================ AUTO GENERATE ==============================

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public IgniteUuid getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(IgniteUuid updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractEntity{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updatedBy='").append(updatedBy).append('\'');
    }
}
