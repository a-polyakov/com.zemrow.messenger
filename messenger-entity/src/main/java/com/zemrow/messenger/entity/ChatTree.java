package com.zemrow.messenger.entity;

/**
 * Класс сгенерирован автоматически, для таблицы ChatTree(Дерево задач. Данные являются избыточными, возможно восстановить.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class ChatTree extends AbstractEntity {

    /**
     * ID родительского чата
     */
    private Long parentChatId;

    /**
     * ID дочернего чата
     */
    private Long childChatId;

    /**
     * Разность уровней
     */
    private Integer distance;

    /**
     * Создать Дерево задач. Данные являются избыточными, возможно восстановить.
     */
    public ChatTree() {
    }

    /**
     * Создать Дерево задач. Данные являются избыточными, возможно восстановить.
     * @param parentChatId ID родительского чата
     * @param childChatId ID дочернего чата
     * @param distance Разность уровней
     */
    public ChatTree(Long parentChatId, Long childChatId, Integer distance) {
        this.parentChatId = parentChatId;
        this.childChatId = childChatId;
        this.distance = distance;
    }

    /**
     * Получение id родительского чата
     */
    public Long getParentChatId() {
        return parentChatId;
    }

    /**
     * Установить id родительского чата
     */
    public void setParentChatId(Long parentChatId) {
        this.parentChatId = parentChatId;
    }

    /**
     * Получение id дочернего чата
     */
    public Long getChildChatId() {
        return childChatId;
    }

    /**
     * Установить id дочернего чата
     */
    public void setChildChatId(Long childChatId) {
        this.childChatId = childChatId;
    }

    /**
     * Получение разность уровней
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Установить разность уровней
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.ChatTree\"");
        if (parentChatId != null) {
            result.append(", parentChatId = \"").append(parentChatId).append('"');
        }
        if (childChatId != null) {
            result.append(", childChatId = \"").append(childChatId).append('"');
        }
        if (distance != null) {
            result.append(", distance = \"").append(distance).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

