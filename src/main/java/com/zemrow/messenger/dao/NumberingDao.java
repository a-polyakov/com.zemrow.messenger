package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.Numbering;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с нумирацией заданий
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class NumberingDao extends AbstractDao<Numbering> {

    public static final String TABLE = "Numbering";

    public NumberingDao(DataBase dataBase) {
        super(dataBase, Numbering.class, IdConstant.FIRST_ID_NUMBERING, 2);
    }

    /**
     * TODO
     */
    @Override
    protected Numbering select(SimpleKey id) {
        return super.select(id);
    }

    //TODO
    @Override
    protected void update(SessionStorage session, Numbering entity) {
        super.update(session, entity);
    }
}
