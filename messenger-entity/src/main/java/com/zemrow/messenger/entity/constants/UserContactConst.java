package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserContact;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserContact(Контакты пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserContactConst extends com.querydsl.sql.RelationalPathBase<UserContact> {

    private static final long serialVersionUID = 2112621358;

    /**
     * Контакты пользователя
     */
    public static final UserContactConst UserContact = new UserContactConst("UserContact");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID пользователя родителя
     */
    public final NumberPath<Long> parentUserId = createNumber("parentUserId", Long.class);

    /**
     * ID пользователя потомка
     */
    public final NumberPath<Long> childUserId = createNumber("childUserId", Long.class);

    /**
     * Прошел ли подтверждение запрос на добавление
     */
    public final BooleanPath validate = createBoolean("validate");

    /**
     * Наименование контакта
     */
    public final StringPath label = createString("label");

    /**
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber("chatId", Long.class);

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

    public UserContactConst(String variable) {
        super(UserContact.class, forVariable(variable), "public", "UserContact");
        addMetadata();
    }

    public UserContactConst(com.querydsl.core.types.Path<? extends UserContact> path) {
        super(path.getType(), path.getMetadata(), "public", "UserContact");
        addMetadata();
    }

    public UserContactConst(PathMetadata metadata) {
        super(UserContact.class, metadata, "public", "UserContact");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(parentUserId, ColumnMetadata.named("parentUserId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childUserId, ColumnMetadata.named("childUserId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(validate, ColumnMetadata.named("validate").withIndex(4).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(label, ColumnMetadata.named("label").withIndex(5).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(chatId, ColumnMetadata.named("chatId").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(11).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(12).ofType(Types.BIGINT).withSize(19));
    }

}

