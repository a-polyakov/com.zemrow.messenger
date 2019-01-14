package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.UserStatusConst;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.UserStatus;
import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;

/**
 * DAO (data access object) для работы со статустм пользователя
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class UserStatusDao extends AbstractDao<UserStatus> {

    public static final String TABLE = "UserStatus";

    public UserStatusDao(DataBase dataBase) {
        super(dataBase, UserStatus.class, IdConstant.FIRST_ID_USER_STATUS, 2);
    }

    private static final String selectIdByTypeQuery = "select " + UserStatusConst.ID + " from " + TABLE + " where " + UserStatusConst.USER_STATUS_TYPE + " = ?";

    /**
     * Проверка наличия статуса
     *
     * @param userStatusId Идентификатор статуса.
     * @return Признак наличия записи.
     */
    public boolean containsById(Long userStatusId) {
        return super.containsById(new SimpleKey(userStatusId));
    }

    /**
     * TODO
     */
    @Override
    protected UserStatus select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, UserStatus entity) {
        super.update(session, entity);
    }

    /**
     * Получить идентификатор статуса по его типу.
     *
     * @param session - TODO
     * @param type    - Тип статуса.
     * @return Идентификатор статуса.
     */
    public Long selectIdByType(SessionStorage session, UserStatusTypeEnum type) {
        logger.debug("selectIdByType({})", type);
        return query(selectIdByTypeQuery, type);
    }
}
