package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.Tag;
import com.zemrow.messenger.entity.enums.TagGroupEnum;
import com.zemrow.messenger.entity.enums.TagTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы Tag(Полный перечень тегов) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class TagConst extends com.querydsl.sql.RelationalPathBase<Tag> {

    private static final long serialVersionUID = 2042113523;

    /**
     * Полный перечень тегов
     */
    public static final TagConst Tag = new TagConst("Tag");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * Тег
     */
    public static final String TAG = "tag";

    /**
     * Тип тега для связки наименование тега с логикой
     */
    public static final String TAG_TYPE = "tagType";

    /**
     * Описание тега для автокомплита
     */
    public static final String DESCRIPTION = "description";

    /**
     * Показывать ли в левом меню
     */
    public static final String LEFT_MENU_SHOW = "leftMenuShow";

    /**
     * Показывать ли в заголовке чата
     */
    public static final String HEADER_SHOW = "headerShow";

    /**
     * Группа тегов. Если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public static final String TAG_GROUP = "tagGroup";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Пользователь создавший запись
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * Дата обновления записи
     */
    public static final String UPDATE_TIME = "updateTime";

    /**
     * Пользователь обновивший запись
     */
    public static final String UPDATED_BY = "updatedBy";

    /**
     * Дата удаления записи
     */
    public static final String DELETE_TIME = "deleteTime";

    /**
     * Пользователь удаливший запись
     */
    public static final String DELETED_BY = "deletedBy";

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber(ID, Long.class);

    /**
     * Тег
     */
    public final StringPath tag = createString(TAG);

    /**
     * Тип тега для связки наименование тега с логикой
     */
    public final EnumPath<TagTypeEnum> tagType = createEnum(TAG_TYPE, TagTypeEnum.class);

    /**
     * Описание тега для автокомплита
     */
    public final StringPath description = createString(DESCRIPTION);

    /**
     * Показывать ли в левом меню
     */
    public final BooleanPath leftMenuShow = createBoolean(LEFT_MENU_SHOW);

    /**
     * Показывать ли в заголовке чата
     */
    public final BooleanPath headerShow = createBoolean(HEADER_SHOW);

    /**
     * Группа тегов. Если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public final EnumPath<TagGroupEnum> tagGroup = createEnum(TAG_GROUP, TagGroupEnum.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

    /**
     * Дата обновления записи
     */
    public final NumberPath<Long> updateTime = createNumber(UPDATE_TIME, Long.class);

    /**
     * Пользователь обновивший запись
     */
    public final NumberPath<Long> updatedBy = createNumber(UPDATED_BY, Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber(DELETE_TIME, Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber(DELETED_BY, Long.class);

    public final com.querydsl.sql.PrimaryKey<Tag> tag_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Tag_deletedBy_fk = createForeignKey(deletedBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Tag_createdBy_fk = createForeignKey(createdBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> Tag_updatedBy_fk = createForeignKey(updatedBy, "id");

    public TagConst(String variable) {
        super(Tag.class, forVariable(variable), "public", "Tag");
        addMetadata();
    }

    public TagConst(com.querydsl.core.types.Path<? extends Tag> path) {
        super(path.getType(), path.getMetadata(), "public", "Tag");
        addMetadata();
    }

    public TagConst(PathMetadata metadata) {
        super(Tag.class, metadata, "public", "Tag");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(tag, ColumnMetadata.named(TAG).withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(tagType, ColumnMetadata.named(TAG_TYPE).withIndex(3).ofType(Types.VARCHAR).withSize(64));
        addMetadata(description, ColumnMetadata.named(DESCRIPTION).withIndex(4).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(leftMenuShow, ColumnMetadata.named(LEFT_MENU_SHOW).withIndex(5).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(headerShow, ColumnMetadata.named(HEADER_SHOW).withIndex(6).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(tagGroup, ColumnMetadata.named(TAG_GROUP).withIndex(7).ofType(Types.VARCHAR).withSize(32));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(12).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(13).ofType(Types.BIGINT).withSize(19));
    }

}

