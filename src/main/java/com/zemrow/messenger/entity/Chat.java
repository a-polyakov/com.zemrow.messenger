package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Чат
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Chat extends AbstractEntity {
    /**
     * Наименование чата
     */
    @QuerySqlField(notNull = true)
    public String label;
    /**
     * Тип чата: чат, задание
     */
    @QuerySqlField(notNull = true)
    public ChatTypeEnum chatType;
    /**
     * Использованый нумиратор (для определения префикса)
     */
    @QuerySqlField
    public Long numberingId;
    /**
     * Номер чата(документа)
     */
    @QuerySqlField
    public Long orderNumber;

//================================ AUTO GENERATE ==============================

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ChatTypeEnum getChatType() {
        return chatType;
    }

    public void setChatType(ChatTypeEnum chatType) {
        this.chatType = chatType;
    }

    public Long getNumberingId() {
        return numberingId;
    }

    public void setNumberingId(Long numberingId) {
        this.numberingId = numberingId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", label='").append(label).append('\'');
        sb.append(", chatType='").append(chatType).append('\'');
        sb.append(", numberingId='").append(numberingId).append('\'');
        sb.append(", orderNumber=").append(orderNumber);
    }
}
