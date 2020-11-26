package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.ChatDao;
import com.zemrow.messenger.dao.ChatPriorityDao;
import com.zemrow.messenger.dao.ChatTreeDao;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.ChatPriority;
import com.zemrow.messenger.entity.ChatTree;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;

import java.sql.Connection;
import java.util.List;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatLogic extends AbstractLogicWithId<ChatDao> {
  /**
   * TODO
   */
  private final ChatToUserLogic chatToUserLogic;
  /**
   * TODO
   */
  private final UserInfoLogic userInfoLogic;
  /**
   * TODO
   */
  private final ChatPriorityDao chatPriorityDao;
  /**
   * TODO
   */
  private final ChatTreeDao chatTreeDao;

  /**
   * TODO
   */
  public ChatLogic(ChatToUserLogic chatToUserLogic,UserInfoLogic userInfoLogic, ChatDao dao, ChatPriorityDao chatPriorityDao, ChatTreeDao chatTreeDao) {
    super(dao);
    this.chatToUserLogic = chatToUserLogic;
    this.userInfoLogic = userInfoLogic;
    this.chatPriorityDao = chatPriorityDao;
    this.chatTreeDao = chatTreeDao;
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
    return dao.listLast(connection, session, offset, limit);
  }

  /**
   * TODO
   *
   * @param connection TODO
   * @param session    TODO
   * @param chatType   TODO
   * @param userIdList TODO
   * @return TODO
   */
  public Chat insert(final Connection connection, SessionStorage session, ChatTypeEnum chatType, long... userIdList) {
    final Chat chat = new Chat();
    chat.setId(nextId());
    chat.setLabel(userInfoLogic.selectJoinNameById(connection, session, userIdList));
    chat.setChatType(chatType);
    dao.insert(connection, session, chat);

    for (long userId : userIdList) {
      chatToUserLogic.insert(connection, session, chat.getId(), userId, ChatToUserTypeEnum.DEFAULT);
    }

    chatPriorityDao.insert(connection, session, new ChatPriority(chat.getId(), null));

    final ChatTree chatTree = new ChatTree();
    chatTree.setParentChatId(chat.getId());
    chatTree.setChildChatId(chat.getId());
    chatTree.setDistance(0);
    chatTreeDao.insert(connection, session, chatTree);

    return chat;
  }

  /**
   * TODO
   * @param connection TODO
   * @param chatId идентификатор чата
   * @return идентификаторы пользователей из чата
   */
  public List<Long> selectUserIdByChatId(Connection connection, Long chatId) {
    return dao.selectUserIdByChatId(connection, chatId);
  }
}
