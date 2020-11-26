package com.zemrow.messenger.dao;

import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.querydsl.sql.dml.SQLUpdateClause;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.ChatPriority;
import com.zemrow.messenger.entity.constants.ChatPriorityConst;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с приоритетом чата
 * <p>
 * TODO проверить как выполнить выборку чатов отсортированных по приоритету
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatPriorityDao extends AbstractDao<ChatPriority, ChatPriorityConst> {

    @Override
    public ChatPriorityConst getTable() {
        return ChatPriorityConst.ChatPriority;
    }

    /**
     * Добавление записи
     *
     * @param connection   TODO
     * @param session      TODO
     * @param chatPriority Приоритет чата
     */
    @Override
    public void insert(final Connection connection, final SessionStorage session, ChatPriority chatPriority) {
        super.insert(connection, session, chatPriority);
    }

    /**
     * Получить приоритет по идентификатору чата.
     *
     * @param connection TODO
     * @param chatId     Идентификатор чата.
     * @return Приоритет.
     */
    public Long selectPriorityByChatId(final Connection connection, Long chatId) {
        final SQLQuery<Long> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(getTable().priority);
        query.from(getTable());
        query.where(getTable().chatId.eq(chatId));
        final Long result = query.fetchOne();
        return result;
    }


    /**
     * Обновление записи по chatId
     *
     * @param connection   TODO
     * @param session      TODO
     * @param chatPriority Приоритет чата
     */
    private void update(final Connection connection, final SessionStorage session, ChatPriority chatPriority) {
        chatPriority.preUpdate(session);
        final SQLUpdateClause query = new SQLUpdateClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.set(getTable().priority, chatPriority.getPriority());
        query.where(getTable().chatId.eq(chatPriority.getChatId()));
        query.execute();
    }


    /**
     * Удаление записи
     *
     * @param connection TODO
     * @param chatId     Идентификатор чата
     */
    @Deprecated
    public void delete(final Connection connection, Long chatId) {
        final SQLDeleteClause query = new SQLDeleteClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.where(getTable().chatId.eq(chatId));
        query.execute();
    }

    /**
     * Изменить приоритет чата
     *
     * @param connection    TODO
     * @param session       TODO
     * @param currentChatId идентификатор чата который передвигаем
     * @param beforeChatId  идентификатор чаты перед которым нужно расположить
     */
    public void up(final Connection connection, final SessionStorage session, Long currentChatId, Long beforeChatId) {
        final Long currentPriority = selectPriorityByChatId(connection, currentChatId);
        final Long beforePriority = selectPriorityByChatId(connection, beforeChatId);
        //TODO if (currentPriority<beforePriority) {throw new IllegalArgumentException();}
        final SQLUpdateClause query = new SQLUpdateClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.set(getTable().priority, getTable().priority.add(1));
        query.where(getTable().priority.goe(beforePriority), getTable().priority.lt(currentPriority));
        query.execute();
        update(connection, session, new ChatPriority(currentChatId, beforePriority));
    }

    /**
     * Изменить приоритет чата
     *
     * @param connection    TODO
     * @param session       TODO
     * @param currentChatId идентификатор чата который передвигаем
     * @param afterChatId   идентификатор чаты после которого нужно расположить
     */
    public void down(final Connection connection, final SessionStorage session, Long currentChatId, Long afterChatId) {
        final Long currentPriority = selectPriorityByChatId(connection, currentChatId);
        final Long afterPriority = selectPriorityByChatId(connection, afterChatId);
        //TODO if (currentPriority>beforePriority) {throw new IllegalArgumentException();}
        final SQLUpdateClause query = new SQLUpdateClause(connection, QueryDslConfiguration.CUSTOM, getTable());
        query.set(getTable().priority, getTable().priority.add(-1));
        query.where(getTable().priority.gt(currentPriority), getTable().priority.loe(afterPriority));
        query.execute();
        update(connection, session, new ChatPriority(currentChatId, afterPriority));
    }
}
