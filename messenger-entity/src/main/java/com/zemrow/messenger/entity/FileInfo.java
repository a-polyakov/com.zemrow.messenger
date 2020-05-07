package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;
import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы FileInfo(Файл) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.05.07
 */
public class FileInfo extends AbstractEntityWithId {

    /**
     * Наименование файла
     */
    private String name;

    /**
     * MIME-тип файла
     */
    private String mimeType;

    /**
     * Размер файла
     */
    private Long fileSize;

    /**
     * Место хранения в файловой системе, на основе UUID
     */
    private String path;

    /**
     * Тип доступа
     */
    private FileAccessTypeEnum fileAccessType;

    /**
     * Контрольная сумма, для поиска дубликатов
     */
    private Integer crc32;

    /**
     * Дата последнего скачивания файла, для архивирования редко используемых
     */
    private Long lastOpenTime;

    /**
     * Файл заархивирован
     */
    private Boolean gzipOn;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Дата удаления записи
     */
    private Long deleteTime;

    /**
     * Пользователь удаливший запись
     */
    private Long deletedBy;

    /**
     * Создать Файл
     */
    public FileInfo() {
    }

    /**
     * Создать Файл
     * @param id ID записи
     * @param name Наименование файла
     * @param mimeType MIME-тип файла
     * @param fileSize Размер файла
     * @param path Место хранения в файловой системе, на основе UUID
     * @param fileAccessType Тип доступа
     * @param crc32 Контрольная сумма, для поиска дубликатов
     * @param lastOpenTime Дата последнего скачивания файла, для архивирования редко используемых
     * @param gzipOn Файл заархивирован
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public FileInfo(Long id, String name, String mimeType, Long fileSize, String path, FileAccessTypeEnum fileAccessType, Integer crc32, Long lastOpenTime, Boolean gzipOn, Long createTime, Long createdBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.name = name;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
        this.path = path;
        this.fileAccessType = fileAccessType;
        this.crc32 = crc32;
        this.lastOpenTime = lastOpenTime;
        this.gzipOn = gzipOn;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.deleteTime = deleteTime;
        this.deletedBy = deletedBy;
    }

    @Override
    public void preInsert(SessionStorage session) {
        if (createTime == null) {
            createTime = System.currentTimeMillis();
        }
        if (createdBy == null) {
            createdBy = session.getUserId();
        }
    }

    @Override
    public void preDelete(SessionStorage session) {
        if (deleteTime == null) {
            deleteTime = System.currentTimeMillis();
        }
        if (deletedBy == null) {
            deletedBy = session.getUserId();
        }
    }

    /**
     * Получение наименование файла
     */
    public String getName() {
        return name;
    }

    /**
     * Установить наименование файла
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получение mime-тип файла
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Установить mime-тип файла
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Получение размер файла
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * Установить размер файла
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Получение место хранения в файловой системе, на основе uuid
     */
    public String getPath() {
        return path;
    }

    /**
     * Установить место хранения в файловой системе, на основе uuid
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Получение тип доступа
     */
    public FileAccessTypeEnum getFileAccessType() {
        return fileAccessType;
    }

    /**
     * Установить тип доступа
     */
    public void setFileAccessType(FileAccessTypeEnum fileAccessType) {
        this.fileAccessType = fileAccessType;
    }

    /**
     * Получение контрольная сумма, для поиска дубликатов
     */
    public Integer getCrc32() {
        return crc32;
    }

    /**
     * Установить контрольная сумма, для поиска дубликатов
     */
    public void setCrc32(Integer crc32) {
        this.crc32 = crc32;
    }

    /**
     * Получение дата последнего скачивания файла, для архивирования редко используемых
     */
    public Long getLastOpenTime() {
        return lastOpenTime;
    }

    /**
     * Установить дата последнего скачивания файла, для архивирования редко используемых
     */
    public void setLastOpenTime(Long lastOpenTime) {
        this.lastOpenTime = lastOpenTime;
    }

    /**
     * Получение файл заархивирован
     */
    public Boolean getGzipOn() {
        return gzipOn;
    }

    /**
     * Установить файл заархивирован
     */
    public void setGzipOn(Boolean gzipOn) {
        this.gzipOn = gzipOn;
    }

    /**
     * Получение дата создания записи
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * Установить дата создания записи
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * Получение пользователь создавший запись
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * Установить пользователь создавший запись
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Получение дата удаления записи
     */
    public Long getDeleteTime() {
        return deleteTime;
    }

    /**
     * Установить дата удаления записи
     */
    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * Получение пользователь удаливший запись
     */
    public Long getDeletedBy() {
        return deletedBy;
    }

    /**
     * Установить пользователь удаливший запись
     */
    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.FileInfo\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (name != null) {
            result.append(", name = \"").append(name).append('"');
        }
        if (mimeType != null) {
            result.append(", mimeType = \"").append(mimeType).append('"');
        }
        if (fileSize != null) {
            result.append(", fileSize = \"").append(fileSize).append('"');
        }
        if (path != null) {
            result.append(", path = \"").append(path).append('"');
        }
        if (fileAccessType != null) {
            result.append(", fileAccessType = \"").append(fileAccessType).append('"');
        }
        if (crc32 != null) {
            result.append(", crc32 = \"").append(crc32).append('"');
        }
        if (lastOpenTime != null) {
            result.append(", lastOpenTime = \"").append(lastOpenTime).append('"');
        }
        if (gzipOn != null) {
            result.append(", gzipOn = \"").append(gzipOn).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
        }
        if (deleteTime != null) {
            result.append(", deleteTime = \"").append(deleteTime).append('"');
        }
        if (deletedBy != null) {
            result.append(", deletedBy = \"").append(deletedBy).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

