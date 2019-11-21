package com.softtek.academy.jpa.service;

import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;

public interface CartService {

    CartEntity createCart(final CartEntity cart) throws InvalidInputException;

	CartEntity getCart(Long id);

}
