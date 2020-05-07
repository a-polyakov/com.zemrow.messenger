package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.Tag;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.zemrow.messenger.entity.enums.TagTypeEnum;
import com.zemrow.messenger.entity.enums.TagGroupEnum;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы Tag(Полный перечень тегов) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
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
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * Тег
     */
    public final StringPath tag = createString("tag");

    /**
     * Тип тега для связки наименование тега с логикой
     */
    public final EnumPath<TagTypeEnum> tagType = createEnum("tagType", TagTypeEnum.class);

    /**
     * Описание тега для автокомплита
     */
    public final StringPath description = createString("description");

    /**
     * показывать ли в левом меню
     */
    public final BooleanPath leftMenuShow = createBoolean("leftMenuShow");

    /**
     * Показывать ли в хеадере
     */
    public final BooleanPath headerShow = createBoolean("headerShow");

    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public final EnumPath<TagGroupEnum> tagGroup = createEnum("tagGroup", TagGroupEnum.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    /**
     * Дата обновления записи
     */
    public final NumberPath<Long> updateTime = createNumber("updateTime", Long.class);

    /**
     * Пользователь обновивший запись
     */
    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber("deleteTime", Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber("deletedBy", Long.class);

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
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(tag, ColumnMetadata.named("tag").withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(tagType, ColumnMetadata.named("tagType").withIndex(3).ofType(Types.VARCHAR).withSize(64));
        addMetadata(description, ColumnMetadata.named("description").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(leftMenuShow, ColumnMetadata.named("leftMenuShow").withIndex(5).ofType(Types.BIT).withSize(1));
        addMetadata(headerShow, ColumnMetadata.named("headerShow").withIndex(6).ofType(Types.BIT).withSize(1));
        addMetadata(tagGroup, ColumnMetadata.named("tagGroup").withIndex(7).ofType(Types.VARCHAR).withSize(32));
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(11).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(12).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(13).ofType(Types.BIGINT).withSize(19));
    }

}

