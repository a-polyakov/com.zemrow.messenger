package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.Numbering;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы Numbering(Настройка нумирации для компании и типа чата) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class NumberingConst extends com.querydsl.sql.RelationalPathBase<Numbering> {

    private static final long serialVersionUID = -1928424558;

    /**
     * Настройка нумирации для компании и типа чата
     */
    public static final NumberingConst Numbering = new NumberingConst("Numbering");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * id пользователя(компания, отдел)
     */
    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    /**
     * Префикс
     */
    public final StringPath prefix = createString("prefix");

    /**
     * Последний выданный номер
     */
    public final NumberPath<Long> maxNumber = createNumber("maxNumber", Long.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    /**
     * Дата обновления записи
     */
    public final NumberPath<Long> updateTime = createNumber("updateTime", Long.class);

    /**
     * Пользователь обновивший запись
     */
    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber("deleteTime", Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber("deletedBy", Long.class);

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
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(prefix, ColumnMetadata.named("prefix").withIndex(3).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(maxNumber, ColumnMetadata.named("maxNumber").withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(9).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(10).ofType(Types.BIGINT).withSize(19));
    }

}

