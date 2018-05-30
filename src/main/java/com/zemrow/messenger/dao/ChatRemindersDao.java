package com.zemrow.messenger.dao;

import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateAndDelete;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.ChatReminders;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с напоминаниями
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class ChatRemindersDao extends AbstractDaoCreateAndDelete<ChatReminders> {

    public ChatRemindersDao(Ignite ignite) {
        super(ignite, ChatReminders.class, IdConstant.FIRST_ID_CHAT_REMINDERS, 2);
    }
}
