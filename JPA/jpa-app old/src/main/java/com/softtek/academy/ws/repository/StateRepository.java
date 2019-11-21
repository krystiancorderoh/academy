package com.softtek.academy.ws.repository;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.exception.NotFoundException;


public interface StateRepository extends JpaRepository<State, Long>{

	Page<State> findByDescription(Pageable pageable, String description);
	
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