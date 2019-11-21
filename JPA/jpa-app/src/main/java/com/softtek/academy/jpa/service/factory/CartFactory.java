package com.softtek.academy.jpa.service.factory;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CartDto;
import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.domain.model.StatusEntity;

@Component
public class CartFactory implements EntityFactory<CartDto, CartEntity> {

	@Override
	public CartEntity createEntity(CartDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

//    private final Long CART_CREATED = 1100L;
//
//
//    @Override
//    public CartEntity createEntity(CartDto dto) {
//
//        final StatusEntity status = new StatusEntity();
//        status.setId(CART_CREATED);
//
//        final CartEntity cart = new CartEntity();
//        cart.setUserId(dto.getUserId());
//        cart.setLinesAmount(0D);
//        cart.setStatus(status);
//        cart.setCreateUser(dto.getUserId());
//        cart.setCreateDate(new Date());
//
//        return cart;
//    }

}
