package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.*;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * DAO (data access object) для работы с чатом(заданием)
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatDao extends AbstractDao<Chat> {

    public static final String TABLE = "Chat";

    public ChatDao(DataBase dataBase) {
        super(dataBase, Chat.class, IdConstant.FIRST_ID_CHAT, 2);
    }

    /**
     * Получить чат по идентификатору.
     *
     * @param id Идентификатор чата.
     * @return Чат.
     */
    protected Chat select(Long id) {
        return super.select(new SimpleKey(id));
    }

    /**
     * Обновление чат
     *
     * @param session TODO
     * @param entity  TODO
     */
    @Override
    protected void update(SessionStorage session, Chat entity) {
        super.update(session, entity);
    }


    //TODO DSL
    private static final String selectByUserIdQuery =
            "select c." + ChatConst.ID + ", " + // chatId
                    " c." + ChatConst.CHAT_TYPE + ", " +  // chatType
                    " uc." + UserContactConst.ID + ", " +  // userContactId
                    " uc." + UserContactConst.LABEL + ", " +  // userContactLabel
                    " u2." + UserConst.AVATAR_ID + ", " +// avatarId
                    " CONCAT(n." + NumberingConst.PREFIX + ", c." + ChatConst.ORDER_NUMBER + "), " +// number
                    " c." + ChatConst.LABEL + ", " +// label
                    " m." + MessageConst.CREATE_TIME + ", " +// lastMessageTime
                    " m." + MessageConst.TEXT + ", " +// lastMessageText
                    " executor." + MessageTagConst.VALUE + ", " +// executorUserId
                    " deadline." + MessageTagConst.VALUE + ", " +// deadline
                    // TODO workNowUserId
                    " (select count(unreadm." + MessageConst.ID + ") " +
                    "  from " + MessageDao.TABLE + " unreadm, " +
                    "    " + MessageToUserDao.TABLE + " unreadm2u " +
                    "  where " +
                    "    unreadm." + MessageConst.CHAT_ID + "=c." + ChatConst.ID +
                    "    and unreadm2u." + MessageToUserConst.MESSAGE_ID + " = unreadm." + MessageConst.ID +
                    "    and unreadm2u." + MessageToUserConst.USER_ID + " = c2u." + ChatToUserConst.ID + ") as unreadMessageCount " + // unreadMessageCount
                    // чат
                    "from " + TABLE + " c " +
                    // пользователи в чате
                    "  join " + ChatToUserDao.TABLE + " c2u on c2u." + ChatToUserConst.CHAT_ID + "=c." + ChatConst.ID +
                    // чат является контактом
                    "  left join " + UserContactDao.TABLE + " uc " +
                    "    on uc." + UserContactConst.CHAT_ID + "=c." + ChatConst.ID +
                    "    and uc." + UserContactConst.PARENT_USER_ID + "=c2u." + ChatToUserConst.USER_ID +
                    // собеседник из контакта
                    "  left join " + UserDao.TABLE + " u2 on u2." + UserConst.ID + "=uc." + UserContactConst.CHILD_USER_ID +
                    // возможно чат является заданием, и у него должен быть номер
                    "  left join " + NumberingDao.TABLE + " n on n." + NumberingConst.ID + "=c." + ChatConst.NUMBERING_ID +
                    // последнее сообщение ()
                    "  left join " + ChatToUserLastMessageDao.TABLE + " c2ulm on c2ulm." + ChatToUserLastMessageConst.СHAT_TO_USER_ID + "=c2u." + ChatToUserConst.ID +
                    // последнее сообщение
                    "  left join " + MessageDao.TABLE + " m on m." + MessageConst.ID + "=c2ulm." + ChatToUserLastMessageConst.MESSAGE_ID + " " +
                    // исполнитель
                    "  left join " + ChatTagGroupDao.TABLE + " executorCtg " +
                    "    on executorCtg." + ChatTagGroupConst.CHAT_ID + "=c." + ChatConst.ID + " and executorCtg." + ChatTagGroupConst.TAG_GROUP + "= ? " +
                    "  left join " + MessageTagDao.TABLE + " executor on executor." + MessageTagConst.ID + "=executorCtg." + ChatTagGroupConst.MESSAGE_TAG_ID + " " +
                    // Плановая дата завершения
                    "  left join " + ChatTagGroupDao.TABLE + " deadlineCtg " +
                    "    on deadlineCtg." + ChatTagGroupConst.CHAT_ID + "=c." + ChatConst.ID + " and deadlineCtg." + ChatTagGroupConst.TAG_GROUP + "= ? " +
                    "  left join " + MessageTagDao.TABLE + " deadline on deadline." + MessageTagConst.ID + "=deadlineCtg." + ChatTagGroupConst.MESSAGE_TAG_ID + " " +
                    "where c2u." + ChatToUserConst.USER_ID + " = ? " +
                    "order by m." + MessageConst.CREATE_TIME + " DESC, c." + ChatConst.CREATE_TIME + " DESC";

    /**
     * Получить список чатов пользователя отсортированых по последнему сообщению.
     *
     * @param session TODO
     * @param offset  TODO
     * @param limit   TODO
     * @return TODO
     */
    public PageNavigationDto<ChatTiledDto> listLast(SessionStorage session, int offset, int limit) {
        logger.debug("listLast by userId {}", session.getUserId());
        final PageNavigationDto<ChatTiledDto> result = new PageNavigationDto<>();
        final ArrayList<ChatTiledDto> page = new ArrayList<>();
        result.setPage(page);
        result.setOffset(offset);
        result.setLimit(limit);

        final SqlFieldsQuery query = new SqlFieldsQuery(selectByUserIdQuery);
        query.setArgs(TagGroupEnum.EXECUTOR, TagGroupEnum.DEAD_LINE, session.getUserId());
        try (final FieldsQueryCursor<List<?>> cursor = cache.query(query)) {
            for (Iterator<List<?>> it = cursor.iterator(); it.hasNext(); ) {
                final List row = it.next();
                ChatTiledDto dto = new ChatTiledDto();
                dto.setChatId((Long) row.get(0));
                dto.setChatType((ChatTypeEnum) row.get(1));
                dto.setUserContactId((Long) row.get(2));
                String label = (String) row.get(3);
                dto.setAvatarId((Long) row.get(4));
                dto.setNumber((String) row.get(5));
                if (label == null) {
                    label = (String) row.get(6);
                }
                dto.setLabel(label);
                dto.setLastMessageTime((Long) row.get(7));
                dto.setLastMessageText((String) row.get(8));
                dto.setExecutorUserId((Long) row.get(9));
                dto.setDeadline((Long) row.get(10));
                //TODO
//                dto.setWorkNowUserId((List<Long>) row.get(10));
                dto.setUnreadMessageCount((Long) row.get(11));
                page.add(dto);
            }
        }
        return result;
    }
}
