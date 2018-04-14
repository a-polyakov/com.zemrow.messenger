package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;

/**
 * Файл
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class File extends AbstractEntityCreateAndDelete {
    /**
     * Наименование файла
     */
    public String name;
    /**
     * MIME-тип файла
     */
    public String mimeType;
    /**
     * Размер файла
     */
    public Long fileSize;
    /**
     * Место хранения в файловой системе, на основе UUID
     */
    public String path;
    /**
     * Тип доступа
     */
    public FileAccessTypeEnum fileAccessType;
    /**
     * Контрольная сумма, для поиска дубликатов
     */
    public Integer crc32;
    /**
     * Дата последнего скачивания файла, для архивирования редко используемых
     */
    public Long lastOpenTime;
    /**
     * Файл заархивирован
     */
    public Boolean gzipOn;

//================================ AUTO GENERATE ==============================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileAccessTypeEnum getFileAccessType() {
        return fileAccessType;
    }

    public void setFileAccessType(FileAccessTypeEnum fileAccessType) {
        this.fileAccessType = fileAccessType;
    }

    public Integer getCrc32() {
        return crc32;
    }

    public void setCrc32(Integer crc32) {
        this.crc32 = crc32;
    }

    public Long getLastOpenTime() {
        return lastOpenTime;
    }

    public void setLastOpenTime(Long lastOpenTime) {
        this.lastOpenTime = lastOpenTime;
    }

    public Boolean getGzipOn() {
        return gzipOn;
    }

    public void setGzipOn(Boolean gzipOn) {
        this.gzipOn = gzipOn;
    }
}
