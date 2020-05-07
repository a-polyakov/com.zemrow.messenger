package com.zemrow.messenger.entity.constants;

/**
 * Класс сгенерирован автоматически, для БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataExporter on 2020.05.07
 */
public class TablesConst {

    /**
     * Чат
     */
    public static final ChatConst Chat = ChatConst.Chat;

    /**
     * Приоритет задания
     */
    public static final ChatPriorityConst ChatPriority = ChatPriorityConst.ChatPriority;

    /**
     * Напоминание
     */
    public static final ChatReminderConst ChatReminder = ChatReminderConst.ChatReminder;

    /**
     * Групповые теги чата (для упрощения поиска последнего тега из группы)
     */
    public static final ChatTagGroupConst ChatTagGroup = ChatTagGroupConst.ChatTagGroup;

    /**
     * Пользователи в чате
     */
    public static final ChatToUserConst ChatToUser = ChatToUserConst.ChatToUser;

    /**
     * Последнее сообщение для пользователя в чате
     */
    public static final ChatToUserLastMessageConst ChatToUserLastMessage = ChatToUserLastMessageConst.ChatToUserLastMessage;

    /**
     * Дерево задач
     */
    public static final ChatTreeConst ChatTree = ChatTreeConst.ChatTree;

    /**
     * Отметка пользователя о затраченом времени
     */
    public static final ChatWorkConst ChatWork = ChatWorkConst.ChatWork;

    /**
     * Файл
     */
    public static final FileInfoConst FileInfo = FileInfoConst.FileInfo;

    /**
     * Сообщение
     */
    public static final MessageConst Message = MessageConst.Message;

    /**
     * История сообщения
     */
    public static final MessageLogConst MessageLog = MessageLogConst.MessageLog;

    /**
     * Тег сообщения
     */
    public static final MessageTagConst MessageTag = MessageTagConst.MessageTag;

    /**
     * Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.
     */
    public static final MessageToUserConst MessageToUser = MessageToUserConst.MessageToUser;

    /**
     * Настройка нумирации для компании и типа чата
     */
    public static final NumberingConst Numbering = NumberingConst.Numbering;

    /**
     * Логи вызовов сервисов
     */
    public static final RequestLogConst RequestLog = RequestLogConst.RequestLog;

    /**
     * Полный перечень тегов
     */
    public static final TagConst Tag = TagConst.Tag;

    /**
     * Контакты пользователя
     */
    public static final UserContactConst UserContact = UserContactConst.UserContact;

    /**
     * Способы авторизации пользователя
     */
    public static final UserEntryPointConst UserEntryPoint = UserEntryPointConst.UserEntryPoint;

    /**
     * Пользовательский фильтр
     */
    public static final UserFilterConst UserFilter = UserFilterConst.UserFilter;

    /**
     * Пользователь
     */
    public static final UserInfoConst UserInfo = UserInfoConst.UserInfo;

    /**
     * Организационная структура пользователей
     */
    public static final UserLinkConst UserLink = UserLinkConst.UserLink;

    /**
     * История изменения пользователь
     */
    public static final UserLogConst UserLog = UserLogConst.UserLog;

    /**
     * Сессия пользователя
     */
    public static final UserSessionConst UserSession = UserSessionConst.UserSession;

    /**
     * Неудачные попытки войти в систему
     */
    public static final UserSessionFailConst UserSessionFail = UserSessionFailConst.UserSessionFail;

    /**
     * Справочник статусов пользователя
     */
    public static final UserStatusConst UserStatus = UserStatusConst.UserStatus;

    /**
     * Дерево пользователей
     */
    public static final UserTreeConst UserTree = UserTreeConst.UserTree;

}

