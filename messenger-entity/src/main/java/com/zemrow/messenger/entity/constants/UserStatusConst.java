package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserStatus(Справочник статусов пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class UserStatusConst extends com.querydsl.sql.RelationalPathBase<UserStatus> {

    private static final long serialVersionUID = -1963405532;

    /**
     * Справочник статусов пользователя
     */
    public static final UserStatusConst UserStatus = new UserStatusConst("UserStatus");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    public static final String LABEL = "label";

    /**
     * Тип статуса для связки наименование статуса с логикой
     */
    public static final String USER_STATUS_TYPE = "userStatusType";

    /**
     * Вес статуса
     */
    public static final String WEIGHT = "weight";

    /**
     * Цвет статуса
     */
    public static final String COLOR = "color";

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
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    public final StringPath label = createString(LABEL);

    /**
     * Тип статуса для связки наименование статуса с логикой
     */
    public final EnumPath<UserStatusTypeEnum> userStatusType = createEnum(USER_STATUS_TYPE, UserStatusTypeEnum.class);

    /**
     * Вес статуса
     */
    public final NumberPath<Integer> weight = createNumber(WEIGHT, Integer.class);

    /**
     * Цвет статуса
     */
    public final NumberPath<Integer> color = createNumber(COLOR, Integer.class);

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

    public UserStatusConst(String variable) {
        super(UserStatus.class, forVariable(variable), "public", "UserStatus");
        addMetadata();
    }

    public UserStatusConst(com.querydsl.core.types.Path<? extends UserStatus> path) {
        super(path.getType(), path.getMetadata(), "public", "UserStatus");
        addMetadata();
    }

    public UserStatusConst(PathMetadata metadata) {
        super(UserStatus.class, metadata, "public", "UserStatus");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(label, ColumnMetadata.named(LABEL).withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(userStatusType, ColumnMetadata.named(USER_STATUS_TYPE).withIndex(3).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(weight, ColumnMetadata.named(WEIGHT).withIndex(4).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(color, ColumnMetadata.named(COLOR).withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

