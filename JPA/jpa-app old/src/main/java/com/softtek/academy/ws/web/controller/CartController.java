package com.softtek.academy.ws.web.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.ws.domain.model.Cart;
import com.softtek.academy.ws.domain.model.Status;
import com.softtek.academy.ws.domain.model.User;

@CrossOrigin
@RestController
@RequestMapping(value = "/carts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CartController {
	
	@GetMapping("/{id}")
	public Cart getCart(@PathVariable Long id) throws SQLException {
		Cart cart = new Cart();
		cart.setId(id);
		cart.setUser(new User("jorge.gonzalez"));
		cart.setLinesAmount(2389.99);
		cart.setStatus(new Status());
		cart.setCreateDate(LocalDateTime.now());
		return cart;
	}


}
