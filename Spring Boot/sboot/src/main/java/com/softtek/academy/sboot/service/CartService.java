package com.softtek.academy.sboot.service;

import com.softtek.academy.sboot.domain.dto.CartDto;
import com.softtek.academy.sboot.domain.model.CartEntity;
import com.softtek.academy.sboot.exception.InvalidInputException;

public interface CartService {

    CartEntity createCart(final CartDto cartDto) throws InvalidInputException;

}
