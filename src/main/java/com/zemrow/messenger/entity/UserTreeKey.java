package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractKey;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Дерево пользователей, ключ
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserTreeKey extends AbstractKey {
    /**
     * ID родительского пользователя
     */
    @QuerySqlField(notNull = true)
    public Long parentUserId;
    /**
     * ID дочернего пользователя
     */
    @QuerySqlField(notNull = true)
    public Long childUserId;

//================================ AUTO GENERATE ==============================


    public UserTreeKey() {
    }

    public UserTreeKey(Long parentUserId, Long childUserId) {
        this.parentUserId = parentUserId;
        this.childUserId = childUserId;
    }

    public Long getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    public Long getChildUserId() {
        return childUserId;
    }

    public void setChildUserId(Long childUserId) {
        this.childUserId = childUserId;
    }

    @Override
    public void toString(StringBuilder sb) {
        sb.append("parentUserId='").append(parentUserId).append('\'');
        sb.append(", childUserId='").append(childUserId).append('\'');
    }

}
