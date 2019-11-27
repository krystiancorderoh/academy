package com.softtek.academy.sboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.sboot.domain.dto.CartDto;
import com.softtek.academy.sboot.domain.model.CartEntity;
import com.softtek.academy.sboot.exception.InvalidInputException;
import com.softtek.academy.sboot.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/carts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping(path = "")
    public CartEntity createCart(@RequestBody CartDto cartDto) throws InvalidInputException {
        log.info("Saving cart: {}", cartDto);

        return cartService.createCart(cartDto);
    }

}
