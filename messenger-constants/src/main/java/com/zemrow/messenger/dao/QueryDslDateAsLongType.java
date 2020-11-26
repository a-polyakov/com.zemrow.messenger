package com.zemrow.messenger.dao;

import com.querydsl.sql.types.AbstractType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

/**
 * Конвертирование BIGINT в java.util.Date и обратно
 *
 * @author Alexandr Polyakov on 2020.10.30
 */
public class QueryDslDateAsLongType extends AbstractType<Date> {

    public static final QueryDslDateAsLongType DEFAULT = new QueryDslDateAsLongType();

    private QueryDslDateAsLongType() {
        super(Types.BIGINT);
    }

    @Override
    public Date getValue(ResultSet rs, int startIndex) throws SQLException {
        long val = rs.getLong(startIndex);
        return rs.wasNull() ? null : new Date(val);
    }

    @Override
    public Class<Date> getReturnedClass() {
        return Date.class;
    }

    @Override
    public void setValue(PreparedStatement st, int startIndex, Date value)
            throws SQLException {
        st.setLong(startIndex, value.getTime());
    }
}
