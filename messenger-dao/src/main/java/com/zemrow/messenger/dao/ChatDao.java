package com.zemrow.messenger.dao;

import com.querydsl.core.types.NullExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.SQLQuery;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.constants.*;
import com.zemrow.messenger.entity.enums.TagGroupEnum;

import java.sql.Connection;
import java.util.List;

/**
 * DAO (data access object) для работы с чатом(заданием)
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatDao extends AbstractDaoWithId<Chat, ChatConst> {
    @Override
    public ChatConst getTable() {
        return ChatConst.Chat;
    }

    @Override
    public SimpleExpression getKey() {
        return ChatConst.Chat.id;
    }

    /**
     * Получить чат по идентификатору.
     *
     * @param id Идентификатор чата.
     * @return Чат.
     */
    @Override
    protected Chat select(Connection connection, SessionStorage session, long id) {
        return super.select(connection, session, id);
    }

    /**
     * Обновление чат
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    protected void update(final Connection connection, SessionStorage session, Chat entity) {
        super.update(connection, session, entity);
    }

    /**
     * Получить список чатов пользователя отсортированных по последнему сообщению.
     *
     * @param connection TODO
     * @param session    TODO
     * @param offset     TODO
     * @param limit      TODO
     * @return TODO
     */
    public PageNavigationDto<ChatTiledDto> listLast(final Connection connection, SessionStorage session, int offset, int limit) {
        final ChatConst c = new ChatConst("c");
        final ChatToUserConst c2u = new ChatToUserConst("c2u");
        final UserContactConst uc = new UserContactConst("uc");
        final UserInfoConst u2 = new UserInfoConst("u2");
        final NumberingConst n = new NumberingConst("n");
        final ChatToUserLastMessageConst c2ulm = new ChatToUserLastMessageConst("c2ulm");
        final MessageConst m = new MessageConst("m");
        final ChatTagGroupConst executorCtg = new ChatTagGroupConst("executorCtg");
        final MessageTagConst executor = new MessageTagConst("executor");
        final ChatTagGroupConst deadlineCtg = new ChatTagGroupConst("deadlineCtg");
        final MessageTagConst deadline = new MessageTagConst("deadline");

        final SQLQuery<ChatTiledDto> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(
                Projections.constructor(ChatTiledDto.class,
                        c.id, // chatId
                        c.chatType, // chatType
                        uc.id, // userContactId
                        uc.label, // userContactLabel
                        u2.avatarId, // avatarId
                        // TODO Статус пользователя
                        // TODO Чат добавлен в избранное
                        n.prefix.concat(c.orderNumber.stringValue()), // number
                        c.label, // label
                        m.createTime, // lastMessageTime
                        m.text, // lastMessageText
                        executor.value, // executorUserId
                        deadline.value, // deadline
                        NullExpression.DEFAULT, // TODO workNowUserId
                        NullExpression.DEFAULT // unreadMessageCount
//                " (select count(unreadm." + MessageConst.ID + ") " +
//                        "  from " + MessageDao.TABLE + " unreadm, " +
//                        "    " + MessageToUserDao.TABLE + " unreadm2u " +
//                        "  where " +
//                        "    unreadm." + MessageConst.CHAT_ID + "=c." + ChatConst.ID +
//                        "    and unreadm2u." + MessageToUserConst.MESSAGE_ID + " = unreadm." + MessageConst.ID +
//                        "    and unreadm2u." + MessageToUserConst.USER_ID + " = c2u." + ChatToUserConst.ID + ") as unreadMessageCount " +
                )
        );
        // чат
        query.from(c);
        // пользователи в чате
        query.join(c2u).on(c2u.chatId.eq(c.id));
        // чат является контактом
        query.leftJoin(uc).on(uc.chatId.eq(c.id), uc.parentUserId.eq(c2u.userId));
        // собеседник из контакта
        query.leftJoin(u2).on(u2.id.eq(uc.childUserId));
        // возможно чат является заданием, и у него должен быть номер
        query.leftJoin(n).on(n.id.eq(c.numberingId));
        // ссылка на последнее сообщение
        query.leftJoin(c2ulm).on(c2ulm.chatToUserId.eq(c2u.id));
        // последнее сообщение
        query.leftJoin(m).on(m.id.eq(c2ulm.messageId));
        // ссылка на исполнителя
        query.leftJoin(executorCtg).on(executorCtg.chatId.eq(c.id), executorCtg.tagGroup.eq(TagGroupEnum.EXECUTOR));
        // исполнитель
        query.leftJoin(executor).on(executor.id.eq(executorCtg.messageTagId));
        // Плановая дата завершения
        query.leftJoin(deadlineCtg).on(deadlineCtg.chatId.eq(c.id), deadlineCtg.tagGroup.eq(TagGroupEnum.DEADLINE));
        query.leftJoin(deadline).on(deadline.id.eq(deadlineCtg.messageTagId));
        query.where(c2u.userId.eq(session.getUserId()));
        query.orderBy(m.createTime.desc(), c.createTime.desc());
        query.offset(offset);
        query.limit(limit);
        final List<ChatTiledDto> page = query.fetch();

        final PageNavigationDto<ChatTiledDto> result = new PageNavigationDto<>(page, offset, limit, 0L/*TODO*/);
        return result;
    }
}
