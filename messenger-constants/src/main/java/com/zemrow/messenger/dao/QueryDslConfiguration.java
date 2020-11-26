package com.zemrow.messenger.dao;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.types.EnumByNameType;
import com.querydsl.sql.types.LocaleType;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;
import com.zemrow.messenger.entity.enums.FilterPageTypeEnum;
import com.zemrow.messenger.entity.enums.MessageFeedbackEnum;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import com.zemrow.messenger.entity.enums.TagTypeEnum;
import com.zemrow.messenger.entity.enums.UserContactStatusEnum;
import com.zemrow.messenger.entity.enums.UserLinkTypeEnum;
import com.zemrow.messenger.entity.enums.UserStatusEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;

/**
 * Эталонная конфигурация для QueryDsl. Диалект PostgreSQL, поддержка jsonb, задания соответствие Enum на поля.
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslConfiguration {

    public static final Configuration CUSTOM = new Configuration(new PostgreSQLTemplates('\\', true) {
        {
            // По умолчанию в запрос не включается имя схемы, исправляем
            setPrintSchema(true);
        }
    });

    static {
        CUSTOM.register("Chat", "chatType", new EnumByNameType(ChatTypeEnum.class));
        CUSTOM.register("ChatTagGroup", "tagGroup", new EnumByNameType(TagGroupEnum.class));
        CUSTOM.register("ChatToUser", "chatToUserType", new EnumByNameType(ChatToUserTypeEnum.class));
        CUSTOM.register("FileInfo", "fileAccessType", new EnumByNameType(FileAccessTypeEnum.class));
        CUSTOM.register("MessageToUser", "messageFeedback", new EnumByNameType(MessageFeedbackEnum.class));
        CUSTOM.register("MessageToUser", "messageStatus", new EnumByNameType(MessageStatusEnum.class));
        CUSTOM.register("Message", "messageType", new EnumByNameType(MessageTypeEnum.class));
        CUSTOM.register("Tag", "tagGroup", new EnumByNameType(TagGroupEnum.class));
        CUSTOM.register("Tag", "tagType", new EnumByNameType(TagTypeEnum.class));
        CUSTOM.register("UserContact", "userContactStatus", new EnumByNameType(UserContactStatusEnum.class));
        CUSTOM.register("UserEntryPoint", "entryPointType", new EnumByNameType(EntryPointTypeEnum.class));
        CUSTOM.register("UserFilter", "pageType", new EnumByNameType(FilterPageTypeEnum.class));
        CUSTOM.register("UserInfo", "locale", new LocaleType());
        CUSTOM.register("UserInfo", "timeZone", QueryDslZoneIdAsVarcharType.DEFAULT);
        CUSTOM.register("UserInfo", "publicInfo", new QueryDslJsonbType());
        CUSTOM.register("UserInfo", "userStatus", new EnumByNameType(UserStatusEnum.class));
        CUSTOM.register("UserInfo", "userType", new EnumByNameType(UserTypeEnum.class));
        CUSTOM.register("UserLink", "userLinkType", new EnumByNameType(UserLinkTypeEnum.class));
    }
}
