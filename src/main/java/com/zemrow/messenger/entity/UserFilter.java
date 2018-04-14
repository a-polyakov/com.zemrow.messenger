package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.FilterGridEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

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
    public UUID userId;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
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
}
