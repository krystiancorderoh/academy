package com.softtek.academy.jsp.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.jsp.dao.StateDao;
import com.softtek.academy.jsp.domain.model.StateEntity;
import com.softtek.academy.jsp.exception.InvalidInputException;

public class StateService {

    private StateDao stateRepository;


    public StateService() {
        stateRepository = new StateDao();
    }

    public StateEntity getState(final Long id) {
        return stateRepository.findOne(id);
    }

    public List<StateEntity> getStates() {
        return stateRepository.findAll();
    }

    public StateEntity save(final StateEntity state) throws InvalidInputException {
        validate(state);

        return stateRepository.save(state);
    }

    public StateEntity update(final StateEntity state) throws InvalidInputException {
        validate(state);

        return stateRepository.update(state);
    }

    private void validate(StateEntity state) throws InvalidInputException {
        if (state.getId() == null || StringUtils.isBlank(state.getDescription())) {
            throw new InvalidInputException("Valid id and description requiered");
        }
    }

}
