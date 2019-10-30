package com.softtek.academy.servlet.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.servlet.dao.StateDao;
import com.softtek.academy.servlet.domain.model.StateEntity;
import com.softtek.academy.servlet.exception.InvalidInputException;

public class StateService {

    private StateDao stateDao;


    public StateService() {
        stateDao = new StateDao();
    }


    public StateEntity getState(final Long id) {
        return stateDao.findOne(id);
    }

    public List<StateEntity> getStates() {
        return stateDao.findAll();
    }

    public StateEntity save(final StateEntity state) throws InvalidInputException {
        if (state.getId() == null || StringUtils.isBlank(state.getDescription())) {
            throw new InvalidInputException("Valid id and description requiered");
        }

        return stateDao.save(state);
    }

}
