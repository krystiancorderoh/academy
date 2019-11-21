package com.softtek.academy.ws.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.dao.util.CustomPageable;
import com.softtek.academy.ws.domain.dto.CityDto;
import com.softtek.academy.ws.domain.model.City;

public class CityDaoJDBC {

	private static final String SQL_SELECT = "SELECT city.*, state.id AS 'state_id', state.description AS 'state_description' FROM city JOIN state ON city.state_id = state.id";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private ObjectFactory<RowMapper<City>> rowMapperFactory;
	
	@Autowired
	private ObjectFactory<CustomPageable<City>> cityPageableFactory;

	public List<City> findAll() throws SQLException {
		return jdbcTemplate.query(SQL_SELECT, rowMapperFactory.getObject());
	}

	public City findOne(Long cityId) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource("id", cityId);
		return jdbcTemplate.queryForObject(SQL_SELECT + " WHERE city.id = :id", params, rowMapperFactory.getObject());
	}

	public City save(CityDto cityDto) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("description", cityDto.getDescription());
		params.addValue("state_id", cityDto.getStateId());
		final String sql = "INSERT INTO city(description, state_id) VALUES(:description, :state_id)";
		jdbcTemplate.update(sql, params);
		final String sqlInsert = SQL_SELECT + " WHERE city.description = :description";
		return jdbcTemplate.queryForObject(sqlInsert, params, rowMapperFactory.getObject());
	}

	public City update(Long cityId, CityDto cityDto) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("description", cityDto.getDescription());
		params.addValue("state_id", cityDto.getStateId());
		params.addValue("id", cityId);
		final String sql = "UPDATE city set description = :description, state_id = :state_id WHERE city.id = :id";
		jdbcTemplate.update(sql, params);
		return findOne(cityId);
	}

	public Boolean delete(Long cityId) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource("id", cityId);
		return jdbcTemplate.update("DELETE FROM city WHERE city.id = :id", params) > 0;
	}

	public Page<City> getPageOfCities(Pageable page) throws SQLException {
		CustomPageable<City> pageFactory = cityPageableFactory.getObject();
		return pageFactory.createPage(findAll(), page);
	}

}