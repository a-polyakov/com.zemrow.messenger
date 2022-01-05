package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.FileInfo;
import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы FileInfo(Файл) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String ID = "id";

    /**
     * Наименование файла
     */
    public static final String NAME = "name";

    /**
     * MIME-тип файла
     */
    public static final String MIME_TYPE = "mimeType";

    /**
     * Размер файла
     */
    public static final String FILE_SIZE = "fileSize";

    /**
     * Место хранения. В файловой системе, на основе UUID
     */
    public static final String PATH = "path";

    /**
     * Тип доступа
     */
    public static final String FILE_ACCESS_TYPE = "fileAccessType";

    /**
     * Контрольная сумма. Для поиска дубликатов
     */
    public static final String CRC32 = "crc32";

    /**
     * Дата последнего скачивания файла. Для архивирования редко используемых
     */
    public static final String LAST_OPEN_TIME = "lastOpenTime";

    /**
     * Файл заархивирован
     */
    public static final String GZIP_ON = "gzipOn";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Пользователь создавший запись
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * Дата удаления записи
     */
    public static final String DELETE_TIME = "deleteTime";

    /**
     * Пользователь удаливший запись
     */
    public static final String DELETED_BY = "deletedBy";

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber(ID, Long.class);

    /**
     * Наименование файла
     */
    public final StringPath name = createString(NAME);

    /**
     * MIME-тип файла
     */
    public final StringPath mimeType = createString(MIME_TYPE);

    /**
     * Размер файла
     */
    public final NumberPath<Long> fileSize = createNumber(FILE_SIZE, Long.class);

    /**
     * Место хранения. В файловой системе, на основе UUID
     */
    public final StringPath path = createString(PATH);

    /**
     * Тип доступа
     */
    public final EnumPath<FileAccessTypeEnum> fileAccessType = createEnum(FILE_ACCESS_TYPE, FileAccessTypeEnum.class);

    /**
     * Контрольная сумма. Для поиска дубликатов
     */
    public final NumberPath<Integer> crc32 = createNumber(CRC32, Integer.class);

    /**
     * Дата последнего скачивания файла. Для архивирования редко используемых
     */
    public final NumberPath<Long> lastOpenTime = createNumber(LAST_OPEN_TIME, Long.class);

    /**
     * Файл заархивирован
     */
    public final BooleanPath gzipOn = createBoolean(GZIP_ON);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber(DELETE_TIME, Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber(DELETED_BY, Long.class);

    public final com.querydsl.sql.PrimaryKey<FileInfo> fileinfo_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> FileInfo_createdBy_fk = createForeignKey(createdBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> FileInfo_deletedBy_fk = createForeignKey(deletedBy, "id");

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
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named(NAME).withIndex(2).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(mimeType, ColumnMetadata.named(MIME_TYPE).withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(fileSize, ColumnMetadata.named(FILE_SIZE).withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(path, ColumnMetadata.named(PATH).withIndex(5).ofType(Types.CHAR).withSize(36).notNull());
        addMetadata(fileAccessType, ColumnMetadata.named(FILE_ACCESS_TYPE).withIndex(6).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(crc32, ColumnMetadata.named(CRC32).withIndex(7).ofType(Types.INTEGER).withSize(10));
        addMetadata(lastOpenTime, ColumnMetadata.named(LAST_OPEN_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(gzipOn, ColumnMetadata.named(GZIP_ON).withIndex(9).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(12).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(13).ofType(Types.BIGINT).withSize(19));
    }

}

