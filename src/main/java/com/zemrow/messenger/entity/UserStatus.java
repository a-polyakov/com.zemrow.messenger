package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Справочник статусов пользователя
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserStatus extends AbstractEntity {
    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    @QuerySqlField(notNull = true)
    private String label;
    /**
     * Тип статуса для связки наименование статуса с логикой
     */
    @QuerySqlField(notNull = true)
    private UserStatusTypeEnum userStatusType;
    /**
     * Вес статуса
     */
    @QuerySqlField(notNull = true)
    private Integer weight;
    /**
     * Цвет статуса
     */
    @QuerySqlField(notNull = true)
    private Integer color;

//================================ AUTO GENERATE ==============================

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public UserStatusTypeEnum getUserStatusType() {
        return userStatusType;
    }

    public void setUserStatusType(UserStatusTypeEnum userStatusType) {
        this.userStatusType = userStatusType;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", label='").append(label).append('\'');
        sb.append(", userStatusType=").append(userStatusType);
        sb.append(", weight=").append(weight);
        sb.append(", color=").append(color);
    }
}
