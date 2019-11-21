package com.softtek.academy.ws.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softtek.academy.ws.dao.StateDao;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.exception.InvalidInputException;
import com.softtek.academy.ws.repository.StateRepository;

@Service
public class StateService{
	
//	@Autowired
//    private StateDao stateDao;
	
	@Autowired
	private StateRepository stateRepository;

    public State getState(Long id) throws SQLException {
    	
//        return stateDao.findOne(id);
    	return stateRepository.findById(id).get();
    }

    public List<State> getStates() throws SQLException {
//        return stateDao.findAll();
    	return stateRepository.findAll();
    }

    public State save(State state) throws SQLException {
//        return stateDao.save(state);
    	return stateRepository.save(state);
    }

    public State update(State state) throws SQLException {
//        return stateDao.update(state);
    	return stateRepository.save(state);
    }

    public void delete(final Long stateId) throws SQLException {
//    	if(!stateDao.delete(stateId)) {
//			throw new InvalidInputException("Invalid stateId required");
//		}
    	stateRepository.deleteById(stateId);
    }
    
    public Page<State> findByDescription (Pageable pageable,String description){
    	return stateRepository.findByDescription(pageable,description);
    }
}
