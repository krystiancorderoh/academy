package com.softtek.academy.ws.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.ws.domain.model.State;
@Component
@Scope("prototype")
public class StateRowMapper implements RowMapper<State> {

    @Override
    public State mapRow(final ResultSet rs,int rowNum) throws SQLException {

       return new State(rs.getLong("id"),rs.getString("description"));
    }


}
