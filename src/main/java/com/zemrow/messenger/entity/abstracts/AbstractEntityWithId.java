package com.zemrow.messenger.entity.abstracts;

import com.zemrow.messenger.entity.SimpleKey;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Костяк сущности (с информацией о создании)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public abstract class AbstractEntityWithId extends AbstractEntityWithoutId<SimpleKey> {
    /**
     * ID записи
     */
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

    protected void toString(StringBuilder sb) {
        sb.append("id='").append(id).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", createdBy='").append(createdBy).append('\'');
    }

    @Override
    public SimpleKey getKey() {
        return new SimpleKey(id);
    }
}
