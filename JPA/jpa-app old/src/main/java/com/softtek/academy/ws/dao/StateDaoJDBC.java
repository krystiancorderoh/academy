package com.softtek.academy.ws.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.exception.NotFoundException;

@Repository
public class StateDaoJDBC {

	private static final String SQL_SELECT = "SELECT * FROM state";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private ObjectFactory<RowMapper<State>> rowMapperFactory;

	public State findOne(Long stateId) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", stateId);
		State state = null;
		try {
			state = jdbcTemplate.queryForObject(SQL_SELECT + " WHERE id = :id", params, rowMapperFactory.getObject());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No data found for stateId: " + stateId);
		}
		return state;
	}

	public List<State> findAll() throws SQLException {
		return jdbcTemplate.query(SQL_SELECT, rowMapperFactory.getObject());
	}

	public State save(final State state) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource("description", state.getDescription());
		final String sql = "INSERT INTO state(description) VALUES(:description)";
		jdbcTemplate.update(sql, params);
		final String sqlInsert = SQL_SELECT + " WHERE description = :description";
		return jdbcTemplate.queryForObject(sqlInsert, params, rowMapperFactory.getObject());
	}

	public State update(final State state) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("description", state.getDescription());
		params.addValue("id", state.getId());
		final String sql = "UPDATE state set description = :description WHERE id = :id";
		jdbcTemplate.update(sql, params);
		return state;
	}

	public boolean delete(Long stateId) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource("id", stateId);
		return jdbcTemplate.update("DELETE FROM state WHERE id = :id", params) > 0;
	}

}