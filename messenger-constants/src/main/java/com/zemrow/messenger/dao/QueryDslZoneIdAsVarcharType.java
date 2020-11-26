package com.zemrow.messenger.dao;

import com.querydsl.sql.types.AbstractType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.ZoneId;

/**
 * Конвертирование INT в java.time.ZoneOffset и обратно
 *
 * @author Alexandr Polyakov on 2020.10.30
 */
public class QueryDslZoneIdAsVarcharType extends AbstractType<ZoneId> {

    public static final QueryDslZoneIdAsVarcharType DEFAULT = new QueryDslZoneIdAsVarcharType();

    private QueryDslZoneIdAsVarcharType() {
        super(Types.VARCHAR);
    }

    @Override
    public ZoneId getValue(ResultSet rs, int startIndex) throws SQLException {
        String val = rs.getString(startIndex);
        return rs.wasNull() ? null : ZoneId.of(val);
    }

    @Override
    public Class<ZoneId> getReturnedClass() {
        return ZoneId.class;
    }

    @Override
    public void setValue(PreparedStatement st, int startIndex, ZoneId value)
            throws SQLException {
        st.setString(startIndex, value.getId());
    }
}
