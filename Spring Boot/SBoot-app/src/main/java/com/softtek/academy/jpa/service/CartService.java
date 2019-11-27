package com.softtek.academy.jpa.service;

import com.softtek.academy.jpa.domain.dto.CartDto;
import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;

public interface CartService {

    CartEntity createCart(final CartDto cartDto) throws InvalidInputException;

}
