package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.Message;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы Message(Сообщение) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class MessageConst extends com.querydsl.sql.RelationalPathBase<Message> {

    private static final long serialVersionUID = -90138144;

    /**
     * Сообщение
     */
    public static final MessageConst Message = new MessageConst("Message");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * ID чата
     */
    public static final String CHAT_ID = "chatId";

    /**
     * Текст
     */
    public static final String TEXT = "text";

    /**
     * ID прикрепленного файла
     */
    public static final String FILE_ID = "fileId";

    /**
     * ID созданного чата. Если сообщение содержало команду для создания дочернего чата (например задание).
     */
    public static final String CHILD_CHAT_ID = "childChatId";

    /**
     * Тип сообщения (SIMPLE, ERROR)
     */
    public static final String MESSAGE_TYPE = "messageType";

    /**
     * ID родительского сообщения
     */
    public static final String PARENT_MESSAGE_ID = "parentMessageId";

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
     * Текст
     */
    public final StringPath text = createString(TEXT);

    /**
     * ID прикрепленного файла
     */
    public final NumberPath<Long> fileId = createNumber(FILE_ID, Long.class);

    /**
     * ID созданного чата. Если сообщение содержало команду для создания дочернего чата (например задание).
     */
    public final NumberPath<Long> childChatId = createNumber(CHILD_CHAT_ID, Long.class);

    /**
     * Тип сообщения (SIMPLE, ERROR)
     */
    public final EnumPath<MessageTypeEnum> messageType = createEnum(MESSAGE_TYPE, MessageTypeEnum.class);

    /**
     * ID родительского сообщения
     */
    public final NumberPath<Long> parentMessageId = createNumber(PARENT_MESSAGE_ID, Long.class);

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

    public final com.querydsl.sql.PrimaryKey<Message> message_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Message_createdBy_fk = createForeignKey(createdBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.FileInfo> Message_fileId_fk = createForeignKey(fileId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Chat> Message_childChatId_fk = createForeignKey(childChatId, "id");

    public final com.querydsl.sql.ForeignKey<Message> Message_parentMessageId_fk = createForeignKey(parentMessageId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Message_updatedBy_fk = createForeignKey(updatedBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Chat> Message_chatId_fk = createForeignKey(chatId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Message_deletedBy_fk = createForeignKey(deletedBy, "id");

    public MessageConst(String variable) {
        super(Message.class, forVariable(variable), "public", "Message");
        addMetadata();
    }

    public MessageConst(com.querydsl.core.types.Path<? extends Message> path) {
        super(path.getType(), path.getMetadata(), "public", "Message");
        addMetadata();
    }

    public MessageConst(PathMetadata metadata) {
        super(Message.class, metadata, "public", "Message");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named(CHAT_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(text, ColumnMetadata.named(TEXT).withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fileId, ColumnMetadata.named(FILE_ID).withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(childChatId, ColumnMetadata.named(CHILD_CHAT_ID).withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(messageType, ColumnMetadata.named(MESSAGE_TYPE).withIndex(6).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(parentMessageId, ColumnMetadata.named(PARENT_MESSAGE_ID).withIndex(7).ofType(Types.BIGINT).withSize(19));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(12).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(13).ofType(Types.BIGINT).withSize(19));
    }

}

