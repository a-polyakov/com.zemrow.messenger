package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.MessageFeedback;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы MessageFeedback(Итоговый голос по сообщению.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class MessageFeedbackConst extends com.querydsl.sql.RelationalPathBase<MessageFeedback> {

    private static final long serialVersionUID = -179762811;

    /**
     * Итоговый голос по сообщению.
     */
    public static final MessageFeedbackConst MessageFeedback = new MessageFeedbackConst("MessageFeedback");

    /**
     * ID сообщения
     */
    public static final String MESSAGE_ID = "messageId";

    /**
     * Итоговый голос по сообщению.
     */
    public static final String FEEDBACK = "feedback";

    /**
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber(MESSAGE_ID, Long.class);

    /**
     * Итоговый голос по сообщению.
     */
    public final NumberPath<Integer> feedback = createNumber(FEEDBACK, Integer.class);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Message> MessageFeedback_messageId_fk = createForeignKey(messageId, "id");

    public MessageFeedbackConst(String variable) {
        super(MessageFeedback.class, forVariable(variable), "public", "MessageFeedback");
        addMetadata();
    }

    public MessageFeedbackConst(com.querydsl.core.types.Path<? extends MessageFeedback> path) {
        super(path.getType(), path.getMetadata(), "public", "MessageFeedback");
        addMetadata();
    }

    public MessageFeedbackConst(PathMetadata metadata) {
        super(MessageFeedback.class, metadata, "public", "MessageFeedback");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(messageId, ColumnMetadata.named(MESSAGE_ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(feedback, ColumnMetadata.named(FEEDBACK).withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

