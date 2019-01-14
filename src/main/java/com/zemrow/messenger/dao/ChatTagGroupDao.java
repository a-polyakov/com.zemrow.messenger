package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatTagGroup;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с груповыми тегами чатома
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatTagGroupDao extends AbstractDao<ChatTagGroup> {

    public static final String TABLE = "ChatTagGroup";

    public ChatTagGroupDao(DataBase dataBase) {
        super(dataBase, ChatTagGroup.class, IdConstant.FIRST_ID_CHAT_TAG_GROUP, 2);
    }

    /**
     * Получить последний тег группы для чата по идентификатору.
     *
     * @param id Идентификатор.
     * @return Последний тег группы.
     */
    @Override
    protected ChatTagGroup select(SimpleKey id) {
        return super.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void update(SessionStorage session, ChatTagGroup entity) {
        super.update(session, entity);
    }
}
