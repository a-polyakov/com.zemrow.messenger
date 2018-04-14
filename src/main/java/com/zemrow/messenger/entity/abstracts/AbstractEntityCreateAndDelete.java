package com.zemrow.messenger.entity.abstracts;

import java.util.UUID;

/**
 * Костяк сущности (с информацией о создании и удалении)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public abstract class AbstractEntityCreateAndDelete extends AbstractEntityCreateOnly {
    /**
     * Дата удаления записи
     */
    private Long deleteTime;
    /**
     * Пользователь удаливший запись
     */
    private UUID deletedBy;

//================================ AUTO GENERATE ==============================

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public UUID getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }
}
