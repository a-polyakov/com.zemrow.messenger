package com.zemrow.messenger.entity.abstracts;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Костяк сущности (с информацией о создании)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public abstract class AbstractEntityCreateOnly extends AbstractEntityWithoutId {
    /**
     * ID записи
     */
    @QuerySqlField(notNull = true, index = true)
    private Long id;
    /**
     * Дата создания записи
     */
    @QuerySqlField(notNull = true)
    private Long createTime;
    /**
     * Пользователь создавший запись
     */
    @QuerySqlField(notNull = true)
    private Long createdBy;

//================================ AUTO GENERATE ==============================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractEntityCreateOnly{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("id='").append(id).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", createdBy='").append(createdBy).append('\'');
    }
}
