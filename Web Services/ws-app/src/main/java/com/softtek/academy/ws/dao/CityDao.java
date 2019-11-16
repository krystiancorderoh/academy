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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.ws.dao.mapping.CityRowMapper;
import com.softtek.academy.ws.dao.util.CustomPageable;
import com.softtek.academy.ws.domain.dto.CityDto;
import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.exception.NotFoundException;

@Repository
public class CityDao {

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
    private ObjectFactory<RowMapper<City>> rowMapperFactory;
	
	@Autowired
	private ObjectFactory<CustomPageable<City>> cityPageableFactory;
	
	private static String SQL_SELECT = "SELECT c.*, s.*, s.description state_description FROM city c JOIN state s ON s.id = c.state_id";

	public City findOne(Long id) throws SQLException {
    	
    	String sql = "SELECT c.*, s.*, s.description state_description FROM city c JOIN state s ON s.id = c.state_id WHERE c.id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        City city = null;
        try {
        	city = jdbcTemplate.queryForObject(sql, params, rowMapperFactory.getObject());
        }catch(EmptyResultDataAccessException e) {
        	throw new NotFoundException("No data found for CityId: " + id);
        }
        return city;
    	
    }
	
    public List<City> findAll() throws SQLException {
    	
    	return jdbcTemplate.query(SQL_SELECT, rowMapperFactory.getObject());
    
    }
    
    public Page<City> getCitiesPages(Pageable page) throws SQLException{
    	CustomPageable<City> pageFactory = cityPageableFactory.getObject();
    	
    	return pageFactory.createPage(findAll(), page);
    }

    public City save(CityDto cityDto) throws SQLException {
    	
    	String sql = "INSERT INTO city(description, state_id) VALUES(:description,:stateId)";
    	MapSqlParameterSource params = new MapSqlParameterSource("description", cityDto.getDescription());
        params.addValue("stateId", cityDto.getStateId());
        jdbcTemplate.update(sql, params);
        return jdbcTemplate.queryForObject("SELECT c.*, s.*, s.description state_description FROM city c "
        								+ "JOIN state s ON s.id = c.state_id WHERE c.description = :description",
        								params, rowMapperFactory.getObject());
    
    }

    public City update(Long cityId, CityDto cityDto) throws SQLException {
    	
    	String sql = "UPDATE city SET description = :description,state_id = :stateId  WHERE id = :cityId";
        MapSqlParameterSource params = new MapSqlParameterSource("description",cityDto.getDescription());
        params.addValue("stateId", cityDto.getStateId());
        params.addValue("cityId", cityId);
        
        jdbcTemplate.update(sql, params);
        
        return findOne(cityId);
    	
    	
    }

    public Boolean delete(Long cityId) throws SQLException {
    	
    	MapSqlParameterSource params = new MapSqlParameterSource("cityId", cityId);
        
        return jdbcTemplate.update("DELETE FROM city WHERE id = :cityId", params) > 0;
    	
       
    }

}