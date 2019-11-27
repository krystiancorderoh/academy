package com.softtek.academy.sboot.service.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.softtek.academy.sboot.domain.dto.CartDto;
import com.softtek.academy.sboot.domain.dto.CartLineDto;
import com.softtek.academy.sboot.exception.InvalidInputException;

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
