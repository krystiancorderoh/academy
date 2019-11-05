package com.softtek.academy.jstl.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.jstl.dao.StateDao;
import com.softtek.academy.jstl.domain.model.State;
import com.softtek.academy.jstl.exception.InvalidInputException;

public class StateService {

    private StateDao stateDao;


    public StateService() {
        stateDao = new StateDao();
    }

    public State getState(Long id) throws SQLException {
        return stateDao.findOne(id);
    }

    public List<State> getStates() throws SQLException {
        return stateDao.findAll();
    }

    public State save(String description) throws InvalidInputException, SQLException {
        validate(description);

        return stateDao.save(description);
    }

    public State update(Long stateId, String description) throws InvalidInputException, SQLException {
        validate(description);

        return stateDao.update(stateId, description);
    }

    private void validate(String description) throws InvalidInputException {
        if (StringUtils.isBlank(description)) {
            throw new InvalidInputException("Valid description requiered");
        }
    }

    public Boolean delete(final Long stateId) throws SQLException {
        return stateDao.delete(stateId);
    }
}
