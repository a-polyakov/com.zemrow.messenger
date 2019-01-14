package com.zemrow.messenger.dto;

import java.util.List;

/**
 * Данные для постраничной навигации.
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class PageNavigationDto<T> {
    /**
     * Элементы старницы, список может быть пустым (null).
     */
    private List<T> page;
    /**
     * На сколько элементов необходимо сместится относительно начала списка.
     */
    private int offset;
    /**
     * Максимальное количество элементов на странице.
     */
    private int limit;
    // TODO totaSize

//================================ AUTO GENERATE ==============================

    public List<T> getPage() {
        return page;
    }

    public void setPage(List<T> page) {
        this.page = page;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
