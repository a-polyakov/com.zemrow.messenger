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
     * Получить пользователя по идентификатору.
     *
     * @param connection TODO
     * @param session    TODO
     * @param id         Идентификатор пользователя.
     * @return Пользователь.
     */
    public UserInfo select(final Connection connection, final SessionStorage session, long id) {
        return super.select(connection, session, id);
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

    //TODO
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
    public PageNavigationDto<UserTiledDto> find(final Connection connection, SessionStorage session, String userLike, int offset, int limit) {
        final SQLQuery<UserTiledDto> query = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        query.select(Projections.constructor(UserTiledDto.class, UserInfoConst.UserInfo.id,
                UserInfoConst.UserInfo.avatarId,
                UserInfoConst.UserInfo.name,
                UserContactConst.UserContact.id
        ));
        query.from(UserInfoConst.UserInfo);
        query.leftJoin(UserContactConst.UserContact)
                .on(UserContactConst.UserContact.childUserId.eq(UserInfoConst.UserInfo.id));
        query.where(UserContactConst.UserContact.parentUserId.eq(session.getUserId()),
                UserInfoConst.UserInfo.name.like(userLike));
        query.orderBy(UserInfoConst.UserInfo.name.desc());
        query.offset(offset).limit(limit);
        final List<UserTiledDto> page = query.fetch();

        final SQLQuery<Long> countQuery = new SQLQuery(connection, QueryDslConfiguration.CUSTOM);
        countQuery.select(UserInfoConst.UserInfo.id.count()
        );
        countQuery.from(UserInfoConst.UserInfo);
        countQuery.leftJoin(UserContactConst.UserContact)
                .on(UserContactConst.UserContact.childUserId.eq(UserInfoConst.UserInfo.id));
        countQuery.where(UserContactConst.UserContact.parentUserId.eq(session.getUserId()),
                UserInfoConst.UserInfo.name.like("%" + userLike + "%"));
        long totalSize = countQuery.fetchOne();

        final PageNavigationDto<UserTiledDto> result = new PageNavigationDto<>(page, offset, limit, totalSize);
        result.setPage(page);
        return result;
    }
}