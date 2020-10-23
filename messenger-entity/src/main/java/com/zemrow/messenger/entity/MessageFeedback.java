package com.zemrow.messenger.entity;

/**
 * Класс сгенерирован автоматически, для таблицы MessageFeedback(Итоговый голос по сообщению.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class MessageFeedback extends AbstractEntity {

    /**
     * ID сообщения
     */
    private Long messageId;

    /**
     * Итоговый голос по сообщению.
     */
    private Integer feedback;

    /**
     * Создать Итоговый голос по сообщению.
     */
    public MessageFeedback() {
    }

    /**
     * Создать Итоговый голос по сообщению.
     * @param messageId ID сообщения
     * @param feedback Итоговый голос по сообщению.
     */
    public MessageFeedback(Long messageId, Integer feedback) {
        this.messageId = messageId;
        this.feedback = feedback;
    }

    /**
     * Получение id сообщения
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * Установить id сообщения
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * Получение итоговый голос по сообщению.
     */
    public Integer getFeedback() {
        return feedback;
    }

    /**
     * Установить итоговый голос по сообщению.
     */
    public void setFeedback(Integer feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.MessageFeedback\"");
        if (messageId != null) {
            result.append(", messageId = \"").append(messageId).append('"');
        }
        if (feedback != null) {
            result.append(", feedback = \"").append(feedback).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

