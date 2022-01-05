package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.Numbering;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы Numbering(Настройка нумерации для компании и типа чата) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class NumberingConst extends com.querydsl.sql.RelationalPathBase<Numbering> {

    private static final long serialVersionUID = -1928424558;

    /**
     * Настройка нумерации для компании и типа чата
     */
    public static final NumberingConst Numbering = new NumberingConst("Numbering");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * id пользователя(компания, отдел)
     */
    public static final String USER_ID = "userId";

    /**
     * Префикс
     */
    public static final String PREFIX = "prefix";

    /**
     * Последний выданный номер
     */
    public static final String MAX_NUMBER = "maxNumber";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Пользователь создавший запись
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * Дата обновления записи
     */
    public static final String UPDATE_TIME = "updateTime";

    /**
     * Пользователь обновивший запись
     */
    public static final String UPDATED_BY = "updatedBy";

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
     * id пользователя(компания, отдел)
     */
    public final NumberPath<Long> userId = createNumber(USER_ID, Long.class);

    /**
     * Префикс
     */
    public final StringPath prefix = createString(PREFIX);

    /**
     * Последний выданный номер
     */
    public final NumberPath<Long> maxNumber = createNumber(MAX_NUMBER, Long.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

    /**
     * Дата обновления записи
     */
    public final NumberPath<Long> updateTime = createNumber(UPDATE_TIME, Long.class);

    /**
     * Пользователь обновивший запись
     */
    public final NumberPath<Long> updatedBy = createNumber(UPDATED_BY, Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber(DELETE_TIME, Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber(DELETED_BY, Long.class);

    public final com.querydsl.sql.PrimaryKey<Numbering> numbering_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Numbering_createdBy_fk = createForeignKey(createdBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Numbering_updatedBy_fk = createForeignKey(updatedBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Numbering_deletedBy_fk = createForeignKey(deletedBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Numbering_userId_fk = createForeignKey(userId, "id");

    public NumberingConst(String variable) {
        super(Numbering.class, forVariable(variable), "public", "Numbering");
        addMetadata();
    }

    public NumberingConst(com.querydsl.core.types.Path<? extends Numbering> path) {
        super(path.getType(), path.getMetadata(), "public", "Numbering");
        addMetadata();
    }

    public NumberingConst(PathMetadata metadata) {
        super(Numbering.class, metadata, "public", "Numbering");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(prefix, ColumnMetadata.named(PREFIX).withIndex(3).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(maxNumber, ColumnMetadata.named(MAX_NUMBER).withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(9).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(10).ofType(Types.BIGINT).withSize(19));
    }

}

