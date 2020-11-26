package com.zemrow.messenger.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.SQLExpressions;
import com.querydsl.sql.SQLQuery;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.constants.ChatConst;
import com.zemrow.messenger.entity.constants.ChatTagGroupConst;
import com.zemrow.messenger.entity.constants.ChatToUserConst;
import com.zemrow.messenger.entity.constants.ChatToUserLastMessageConst;
import com.zemrow.messenger.entity.constants.MessageConst;
import com.zemrow.messenger.entity.constants.MessageTagConst;
import com.zemrow.messenger.entity.constants.MessageToUserConst;
import com.zemrow.messenger.entity.constants.NumberingConst;
import com.zemrow.messenger.entity.constants.UserContactConst;
import com.zemrow.messenger.entity.constants.UserInfoConst;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * DAO (data access object) для работы с чатом(заданием)
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatDao extends AbstractDaoWithId<Chat, ChatConst> {

    private static final Logger log = LogManager.getLogger(ChatDao.class);

    @Override
    public ChatConst getTable() {
        return ChatConst.Chat;
    }

    @Override
    public SimpleExpression getKey() {
        return ChatConst.Chat.id;
    }

    /**
     * Добавление записи
     *
     * @param connection TODO
     * @param session    TODO
     * @param chat       Чат
     */
    @Override
    public void insert(final Connection connection, final SessionStorage session, Chat chat) {
        super.insert(connection, session, chat);
    }

    /**
     * Получить чат по идентификатору.
     *
     * @param connection TODO
     * @param id         Идентификатор чата.
     * @return Чат.
     */
    @Override
    protected Chat select(Connection connection, long id) {
        return super.select(connection, id);
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
    public PageNavigationDto<ChatTiledDto> listLast(final Connection connection, SessionStorage session, long offset, long limit) {
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
        final MessageConst unreadm = new MessageConst("unreadm");
        final MessageToUserConst unreadm2u = new MessageToUserConst("unreadm2u");

        final SQLQuery<ChatTiledDto> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);

        // TODO Статус пользователя
        // TODO Чат добавлен в избранное
        // TODO workNowUserId
        query.select(
                Projections.constructor(ChatTiledDto.class,
                        new Class[]{
                                Long.class,
                                String.class, // ChatTypeEnum
                                Long.class,
                                String.class,
                                Long.class,
                                String.class,
                                String.class,
                                Long.class,
                                String.class,
                                Long.class,
                                Long.class,
                                Long.class
                        },
                        c.id.as("chatId"),
                        c.chatType.as("chatType"),
                        uc.id.as("userContactId"),
                        uc.label.as("userContactLabel"),
                        u2.avatarId.as("avatarId"),
                        n.prefix.concat(c.orderNumber.stringValue()).as("number"),
                        c.label.as("label"),
                        m.createTime.as("lastMessageTime"),
                        m.text.as("lastMessageText"),
                        executor.value.castToNum(Long.class).as("executorUserId"),
                        deadline.value.castToNum(Long.class).as("deadline"),
                        SQLExpressions
                                .select(unreadm.id.count())
                                .from(unreadm, unreadm2u)
                                .where(unreadm.chatId.eq(c.id),
                                        unreadm2u.messageId.eq(unreadm.id),
                                        unreadm2u.userId.eq(c2u.userId)
                                ).as("unreadMessageCount")
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
        query.where(
                c2u.userId.eq(session.getUserId()),
                c.deleteTime.isNull() // чат не должен быть удален
                // TODO контакт был создан мной или принят
        );
        query.orderBy(m.createTime.desc(), c.createTime.desc());
        query.offset(offset);
        query.limit(limit);
        log.debug(query);
        final List<ChatTiledDto> page = query.fetch();
        final long totalSize = query.fetchCount();
        final PageNavigationDto<ChatTiledDto> result = new PageNavigationDto(page, offset, limit, totalSize);
        return result;
    }

    /**
     * TODO
     * @param connection TODO
     * @param chatId идентификатор чата
     * @return идентификаторы пользователей из чата
     */
    public List<Long> selectUserIdByChatId(Connection connection, Long chatId) {
        final SQLQuery<Long> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(ChatToUserConst.ChatToUser.userId);
        query.from(ChatToUserConst.ChatToUser);
        query.where(ChatToUserConst.ChatToUser.chatId.eq(chatId));
        final List<Long> result = query.fetch();
        return result;
    }
}
