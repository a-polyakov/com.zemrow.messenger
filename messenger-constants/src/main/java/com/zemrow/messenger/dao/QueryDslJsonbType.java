package com.zemrow.messenger.dao;

import com.querydsl.sql.types.AbstractType;
import org.postgresql.util.PGobject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Работа QueryDsl c jsonb
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslJsonbType extends AbstractType<String> {

    public QueryDslJsonbType() {
        this(Types.OTHER);
    }

    private QueryDslJsonbType(int type) {
        super(type);
    }

    @Override
    public Class<String> getReturnedClass() {
        return String.class;
    }

    @Override
    public String getValue(ResultSet rs, int startIndex) throws SQLException {
        String result = null;
        Object obj = rs.getObject(startIndex);
        if (obj instanceof PGobject) {
            result = ((PGobject)obj).getValue();
        }
        else if (obj instanceof String) {
            result = (String)obj;
        }
        return result;
    }

    @Override
    public void setValue(PreparedStatement st, int startIndex, String value) throws SQLException {
        if (value == null) {
            st.setObject(startIndex, value);
        } else {
            final PGobject json = new PGobject();
            json.setType("jsonb");
            json.setValue(value);
            st.setObject(startIndex, json);
        }
    }
}