package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с участниками чатома
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatToUserDao extends AbstractDao<ChatToUser> {

    public static final String TABLE = "ChatToUser";

    public ChatToUserDao(DataBase dataBase) {
        super(dataBase, ChatToUser.class, IdConstant.FIRST_ID_CHAT_TO_USER, 2);
    }

    /**
     * Получить участника чата по идентификатору.
     *
     * @param id Идентификатор.
     * @return Участник чата.
     */
    @Override
    protected ChatToUser select(SimpleKey id) {
        return super.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void update(SessionStorage session, ChatToUser entity) {
        super.update(session, entity);
    }
}
