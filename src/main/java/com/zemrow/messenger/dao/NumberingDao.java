package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.Numbering;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с нумирацией заданий
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class NumberingDao extends AbstractDao<Numbering> {

    public NumberingDao(Ignite ignite) {
        super(ignite, Numbering.class, 2);
    }
}
