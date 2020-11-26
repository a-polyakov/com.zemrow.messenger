package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.ChatToUserDao;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import java.sql.Connection;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.12.06
 */
public class ChatToUserLogic extends AbstractLogicWithId<ChatToUserDao> {

  public ChatToUserLogic(ChatToUserDao userContactDao) {
    super(userContactDao);
  }

  /**
   * TODO
   *
   * @param connection     TODO
   * @param session        TODO
   * @param chatId         ID чата
   * @param userId         ID пользователя
   * @param chatToUserType Тип участника: обычный, скрытый только для чтения, скрытый полный доступ
   */
  public void insert(final Connection connection, SessionStorage session, Long chatId, Long userId,
                     ChatToUserTypeEnum chatToUserType) {
    final ChatToUser chatToUser = new ChatToUser();
    chatToUser.setId(nextId());
    chatToUser.setChatId(chatId);
    chatToUser.setUserId(userId);
    chatToUser.setFavorite(false);
    chatToUser.setChatToUserType(chatToUserType);
    chatToUser.setMute(false);
    dao.insert(connection, session, chatToUser);
  }
}
