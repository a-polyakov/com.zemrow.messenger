package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.MessageTag;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы MessageTag(Тег сообщения) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class MessageTagConst extends com.querydsl.sql.RelationalPathBase<MessageTag> {

    private static final long serialVersionUID = -950804070;

    /**
     * Тег сообщения
     */
    public static final MessageTagConst MessageTag = new MessageTagConst("MessageTag");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * ID сообщения
     */
    public static final String MESSAGE_ID = "messageId";

    /**
     * ID тега
     */
    public static final String TAG_ID = "tagId";

    /**
     * Значение тега. ID чата, дата в ms, ID пользователя в зависимости от типа тега.
     */
    public static final String VALUE = "value";

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
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber(MESSAGE_ID, Long.class);

    /**
     * ID тега
     */
    public final NumberPath<Long> tagId = createNumber(TAG_ID, Long.class);

    /**
     * Значение тега. ID чата, дата в ms, ID пользователя в зависимости от типа тега.
     */
    public final StringPath value = createString(VALUE);

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

    public final com.querydsl.sql.PrimaryKey<MessageTag> messagetag_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> MessageTag_updatedBy_fk = createForeignKey(updatedBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Message> MessageTag_messageId_fk = createForeignKey(messageId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> MessageTag_createdBy_fk = createForeignKey(createdBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Tag> MessageTag_tagId_fk = createForeignKey(tagId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> MessageTag_deletedBy_fk = createForeignKey(deletedBy, "id");

    public MessageTagConst(String variable) {
        super(MessageTag.class, forVariable(variable), "public", "MessageTag");
        addMetadata();
    }

    public MessageTagConst(com.querydsl.core.types.Path<? extends MessageTag> path) {
        super(path.getType(), path.getMetadata(), "public", "MessageTag");
        addMetadata();
    }

    public MessageTagConst(PathMetadata metadata) {
        super(MessageTag.class, metadata, "public", "MessageTag");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named(MESSAGE_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(tagId, ColumnMetadata.named(TAG_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(value, ColumnMetadata.named(VALUE).withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(9).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(10).ofType(Types.BIGINT).withSize(19));
    }

}

