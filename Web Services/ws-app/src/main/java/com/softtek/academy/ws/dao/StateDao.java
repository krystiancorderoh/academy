package com.softtek.academy.ws.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.dao.mapping.StateRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.exception.InvalidInputException;
import com.softtek.academy.ws.exception.NotFoundException;

@Repository
public class StateDao {

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
    private ObjectFactory<RowMapper<State>> rowMapperFactory;

    

    public State findOne(Long id) {
        String sql = "SELECT * FROM state WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        State state = null;
        try {
        	state = jdbcTemplate.queryForObject(sql, params, rowMapperFactory.getObject());
        }catch(EmptyResultDataAccessException e) {
        	throw new NotFoundException("No data found for StateId: " + id);
        }
        return state;
        
    }

    public List<State> findAll() throws SQLException {

        return jdbcTemplate.query("SELECT * FROM state", rowMapperFactory.getObject());
        
    }

    public State save(String description) throws SQLException {
    	
    	String sql = "INSERT INTO state(description) VALUES(:description)";
    	MapSqlParameterSource params = new MapSqlParameterSource("description", description);
        
        jdbcTemplate.update(sql, params);
        return jdbcTemplate.queryForObject("Select * FROM State WHERE description = :description", params, rowMapperFactory.getObject());
    }

    public State update(Long stateId, String description) throws SQLException {
        
        String sql = "UPDATE state SET description = :description WHERE id = :stateId";
        MapSqlParameterSource params = new MapSqlParameterSource("description", description);
        params.addValue("stateId", stateId);
        
        jdbcTemplate.update(sql, params);
        
        return findOne(stateId);
        
   }

    public boolean delete(Long stateId) throws SQLException {
        
        MapSqlParameterSource params = new MapSqlParameterSource("stateId", stateId);
        
        return jdbcTemplate.update("DELETE FROM state WHERE id = :stateId", params) > 0;
    }

}