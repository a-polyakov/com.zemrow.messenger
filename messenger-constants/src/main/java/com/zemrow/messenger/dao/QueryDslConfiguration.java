package com.zemrow.messenger.dao;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.types.EnumByNameType;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import com.zemrow.messenger.entity.enums.FileAccessTypeEnum;
import com.zemrow.messenger.entity.enums.FilterPageTypeEnum;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import com.zemrow.messenger.entity.enums.TagTypeEnum;
import com.zemrow.messenger.entity.enums.UserLinkTypeEnum;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;

/**
 * Эталонная конфигурация для QueryDsl. Диалект PostgreSQL, поддержка jsonb, задания соответствие Enum на поля.
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslConfiguration {

    public static final Configuration CUSTOM = new Configuration(PostgreSQLTemplates.DEFAULT);

    static {
        CUSTOM.register(new QueryDslJsonbType());

        CUSTOM.register("ChatToUser", "chatToUserType", new EnumByNameType(ChatToUserTypeEnum.class));
        CUSTOM.register("Chat", "chatType", new EnumByNameType(ChatTypeEnum.class));
        CUSTOM.register("UserEntryPoint", "entryPointType", new EnumByNameType(EntryPointTypeEnum.class));
        CUSTOM.register("FileInfo", "fileAccessType", new EnumByNameType(FileAccessTypeEnum.class));
        CUSTOM.register("UserFilter", "pageType", new EnumByNameType(FilterPageTypeEnum.class));
        CUSTOM.register("MessageToUser", "messageStatus", new EnumByNameType(MessageStatusEnum.class));
        CUSTOM.register("Message", "messageType", new EnumByNameType(MessageTypeEnum.class));
        CUSTOM.register("Tag", "tagGroup", new EnumByNameType(TagGroupEnum.class));
        CUSTOM.register("Tag", "tagType", new EnumByNameType(TagTypeEnum.class));
        CUSTOM.register("UserLink", "userLinkType", new EnumByNameType(UserLinkTypeEnum.class));
        CUSTOM.register("UserStatus", "userStatusType", new EnumByNameType(UserStatusTypeEnum.class));
        CUSTOM.register("UserInfo", "userType", new EnumByNameType(UserTypeEnum.class));
    }
}
