package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы ChatToUser(Пользователи в чате) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class ChatToUserConst extends com.querydsl.sql.RelationalPathBase<ChatToUser> {

    private static final long serialVersionUID = -896613915;

    /**
     * Пользователи в чате
     */
    public static final ChatToUserConst ChatToUser = new ChatToUserConst("ChatToUser");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * ID чата
     */
    public static final String CHAT_ID = "chatId";

    /**
     * ID пользователя
     */
    public static final String USER_ID = "userId";

    /**
     * Избранный чат
     */
    public static final String FAVORITE = "favorite";

    /**
     * Тип участника: обычный, скрытый только для чтения, скрытый полный доступ
     */
    public static final String CHAT_TO_USER_TYPE = "chatToUserType";

    /**
     * Отключить уведомления
     */
    public static final String MUTE = "mute";

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
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber(CHAT_ID, Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber(USER_ID, Long.class);

    /**
     * Избранный чат
     */
    public final BooleanPath favorite = createBoolean(FAVORITE);

    /**
     * Тип участника: обычный, скрытый только для чтения, скрытый полный доступ
     */
    public final EnumPath<ChatToUserTypeEnum> chatToUserType = createEnum(CHAT_TO_USER_TYPE, ChatToUserTypeEnum.class);

    /**
     * Отключить уведомления
     */
    public final BooleanPath mute = createBoolean(MUTE);

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

    public ChatToUserConst(String variable) {
        super(ChatToUser.class, forVariable(variable), "public", "ChatToUser");
        addMetadata();
    }

    public ChatToUserConst(com.querydsl.core.types.Path<? extends ChatToUser> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatToUser");
        addMetadata();
    }

    public ChatToUserConst(PathMetadata metadata) {
        super(ChatToUser.class, metadata, "public", "ChatToUser");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named(CHAT_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(favorite, ColumnMetadata.named(FAVORITE).withIndex(4).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(chatToUserType, ColumnMetadata.named(CHAT_TO_USER_TYPE).withIndex(5).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(mute, ColumnMetadata.named(MUTE).withIndex(6).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(11).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(12).ofType(Types.BIGINT).withSize(19));
    }

}

