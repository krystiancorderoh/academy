package com.softtek.academy.sboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.sboot.domain.dto.CartDto;
import com.softtek.academy.sboot.domain.dto.CartLineDto;
import com.softtek.academy.sboot.domain.model.CartEntity;
import com.softtek.academy.sboot.domain.model.CartLineEntity;
import com.softtek.academy.sboot.exception.InvalidInputException;
import com.softtek.academy.sboot.repository.CartLineRepository;
import com.softtek.academy.sboot.repository.CartRepository;
import com.softtek.academy.sboot.service.mapping.EntityMapper;
import com.softtek.academy.sboot.service.validation.ObjectValidator;
import com.softtek.academy.sboot.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartLineRepository cartLineRepository;

    @Autowired
    private ObjectValidator<CartDto> cartDtoValidator;

    @Autowired
    private EntityMapper<CartDto, CartEntity> cartMapper;

    @Autowired
    private EntityMapper<CartLineDto, CartLineEntity> cartLineMapper;


    @Override
    public CartEntity createCart(CartDto cartDto) throws InvalidInputException {
        cartDtoValidator.validate(cartDto);

        CartEntity cart = cartRepository.save(cartMapper.mapEntity(cartDto));

        Double totalAmount = 0D;
        for(CartLineDto lineDto : cartDto.getLines()) {
            CartLineEntity line = cartLineMapper.mapEntity(lineDto);
            line.setCartId(cart.getId());

            totalAmount += (line.getQuantity() * line.getItem().getUnitPrice());

            cartLineRepository.save(line);
        }
        cart.setLinesAmount(totalAmount);

        return cartRepository.update(cart);
    }



}
