package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserFilter;


import com.querydsl.core.types.dsl.*;

import com.zemrow.messenger.entity.enums.FilterPageTypeEnum;
import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserFilter(Пользовательский фильтр) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserFilterConst extends com.querydsl.sql.RelationalPathBase<UserFilter> {

    private static final long serialVersionUID = 1949551274;

    /**
     * Пользовательский фильтр
     */
    public static final UserFilterConst UserFilter = new UserFilterConst("UserFilter");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    /**
     * id части системы (грид, панель, список) для применения данного фильтра
     */
    public final EnumPath<FilterPageTypeEnum> pageType = createEnum("pageType", FilterPageTypeEnum.class);

    /**
     * Название фильтра
     */
    public final StringPath filterLabel = createString("filterLabel");

    /**
     * Данные фильтра в формате JSON
     */
    public final StringPath data = createString("data");

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

    public UserFilterConst(String variable) {
        super(UserFilter.class, forVariable(variable), "public", "UserFilter");
        addMetadata();
    }

    public UserFilterConst(com.querydsl.core.types.Path<? extends UserFilter> path) {
        super(path.getType(), path.getMetadata(), "public", "UserFilter");
        addMetadata();
    }

    public UserFilterConst(PathMetadata metadata) {
        super(UserFilter.class, metadata, "public", "UserFilter");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(pageType, ColumnMetadata.named("pageType").withIndex(3).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(filterLabel, ColumnMetadata.named("filterLabel").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(data, ColumnMetadata.named("data").withIndex(5).ofType(Types.OTHER).withSize(2147483647).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

