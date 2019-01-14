package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractKey;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Ключ
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class SimpleKey extends AbstractKey {
    /**
     * ID
     */
    @QuerySqlField(notNull = true)
    public Long id;

//================================ AUTO GENERATE ==============================

    public SimpleKey(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    protected void toString(StringBuilder sb) {
        sb.append("id='").append(id).append('\'');
    }
}
