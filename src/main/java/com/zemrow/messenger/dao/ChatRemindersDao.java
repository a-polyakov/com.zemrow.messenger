package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateAndDelete;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatReminders;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с напоминаниями
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatRemindersDao extends AbstractDaoCreateAndDelete<ChatReminders> {

    public ChatRemindersDao(DataBase dataBase) {
        super(dataBase, ChatReminders.class, IdConstant.FIRST_ID_CHAT_REMINDERS, 2);
    }

    /**
     * Получить напоминание по идентификатору.
     *
     * @param id Идентификатор напоминания.
     * @return Напоминание.
     */
    protected ChatReminders select(Long id) {
        return super.select(new SimpleKey(id));
    }

    /**
     * Обновление напоминание.
     *
     * @param session TODO
     * @param entity  Напоминание.
     */
    @Override
    protected void update(SessionStorage session, ChatReminders entity) {
        super.update(session, entity);
    }
}
