package com.softtek.academy.sboot.service.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.softtek.academy.sboot.domain.model.StateEntity;
import com.softtek.academy.sboot.exception.InvalidInputException;

@Component
public class StateValidator implements ObjectValidator<StateEntity> {

    @Override
    public void validate(final StateEntity state) throws InvalidInputException {
        if (StringUtils.isBlank(state.getDescription())) {

            throw new InvalidInputException("Valid description requiered");
        }

    }

}
