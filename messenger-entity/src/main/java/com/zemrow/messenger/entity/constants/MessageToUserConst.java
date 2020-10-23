package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.MessageToUser;
import com.zemrow.messenger.entity.enums.MessageFeedbackEnum;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы MessageToUser(Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class MessageToUserConst extends com.querydsl.sql.RelationalPathBase<MessageToUser> {

    private static final long serialVersionUID = -82225434;

    /**
     * Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.
     */
    public static final MessageToUserConst MessageToUser = new MessageToUserConst("MessageToUser");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * ID сообщения
     */
    public static final String MESSAGE_ID = "messageId";

    /**
     * ID пользователя
     */
    public static final String USER_ID = "userId";

    /**
     * Статус сообщения для конкретного контакта (просмотрен/не просмотрен и т.д.)
     */
    public static final String MESSAGE_STATUS = "messageStatus";

    /**
     * Реакция на сообщение (like/dislike)
     */
    public static final String MESSAGE_FEEDBACK = "messageFeedback";

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
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber(USER_ID, Long.class);

    /**
     * Статус сообщения для конкретного контакта (просмотрен/не просмотрен и т.д.)
     */
    public final EnumPath<MessageStatusEnum> messageStatus = createEnum(MESSAGE_STATUS, MessageStatusEnum.class);

    /**
     * Реакция на сообщение (like/dislike)
     */
    public final EnumPath<MessageFeedbackEnum> messageFeedback = createEnum(MESSAGE_FEEDBACK, MessageFeedbackEnum.class);

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

    public MessageToUserConst(String variable) {
        super(MessageToUser.class, forVariable(variable), "public", "MessageToUser");
        addMetadata();
    }

    public MessageToUserConst(com.querydsl.core.types.Path<? extends MessageToUser> path) {
        super(path.getType(), path.getMetadata(), "public", "MessageToUser");
        addMetadata();
    }

    public MessageToUserConst(PathMetadata metadata) {
        super(MessageToUser.class, metadata, "public", "MessageToUser");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named(MESSAGE_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageStatus, ColumnMetadata.named(MESSAGE_STATUS).withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(messageFeedback, ColumnMetadata.named(MESSAGE_FEEDBACK).withIndex(5).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

