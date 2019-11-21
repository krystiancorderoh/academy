package com.softtek.academy.ws.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.dao.util.CustomPageable;
import com.softtek.academy.ws.domain.dto.CityDto;
import com.softtek.academy.ws.domain.model.City;

public interface CityDao extends JpaRepository<City, Long>{

//	public List<City> findAll();
//
//	public City findOne(Long cityId) throws SQLException ;
//
//	public City save(CityDto cityDto) throws SQLException ;
//
//	public City update(Long cityId, CityDto cityDto) throws SQLException ;
//
//	public Boolean delete(Long cityId) throws SQLException;
//
//	public Page<City> getPageOfCities(Pageable page) throws SQLException ;
	
	@Query(value="select c from City c where c.state.id=2")
	public Set<City> getCitiesFromBajaCalifornia() throws SQLException ;

}