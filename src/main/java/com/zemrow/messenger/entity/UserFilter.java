package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.FilterGridEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.lang.IgniteUuid;

/**
 * Пользовательский фильтр
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserFilter extends AbstractEntity {
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true, index = true)
    public IgniteUuid userId;
    /**
     * id части системы (грид, панель, список) для применения данного фильтра
     */
    private FilterGridEnum gridId;
    /**
     * id (название) фильтра
     */
    private String filterId;
    /**
     * Данные фильтра в формате JSON
     */
    private String data;

//================================ AUTO GENERATE ==============================

    public IgniteUuid getUserId() {
        return userId;
    }

    public void setUserId(IgniteUuid userId) {
        this.userId = userId;
    }

    public FilterGridEnum getGridId() {
        return gridId;
    }

    public void setGridId(FilterGridEnum gridId) {
        this.gridId = gridId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserFilter{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", gridId='").append(gridId).append('\'');
        sb.append(", filterId='").append(filterId).append('\'');
        sb.append(", data='").append(data).append('\'');
    }
}
