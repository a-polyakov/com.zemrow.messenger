package com.zemrow.messenger.dao;

import com.querydsl.sql.types.AbstractType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.postgresql.util.PGobject;

/**
 * Работа QueryDsl c jsonb
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslJsonbType extends AbstractType<String> {

    //TODO
    private final boolean asString;

    public QueryDslJsonbType() {
        this(Types.OTHER, true);
    }

    public QueryDslJsonbType(boolean asString) {
        this(Types.OTHER, asString);
    }

    private QueryDslJsonbType(int type, boolean asString) {
        super(type);
        this.asString = asString;
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
        }
        else if (asString) {
            st.setString(startIndex, value);
        }
        else {
            PGobject json = new PGobject();
            json.setType("jsonb");
            json.setValue(value);
            st.setObject(startIndex, json);
        }
    }
}