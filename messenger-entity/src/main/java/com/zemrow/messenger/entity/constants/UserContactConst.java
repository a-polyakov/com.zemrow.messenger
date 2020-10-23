package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.entity.enums.UserContactStatusEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserContact(Контакты пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String ID = "id";

    /**
     * ID пользователя родителя
     */
    public static final String PARENT_USER_ID = "parentUserId";

    /**
     * ID пользователя потомка
     */
    public static final String CHILD_USER_ID = "childUserId";

    /**
     * Статус контакта (Запрошен, принят, отклонен)
     */
    public static final String USER_CONTACT_STATUS = "userContactStatus";

    /**
     * Наименование контакта
     */
    public static final String LABEL = "label";

    /**
     * ID чата
     */
    public static final String CHAT_ID = "chatId";

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
     * ID пользователя родителя
     */
    public final NumberPath<Long> parentUserId = createNumber(PARENT_USER_ID, Long.class);

    /**
     * ID пользователя потомка
     */
    public final NumberPath<Long> childUserId = createNumber(CHILD_USER_ID, Long.class);

    /**
     * Статус контакта (Запрошен, принят, отклонен)
     */
    public final EnumPath<UserContactStatusEnum> userContactStatus = createEnum(USER_CONTACT_STATUS, UserContactStatusEnum.class);

    /**
     * Наименование контакта
     */
    public final StringPath label = createString(LABEL);

    /**
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber(CHAT_ID, Long.class);

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
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(parentUserId, ColumnMetadata.named(PARENT_USER_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childUserId, ColumnMetadata.named(CHILD_USER_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userContactStatus, ColumnMetadata.named(USER_CONTACT_STATUS).withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(label, ColumnMetadata.named(LABEL).withIndex(5).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(chatId, ColumnMetadata.named(CHAT_ID).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(11).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(12).ofType(Types.BIGINT).withSize(19));
    }

}

