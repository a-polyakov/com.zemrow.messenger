package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserStatus;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserStatus(Справочник статусов пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
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
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    public final StringPath label = createString("label");

    /**
     * Тип статуса для связки наименование статуса с логикой
     */
    public final EnumPath<UserStatusTypeEnum> userStatusType = createEnum("userStatusType", UserStatusTypeEnum.class);

    /**
     * Вес статуса
     */
    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    /**
     * Цвет статуса
     */
    public final NumberPath<Integer> color = createNumber("color", Integer.class);

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
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(label, ColumnMetadata.named("label").withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(userStatusType, ColumnMetadata.named("userStatusType").withIndex(3).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(weight, ColumnMetadata.named("weight").withIndex(4).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(color, ColumnMetadata.named("color").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

