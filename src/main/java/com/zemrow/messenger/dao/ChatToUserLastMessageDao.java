package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatToUserLastMessage;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с последним сообщением в чате
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatToUserLastMessageDao extends AbstractDao<ChatToUserLastMessage> {

    public static final String TABLE = "ChatToUserLastMessage";

    public ChatToUserLastMessageDao(DataBase dataBase) {
        super(dataBase, ChatToUserLastMessage.class, IdConstant.FIRST_ID_CHAT_TO_USER_LAST_MESSAGE, 1);
    }

    /**
     * Получить последнее сообщение участника чата по идентификатору.
     *
     * @param id Идентификатор.
     * @return Последнее сообщение участника чата.
     */
    @Override
    protected ChatToUserLastMessage select(SimpleKey id) {
        return super.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void update(SessionStorage session, ChatToUserLastMessage entity) {
        super.update(session, entity);
    }
}
