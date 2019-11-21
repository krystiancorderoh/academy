package com.softtek.academy.jpa.service.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CartDto;
import com.softtek.academy.jpa.domain.dto.CartLineDto;
import com.softtek.academy.jpa.exception.InvalidInputException;

@Component
public class CartDtoValidator implements ObjectValidator<CartDto> {

    @Override
    public void validate(final CartDto dto) throws InvalidInputException {

        if (dto.getUserId() == null) {
            throw new InvalidInputException("User Id requiered");
        }

        List<CartLineDto> linesDto = dto.getLines();
        if (linesDto == null || linesDto.isEmpty()) {
            throw new InvalidInputException("Items list requiered");
        }

    }

}
