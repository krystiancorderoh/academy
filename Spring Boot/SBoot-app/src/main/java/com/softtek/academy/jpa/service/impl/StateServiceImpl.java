package com.softtek.academy.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.academy.jpa.domain.model.StateEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.repository.StateRepository;
import com.softtek.academy.jpa.service.StateService;
import com.softtek.academy.jpa.service.validation.ObjectValidator;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ObjectValidator<StateEntity> stateValidator;


    @Override
    public StateEntity getState(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    @Override
    public List<StateEntity> getStates() {
        return stateRepository.findAll();
    }

    @Override
    public StateEntity save(StateEntity state) throws InvalidInputException {
        stateValidator.validate(state);

        return stateRepository.save(state);
    }

    @Override
    @Transactional
    public StateEntity update(StateEntity state) throws InvalidInputException {
        stateValidator.validate(state);

        return stateRepository.save(state);
    }

    @Override
    public Boolean delete(Long stateId) {
        stateRepository.deleteById(stateId);

        return true;
    }
}
