package com.softtek.academy.jpa.service.validation;

import com.softtek.academy.jpa.exception.InvalidInputException;

public interface ObjectValidator<T> {

    void validate(final T object) throws InvalidInputException;

}
