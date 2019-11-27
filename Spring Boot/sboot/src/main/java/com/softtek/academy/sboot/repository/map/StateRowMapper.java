package com.softtek.academy.sboot.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.sboot.domain.model.StateEntity;

@Component
@Scope("prototype")
public class StateRowMapper implements RowMapper<StateEntity> {

    @Override
    public StateEntity mapRow(final ResultSet rs, int rowNum) throws SQLException {

        StateEntity state = new StateEntity(rs.getLong("id"));
        state.setDescription(rs.getString("description"));

        return state;
    }

}
