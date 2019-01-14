package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.logic.ChatLogic;
import com.zemrow.messenger.logic.UserContactLogic;
import com.zemrow.messenger.service.abstracts.AbstractService;
import org.apache.ignite.transactions.Transaction;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class UserContactService extends AbstractService {

    private final ChatLogic chatLogic;
    private final UserContactLogic userContactLogic;

    public UserContactService(ChatLogic chatLogic, UserContactLogic userContactLogic) {
        this.chatLogic = chatLogic;
        this.userContactLogic = userContactLogic;
    }

    /**
     * Добавить в контакт пользователя
     *
     * @param session TODO
     * @param userId  TODO
     */
    public UserContact insert(SessionStorage session, long userId) {
        UserContact result;
        try (Transaction transaction = transaction()) {
            // TODO повторное добавление контакта (если пользователь был заблокирован)

            final Chat chat = chatLogic.insert(session, ChatTypeEnum.CONTACT, session.getUserId(), userId);
            result = userContactLogic.insert(session, session.getUserId(), userId, chat.getId(), true);
            userContactLogic.insert(session, userId, session.getUserId(), chat.getId(), false);

            transaction.commit();
            return result;
        }
    }

    /**
     * Cписок контактов пользователя отсортированных по алфавиту
     *
     * @param offset
     * @param limit
     */
    public void select(int offset, int limit) {
        //TODO
    }
    // TODO
    // Список избранных контактов пользователя, отсортированных по алфавиту
    // Отметить контакткт как избранный
    // Списка контактов пользователя отсортированный по алфавиту, с учетом сохраненного в базе фильтра
}
