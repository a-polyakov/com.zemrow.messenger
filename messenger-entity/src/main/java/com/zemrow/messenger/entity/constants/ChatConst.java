package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы Chat(Чат) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class ChatConst extends com.querydsl.sql.RelationalPathBase<Chat> {

    private static final long serialVersionUID = -1119490017;

    /**
     * Чат
     */
    public static final ChatConst Chat = new ChatConst("Chat");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * Наименование чата
     */
    public static final String LABEL = "label";

    /**
     * Тип чата: чат, задание
     */
    public static final String CHAT_TYPE = "chatType";

    /**
     * Использованый нумиратор (для определения префикса)
     */
    public static final String NUMBERING_ID = "numberingId";

    /**
     * Номер чата(документа)
     */
    public static final String ORDER_NUMBER = "orderNumber";

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
     * Наименование чата
     */
    public final StringPath label = createString(LABEL);

    /**
     * Тип чата: чат, задание
     */
    public final EnumPath<ChatTypeEnum> chatType = createEnum(CHAT_TYPE, ChatTypeEnum.class);

    /**
     * Использованый нумиратор (для определения префикса)
     */
    public final NumberPath<Long> numberingId = createNumber(NUMBERING_ID, Long.class);

    /**
     * Номер чата(документа)
     */
    public final NumberPath<Long> orderNumber = createNumber(ORDER_NUMBER, Long.class);

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

    public ChatConst(String variable) {
        super(Chat.class, forVariable(variable), "public", "Chat");
        addMetadata();
    }

    public ChatConst(com.querydsl.core.types.Path<? extends Chat> path) {
        super(path.getType(), path.getMetadata(), "public", "Chat");
        addMetadata();
    }

    public ChatConst(PathMetadata metadata) {
        super(Chat.class, metadata, "public", "Chat");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(label, ColumnMetadata.named(LABEL).withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(chatType, ColumnMetadata.named(CHAT_TYPE).withIndex(3).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(numberingId, ColumnMetadata.named(NUMBERING_ID).withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(orderNumber, ColumnMetadata.named(ORDER_NUMBER).withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

