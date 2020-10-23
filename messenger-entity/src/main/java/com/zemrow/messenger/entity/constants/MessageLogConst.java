package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.MessageLog;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы MessageLog(История сообщения) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class MessageLogConst extends com.querydsl.sql.RelationalPathBase<MessageLog> {

    private static final long serialVersionUID = -950811324;

    /**
     * История сообщения
     */
    public static final MessageLogConst MessageLog = new MessageLogConst("MessageLog");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * ID сообщения
     */
    public static final String MESSAGE_ID = "messageId";

    /**
     * Предыдущий текст
     */
    public static final String OLD_TEXT = "oldText";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Пользователь создавший запись
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber(ID, Long.class);

    /**
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber(MESSAGE_ID, Long.class);

    /**
     * Предыдущий текст
     */
    public final StringPath oldText = createString(OLD_TEXT);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

    public MessageLogConst(String variable) {
        super(MessageLog.class, forVariable(variable), "public", "MessageLog");
        addMetadata();
    }

    public MessageLogConst(com.querydsl.core.types.Path<? extends MessageLog> path) {
        super(path.getType(), path.getMetadata(), "public", "MessageLog");
        addMetadata();
    }

    public MessageLogConst(PathMetadata metadata) {
        super(MessageLog.class, metadata, "public", "MessageLog");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named(MESSAGE_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(oldText, ColumnMetadata.named(OLD_TEXT).withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

