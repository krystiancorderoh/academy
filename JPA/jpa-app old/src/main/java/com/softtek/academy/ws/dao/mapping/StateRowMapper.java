package com.softtek.academy.ws.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.ws.domain.model.State;

@Component
@Scope("prototype")
public class StateRowMapper implements RowMapper<State> {

	@Override
	public State mapRow(final ResultSet rs, int rowNum) throws SQLException {
		State state = new State();
		state.setId(rs.getLong("state_id"));
		state.setDescription(rs.getString("state_description"));
		return state;
	}

}
