package com.zemrow.messenger.entity;

/**
 * Класс сгенерирован автоматически, для таблицы UserTree(Дерево пользователей. Данные являются избыточными, возможно восстановить.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserTree extends AbstractEntity {

    /**
     * ID родительского пользователя
     */
    private Long parentUserId;

    /**
     * ID дочернего пользователя
     */
    private Long childUserId;

    /**
     * Разность уровней
     */
    private Integer distance;

    /**
     * Создать Дерево пользователей. Данные являются избыточными, возможно восстановить.
     */
    public UserTree() {
    }

    /**
     * Создать Дерево пользователей. Данные являются избыточными, возможно восстановить.
     * @param parentUserId ID родительского пользователя
     * @param childUserId ID дочернего пользователя
     * @param distance Разность уровней
     */
    public UserTree(Long parentUserId, Long childUserId, Integer distance) {
        this.parentUserId = parentUserId;
        this.childUserId = childUserId;
        this.distance = distance;
    }

    /**
     * Получение id родительского пользователя
     */
    public Long getParentUserId() {
        return parentUserId;
    }

    /**
     * Установить id родительского пользователя
     */
    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    /**
     * Получение id дочернего пользователя
     */
    public Long getChildUserId() {
        return childUserId;
    }

    /**
     * Установить id дочернего пользователя
     */
    public void setChildUserId(Long childUserId) {
        this.childUserId = childUserId;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserTree\"");
        if (parentUserId != null) {
            result.append(", parentUserId = \"").append(parentUserId).append('"');
        }
        if (childUserId != null) {
            result.append(", childUserId = \"").append(childUserId).append('"');
        }
        if (distance != null) {
            result.append(", distance = \"").append(distance).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

