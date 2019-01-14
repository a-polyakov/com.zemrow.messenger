package com.zemrow.messenger.entity.abstracts;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Костяк сущности (с информацией о создании и удалении)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public abstract class AbstractEntityCreateAndDelete extends AbstractEntityWithId {
    /**
     * Дата удаления записи
     */
    @QuerySqlField()
    private Long deleteTime;
    /**
     * Пользователь удаливший запись
     */
    @QuerySqlField()
    private Long deletedBy;

//================================ AUTO GENERATE ==============================

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deletedBy='").append(deletedBy).append('\'');
    }
}
