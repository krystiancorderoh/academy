package com.softtek.academy.sboot.service;

import java.util.List;

import com.softtek.academy.sboot.domain.model.StateEntity;
import com.softtek.academy.sboot.exception.InvalidInputException;

public interface StateService {

    StateEntity getState(final Long id);

    List<StateEntity> getStates();

    StateEntity save(final StateEntity state) throws InvalidInputException;

    StateEntity update(final StateEntity state) throws InvalidInputException;

    Boolean delete(final Long stateId);

}
