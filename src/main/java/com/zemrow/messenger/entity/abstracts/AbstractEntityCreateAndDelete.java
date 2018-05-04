package com.zemrow.messenger.entity.abstracts;

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
    private Long deletedBy;

//================================ AUTO GENERATE ==============================

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractEntityCreateAndDelete{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deletedBy='").append(deletedBy).append('\'');
    }
}
