package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.UserContactStatusEnum;
import com.zemrow.messenger.logic.ChatLogic;
import com.zemrow.messenger.logic.UserContactLogic;
import com.zemrow.messenger.service.transaction.DataBase;
import com.zemrow.messenger.service.transaction.Transaction;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class UserContactService extends AbstractService<UserContactLogic> {
    /**
     * TODO
     */
    private final ChatLogic chatLogic;
    /**
     * TODO
     */
    public UserContactService(DataBase dataBase, UserContactLogic userContactLogic, ChatLogic chatLogic) {
        super(dataBase, userContactLogic);
        this.chatLogic = chatLogic;
    }

    /**
     * Добавить в контакт пользователя
     *
     * @param session TODO
     * @param userId  TODO
     */
    public UserContact insert(SessionStorage session, long userId) throws Exception {
        UserContact result;
        try (Transaction transaction = transaction()) {
            // TODO повторное добавление контакта (если пользователь был заблокирован)
            // если пользователь добавляет ранее заблокированного пользователя
            result=logic.select(transaction.getConnection(), session, userId);
            if (result==null) {
                final Chat chat = chatLogic.insert(transaction.getConnection(), session, ChatTypeEnum.CONTACT, session.getUserId(), userId);
                result = logic.insert(transaction.getConnection(), session, session.getUserId(), userId, chat.getId(), UserContactStatusEnum.ACCEPT);
                logic.insert(transaction.getConnection(), session, userId, session.getUserId(), chat.getId(), UserContactStatusEnum.REQUEST);
            }

            transaction.commit();
            return result;
        }
    }

    //TODO
    /*
     * Cписок контактов пользователя отсортированных по алфавиту
     *
     * @param offset
     * @param limit
     */
//    public void select(int offset, int limit) {

//    }
    // Список избранных контактов пользователя, отсортированных по алфавиту
    // Отметить контакт как избранный
    // Списка контактов пользователя отсортированный по алфавиту, с учетом сохраненного в базе фильтра
}
