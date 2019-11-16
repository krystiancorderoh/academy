package com.softtek.academy.ws.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.ws.dao.StateDao;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.exception.InvalidInputException;
@Service
public class StateService {
	@Autowired
    private StateDao stateDao;


    public State getState(Long id) throws SQLException {
        return stateDao.findOne(id);
    }

    public List<State> getStates() throws SQLException {
        return stateDao.findAll();
    }

    public State save(String description) throws SQLException {
        validate(description);

        return stateDao.save(description);
    }

    public State update(Long stateId, String description) throws SQLException {
        validate(description);

        return stateDao.update(stateId, description);
    }

    private void validate(String description) throws InvalidInputException {
        if (StringUtils.isBlank(description)) {
            throw new InvalidInputException("Valid description requiered");
        }
    }

    public void delete(final Long stateId) throws SQLException {
        if(!stateDao.delete(stateId)) {
        	throw new InvalidInputException("Invalid stateId: "+ stateId);
        }
    }
}
