package com.zemrow.messenger.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.SQLQuery;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.UserTiledDto;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.constants.UserContactConst;
import com.zemrow.messenger.entity.constants.UserInfoConst;

import java.sql.Connection;
import java.util.List;

/**
 * DAO (data access object) для работы с пользователем
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class UserInfoDao extends AbstractDaoWithId<UserInfo, UserInfoConst> {

    @Override
    public UserInfoConst getTable() {
        return UserInfoConst.UserInfo;
    }

    @Override
    public SimpleExpression getKey() {
        return UserInfoConst.UserInfo.id;
    }

    /**
     * TODO
     *
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    public void insert(Connection connection, SessionStorage session, UserInfo entity) {
        super.insert(connection, session, entity);
    }

    /**
     * Получить пользователя по идентификатору.
     *
     * @param connection TODO
     * @param userId     Идентификатор пользователя.
     * @return Пользователь.
     */
    @Override
    public UserInfo select(final Connection connection, final long userId) {
        return super.select(connection, userId);
    }

    /**
     * Получить имена пользователей по набору идентификаторов
     * @param connection TODO
     * @param session TODO
     * @param userIdList Набор идентификаторов пользователя
     * @return Список имен
     */
    public List<String> selectNameById(Connection connection, SessionStorage session, Long... userIdList) {
        final SQLQuery<String> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(UserInfoConst.UserInfo.name);
        query.from(getTable());
        query.where(UserInfoConst.UserInfo.id.in(userIdList));
        final List<String> result = query.fetch();
        return result;
    }

    /**
     * Получить идентификатор пользователя по его наименованию
     *
     * @param connection TODO
     * @param name       - имя пользователя
     * @return идентификатор пользователя
     */
    public Long selectIdByName(final Connection connection, String name) {
        final SQLQuery<Long> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(UserInfoConst.UserInfo.id);
        query.from(getTable());
        query.where(UserInfoConst.UserInfo.name.eq(name));
        final Long result = query.fetchOne();
        return result;
    }

    /**
     * TODO
     * @param connection TODO
     * @param session    TODO
     * @param entity     TODO
     */
    @Override
    public void update(final Connection connection, SessionStorage session, UserInfo entity) {
        super.update(connection, session, entity);
    }

    /**
     * Найти пользователей.
     *
     * @param connection TODO
     * @param session    TODO
     * @param userLike   TODO
     * @param offset     TODO
     * @param limit      TODO
     * @return TODO
     */
    public PageNavigationDto<UserTiledDto> find(final Connection connection, SessionStorage session, String userLike, long offset, long limit) {
        final SQLQuery<UserTiledDto> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        final UserInfoConst userInfo = UserInfoConst.UserInfo;
        final UserContactConst userContact = UserContactConst.UserContact;
        query.select(Projections.constructor(UserTiledDto.class,
                userInfo.id,
                userInfo.avatarId,
                userInfo.name,
                userContact.id
        ));
        query.from(userInfo);
        query.leftJoin(userContact)
                .on(
                        userContact.parentUserId.eq(session.getUserId()),
                        userContact.childUserId.eq(userInfo.id)
                );
        query.where(
                userInfo.name.lower().like("%" + userLike.toLowerCase() + "%")
        );
        query.orderBy(userInfo.name.desc());
        query.offset(offset).limit(limit);
        final List<UserTiledDto> page = query.fetch();
        long totalSize = query.fetchCount();
        return new PageNavigationDto<>(page, offset, limit, totalSize);
    }
}