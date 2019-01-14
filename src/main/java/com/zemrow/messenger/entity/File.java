package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Файл
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class File extends AbstractEntityCreateAndDelete {
    /**
     * Наименование файла
     */
    @QuerySqlField(notNull = true)
    public String name;
    /**
     * MIME-тип файла
     */
    @QuerySqlField(notNull = true)
    public String mimeType;
    /**
     * Размер файла
     */
    @QuerySqlField(notNull = true)
    public Long fileSize;
    /**
     * Место хранения в файловой системе, на основе UUID
     */
    @QuerySqlField(notNull = true)
    public String path;
    /**
     * Тип доступа
     */
    @QuerySqlField(notNull = true)
    public FileAccessTypeEnum fileAccessType;
    /**
     * Контрольная сумма, для поиска дубликатов
     */
    @QuerySqlField(notNull = true)
    public Integer crc32;
    /**
     * Дата последнего скачивания файла, для архивирования редко используемых
     */
    @QuerySqlField(notNull = true)
    public Long lastOpenTime;
    /**
     * Файл заархивирован
     */
    @QuerySqlField(notNull = true)
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

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", name='").append(name).append('\'');
        sb.append(", mimeType='").append(mimeType).append('\'');
        sb.append(", fileSize=").append(fileSize);
        sb.append(", path='").append(path).append('\'');
        sb.append(", fileAccessType='").append(fileAccessType).append('\'');
        sb.append(", crc32=").append(crc32);
        sb.append(", lastOpenTime=").append(lastOpenTime);
        sb.append(", gzipOn=").append(gzipOn);
    }
}
