package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserFilter;
import com.zemrow.messenger.entity.enums.FilterPageTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserFilter(Пользовательский фильтр) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String ID = "id";

    /**
     * ID пользователя
     */
    public static final String USER_ID = "userId";

    /**
     * id части системы (грид, панель, список) для применения данного фильтра
     */
    public static final String PAGE_TYPE = "pageType";

    /**
     * Название фильтра
     */
    public static final String FILTER_LABEL = "filterLabel";

    /**
     * Данные фильтра в формате JSON
     */
    public static final String DATA = "data";

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
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber(USER_ID, Long.class);

    /**
     * id части системы (грид, панель, список) для применения данного фильтра
     */
    public final EnumPath<FilterPageTypeEnum> pageType = createEnum(PAGE_TYPE, FilterPageTypeEnum.class);

    /**
     * Название фильтра
     */
    public final StringPath filterLabel = createString(FILTER_LABEL);

    /**
     * Данные фильтра в формате JSON
     */
    public final StringPath data = createString(DATA);

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
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(pageType, ColumnMetadata.named(PAGE_TYPE).withIndex(3).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(filterLabel, ColumnMetadata.named(FILTER_LABEL).withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(data, ColumnMetadata.named(DATA).withIndex(5).ofType(Types.OTHER).withSize(2147483647).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

