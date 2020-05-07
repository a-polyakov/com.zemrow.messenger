package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.FileInfo;


import com.querydsl.core.types.dsl.*;

import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;
import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы FileInfo(Файл) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class FileInfoConst extends com.querydsl.sql.RelationalPathBase<FileInfo> {

    private static final long serialVersionUID = 1226920337;

    /**
     * Файл
     */
    public static final FileInfoConst FileInfo = new FileInfoConst("FileInfo");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * Наименование файла
     */
    public final StringPath name = createString("name");

    /**
     * MIME-тип файла
     */
    public final StringPath mimeType = createString("mimeType");

    /**
     * Размер файла
     */
    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    /**
     * Место хранения в файловой системе, на основе UUID
     */
    public final StringPath path = createString("path");

    /**
     * Тип доступа
     */
    public final EnumPath<FileAccessTypeEnum> fileAccessType = createEnum("fileAccessType", FileAccessTypeEnum.class);

    /**
     * Контрольная сумма, для поиска дубликатов
     */
    public final NumberPath<Integer> crc32 = createNumber("crc32", Integer.class);

    /**
     * Дата последнего скачивания файла, для архивирования редко используемых
     */
    public final NumberPath<Long> lastOpenTime = createNumber("lastOpenTime", Long.class);

    /**
     * Файл заархивирован
     */
    public final BooleanPath gzipOn = createBoolean("gzipOn");

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber("deleteTime", Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber("deletedBy", Long.class);

    public FileInfoConst(String variable) {
        super(FileInfo.class, forVariable(variable), "public", "FileInfo");
        addMetadata();
    }

    public FileInfoConst(com.querydsl.core.types.Path<? extends FileInfo> path) {
        super(path.getType(), path.getMetadata(), "public", "FileInfo");
        addMetadata();
    }

    public FileInfoConst(PathMetadata metadata) {
        super(FileInfo.class, metadata, "public", "FileInfo");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(mimeType, ColumnMetadata.named("mimeType").withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(fileSize, ColumnMetadata.named("fileSize").withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(path, ColumnMetadata.named("path").withIndex(5).ofType(Types.CHAR).withSize(36).notNull());
        addMetadata(fileAccessType, ColumnMetadata.named("fileAccessType").withIndex(6).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(crc32, ColumnMetadata.named("crc32").withIndex(7).ofType(Types.INTEGER).withSize(10));
        addMetadata(lastOpenTime, ColumnMetadata.named("lastOpenTime").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(gzipOn, ColumnMetadata.named("gzipOn").withIndex(9).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(11).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(12).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(13).ofType(Types.BIGINT).withSize(19));
    }

}

