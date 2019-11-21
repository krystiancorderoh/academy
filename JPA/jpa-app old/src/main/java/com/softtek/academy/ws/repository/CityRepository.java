package com.softtek.academy.ws.repository;


import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.exception.NotFoundException;


public interface CityRepository extends JpaRepository<City, Long>{

	Page<City> findByDescription(Pageable pageable, String description);
	
	@Query(value="select c from City c where c.state.id=2")
	Collection<City> getCitiesFromBajaCalifornia();
	
	@Query(value="select c from City c inner join c.state e where e.description=:stateName")
	Page<City> findCitiesByStateDescription(Pageable pageable, @Param("stateName") String stateName);
	
//	public State findOne(Long stateId) ;
//
//	public List<State> findAll() throws SQLException ;
//
//	public State save(final State state) throws SQLException ;
//
//	public State update(final State state) throws SQLException ;
//
//	public boolean delete(Long stateId) throws SQLException ;
}