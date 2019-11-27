package com.softtek.academy.sboot.service.validation;

import com.softtek.academy.sboot.exception.InvalidInputException;

public interface ObjectValidator<T> {

    void validate(final T object) throws InvalidInputException;

}
