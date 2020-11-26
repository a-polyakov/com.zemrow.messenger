package com.zemrow.messenger.dto;

import java.util.List;

/**
 * Данные для постраничной навигации.
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class PageNavigationDto<T extends AbstractDto> extends AbstractDto {
    /**
     * Элементы страницы, список может быть пустым (null).
     */
    private List<T> page;
    /**
     * На сколько элементов необходимо сместится относительно начала списка.
     */
    private long offset;
    /**
     * Максимальное количество элементов на странице.
     */
    private long limit;
    /**
     * Количество записей всего
     */
    private long totalSize;

//================================ AUTO GENERATE ==============================


    public PageNavigationDto() {
    }

    public PageNavigationDto(List<T> page, long offset, long limit, long totalSize) {
        this.page = page;
        this.offset = offset;
        this.limit = limit;
        this.totalSize = totalSize;
    }

    public List<T> getPage() {
        return page;
    }

    public void setPage(List<T> page) {
        this.page = page;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("{class = \"com.zemrow.messenger.dto.PageNavigationDto\"");
        if (page != null) {
            result.append(", page=\"").append(page).append('"');
        }
        result.append(", offset=\"").append(offset).append('"');
        result.append(", limit=\"").append(limit).append('"');
        result.append(", totalSize=\"").append(totalSize).append('"');
        result.append('}');
        return result.toString();
    }
}
