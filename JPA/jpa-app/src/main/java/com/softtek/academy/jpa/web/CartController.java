package com.softtek.academy.jpa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jpa.domain.dto.CartDto;
import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.service.CartService;

@RestController
@RequestMapping(path = "/carts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;


    @PostMapping(path = "")
    public CartEntity createCart(@RequestBody CartEntity cart) throws InvalidInputException {
        LOGGER.info("Saving cart: {}", cart);

        return cartService.createCart(cart);
    }
    
    @GetMapping("/{id}")
    public CartEntity getCart(@PathVariable Long id) {
    	return cartService.getCart(id);
    }
    
//    @PostMapping(path = "")
//    public CartEntity createCart(@RequestBody CartDto cartDto) throws InvalidInputException {
//        LOGGER.info("Saving cart: {}", cartDto);
//
//        return cartService.createCart(cartDto);
//    }

}
