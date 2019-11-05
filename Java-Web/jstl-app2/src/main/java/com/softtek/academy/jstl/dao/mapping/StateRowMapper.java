package com.softtek.academy.jstl.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.softtek.academy.jstl.domain.model.State;

public class StateRowMapper implements RowMapper<State> {

    @Override
    public State mapRow(final ResultSet rs) throws SQLException {

        State state = new State(rs.getLong("id"));
        state.setDescription(rs.getString("description"));

        return state;
    }

}
