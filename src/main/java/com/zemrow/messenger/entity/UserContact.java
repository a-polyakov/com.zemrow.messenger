package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Контакты пользователя
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserContact extends AbstractEntity {
    /**
     * ID пользователя родителя
     */
    @QuerySqlField(notNull = true, index = true)
    @AffinityKeyMapped
    public Long parentUserId;
    /**
     * ID пользователя потомка
     */
    @QuerySqlField(notNull = true, index = true)
    public Long childUserId;
    /**
     * Прошел ли подтверждение запрос на добавление
     * TODO Добавить логику черного списка
     */
    @QuerySqlField(notNull = true)
    public Boolean validate;
    /**
     * Наименование контакта
     */
    @QuerySqlField(notNull = true)
    public String label;
    /**
     * ID чата
     */
    @QuerySqlField(notNull = true, index = true)
    public Long chatId;

//================================ AUTO GENERATE ==============================

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

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", parentUserId='").append(parentUserId).append('\'');
        sb.append(", childUserId='").append(childUserId).append('\'');
        sb.append(", validate=").append(validate);
        sb.append(", label='").append(label).append('\'');
        sb.append(", chatId='").append(chatId).append('\'');
    }
}
