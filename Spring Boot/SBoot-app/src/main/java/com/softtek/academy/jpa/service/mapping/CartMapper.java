package com.softtek.academy.jpa.service.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CartDto;
import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.domain.model.StatusEntity;

@Component
public class CartMapper implements EntityMapper<CartDto, CartEntity> {

    private final Long CART_CREATED = 1100L;


    @Override
    public CartEntity mapEntity(CartDto dto) {

        final StatusEntity status = new StatusEntity();
        status.setId(CART_CREATED);

        final CartEntity cart = new CartEntity();
        cart.setUserId(dto.getUserId());
        cart.setLinesAmount(0D);
        cart.setStatus(status);
        cart.setCreateUser(dto.getUserId());
        cart.setCreateDate(LocalDateTime.now());

        return cart;
    }

}
