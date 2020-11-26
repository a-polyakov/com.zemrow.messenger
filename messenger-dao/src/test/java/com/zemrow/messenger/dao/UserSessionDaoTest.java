package com.zemrow.messenger.dao;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.UserSession;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Тест для UserSessionDao
 *
 * @author Alexandr Polyakov on 2018.04.16
 */
public class UserSessionDaoTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(UserSessionDaoTest.class);

    @Test
    public void test() throws Exception {
        final UserSessionDao dao = new UserSessionDao();

        final SessionStorage session = getSession();
        final UserEntryPointDao userEntryPointDao = new UserEntryPointDao();
        final UserEntryPoint userEntryPoint = new UserEntryPoint(
                userEntryPointDao.nextId(),
                session.getUserId(),
                true,
                EntryPointTypeEnum.LOGIN_PASSWORD,
                "login",
                "password",
                null,
                null,
                null,
                null,
                null,
                null
        );
        userEntryPointDao.insert(connection, session, userEntryPoint);
        final UserSession entity = new UserSession();
        entity.setToken(dao.nextId());
        entity.setUserEntryPointId(userEntryPoint.getId());
        log.debug("Before insert {}", entity);
        dao.insert(connection, session, entity);
        log.debug("After insert {}", entity);

        final UserSession entity2 = dao.select(connection, entity.getToken());
        log.debug("Select {}", entity2);
        assertNotNull(entity2);
        assertEquals(entity.getUserEntryPointId(), entity2.getUserEntryPointId());
        assertEquals(entity.getToken(), entity2.getToken());
        assertNotNull(entity2.getCreateTime());
        assertNull(entity2.getDeletedBy());
        assertNull(entity2.getDeleteTime());

        dao.markAsDeleted(connection, session, entity.getToken());
        final UserSession entity3 = dao.select(connection, entity.getToken());
        log.debug("Select after markAsDeleted {}", entity3);
        assertNotNull(entity3);
        assertNotNull(entity3.getDeleteTime());
    }
}