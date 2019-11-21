package com.softtek.academy.ws.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.domain.model.State;

@Repository
public class StateDaoJpa implements StateDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public State findOne(Long stateId) {
		return null;
	}

	@Override
	public List<State> findAll() throws SQLException {
		return entityManager.createQuery("select o from State o", State.class).getResultList();
	}

	@Override
	public State save(State state) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State update(State state) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long stateId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
