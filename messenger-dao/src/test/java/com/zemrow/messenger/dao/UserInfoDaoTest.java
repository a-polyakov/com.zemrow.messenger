package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.LocaleConst;
import com.zemrow.messenger.constants.TimeZoneConst;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.enums.UserStatusEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Тест для UserInfoDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserInfoDaoTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(UserInfoDaoTest.class);

    @Test
    public void test() throws Exception {
        final UserInfoDao dao = new UserInfoDao();
        final SessionStorage session = new SessionStorage("testToken", TEST_USER_ID, LocaleConst.EN, TimeZoneConst.MSK);

        UserInfo entity = new UserInfo();
        entity.setId(session.getUserId());
        entity.setName("junitTest");
        entity.setUserType(UserTypeEnum.USER);
        entity.setUserStatus(UserStatusEnum.ONLINE);
        entity.setPublicInfo("{}");
        entity.setLocale(session.getLocale());
        entity.setTimeZone(session.getTimeZone());
        log.debug("Before insert {}", entity);
        dao.insert(connection, session, entity);
        log.debug("After insert {}", entity);

        UserInfo entity2 = dao.select(connection, entity.getId());
        log.debug("Select {}", entity2);
        assertNotNull(entity2);
        assertEquals(entity.getAvatarId(), entity2.getAvatarId());
        assertEquals(entity.getName(), entity2.getName());
        assertEquals(session.getUserId(), entity2.getCreatedBy());
        assertNotNull(entity2.getCreateTime());
        assertEquals(session.getUserId(), entity2.getUpdatedBy());
        assertNotNull(entity2.getUpdateTime());
        assertNull(entity2.getDeletedBy());
        assertNull(entity2.getDeleteTime());

        entity2.setName(entity2.getName() + "1");
        log.debug("Before update {}", entity2);
        dao.update(connection, session, entity2);
        log.debug("After update " + entity2);
        final UserInfo entity3 = dao.select(connection, entity.getId());
        log.debug("Select after update {}", entity3);
        assertNotNull(entity3);
        assertEquals(entity2.getName(), entity3.getName());
        assertNull(entity3.getDeletedBy());
        assertNull(entity3.getDeleteTime());

        dao.markAsDeleted(connection, session, entity.getId());
        final UserInfo entity4 = dao.select(connection, entity.getId());
        log.debug("Select after markAsDeleted {}", entity4);
        assertNotNull(entity4);
        assertEquals(session.getUserId(), entity4.getDeletedBy());
        assertNotNull(entity4.getDeleteTime());

        final Long id = dao.selectIdByName(connection, entity.getName());
        assertNull(id);
        final Long id2 = dao.selectIdByName(connection, entity2.getName());
        assertEquals(entity2.getId(), id2);

        // TODO com.zemrow.messenger.dao.UserInfoDao.find
        // TODO selectNameById
    }
}