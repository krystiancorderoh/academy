package com.softtek.academy.jpa.service.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.exception.InvalidInputException;

@Component
public class CityValidator implements ObjectValidator<CityDto> {

    @Override
    public void validate(final CityDto dto) throws InvalidInputException {
        if (StringUtils.isBlank(dto.getDescription()) || dto.getStateId() == null) {
            throw new InvalidInputException("Valid description and state requiered");
        }

    }

}
