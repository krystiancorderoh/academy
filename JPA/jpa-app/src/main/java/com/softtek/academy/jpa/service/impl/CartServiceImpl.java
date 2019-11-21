package com.softtek.academy.jpa.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.jpa.domain.dto.CartDto;
import com.softtek.academy.jpa.domain.dto.CartLineDto;
import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.domain.model.CartLineEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.repository.CartLineRepository;
import com.softtek.academy.jpa.repository.CartRepository;
import com.softtek.academy.jpa.service.CartService;
import com.softtek.academy.jpa.service.factory.EntityFactory;
import com.softtek.academy.jpa.service.validation.ObjectValidator;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

	@Override
	public CartEntity createCart(CartEntity cart) throws InvalidInputException {
		return cartRepository.save(cart);
		
	}

	@Override
	public CartEntity getCart(Long id) {
		
		return cartRepository.findById(id).orElse(null);
	}

//    @Autowired
//    private CartLineRepository cartLineRepository;
//
//    @Autowired
//    private ObjectValidator<CartDto> cartDtoValidator;
//
//    @Autowired
//    private EntityFactory<CartDto, CartEntity> cartFactory;
//
//    @Autowired
//    private EntityFactory<CartLineDto, CartLineEntity> cartLineFactory;


//    @Override
//    public CartEntity createCart(final CartDto cartDto) throws InvalidInputException {
//        cartDtoValidator.validate(cartDto);
//
//        final CartEntity cart = cartRepository.save(cartFactory.createEntity(cartDto));
//
//        Double totalAmount = 0D;
//        for(CartLineDto lineDto : cartDto.getLines()) {
//            final CartLineEntity line = cartLineFactory.createEntity(lineDto);
//            line.setCartId(cart.getId());
//
//            totalAmount += (line.getQuantity() * line.getItem().getUnitPrice());
//
//            cartLineRepository.save(line);
//        }
//        cart.setLinesAmount(totalAmount);
//
//        return cartRepository.update(cart);
//    	return null;
//    }



}
