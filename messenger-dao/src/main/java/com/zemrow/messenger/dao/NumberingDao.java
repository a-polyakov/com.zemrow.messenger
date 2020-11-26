package com.zemrow.messenger.dao;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.Numbering;
import com.zemrow.messenger.entity.constants.NumberingConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

/**
 * DAO (data access object) для работы с нумерацией заданий
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class NumberingDao extends AbstractDaoWithId<Numbering, NumberingConst> {

    private static final Logger log = LogManager.getLogger(NumberingDao.class);

    @Override
    public NumberingConst getTable() {
        return NumberingConst.Numbering;
    }

    @Override
    public SimpleExpression getKey() {
        return NumberingConst.Numbering.id;
    }

    /**
     * TODO
     */
    @Override
    protected Numbering select(final Connection connection, long id) {
        return super.select(connection, id);
    }

    //TODO
    @Override
    protected void update(final Connection connection, SessionStorage session, Numbering entity) {
        super.update(connection, session, entity);
    }
}
