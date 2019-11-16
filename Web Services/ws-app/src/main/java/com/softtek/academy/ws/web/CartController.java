package com.softtek.academy.ws.web;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.ws.domain.dto.ErrorResponse;
import com.softtek.academy.ws.domain.model.Cart;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.domain.model.Status;
import com.softtek.academy.ws.domain.model.User;
import com.softtek.academy.ws.exception.InvalidInputException;
import com.softtek.academy.ws.service.StateService;
@RestController
@RequestMapping(value = "/carts", 
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CartController {
	
	
	@GetMapping("/{id}")
	public Cart getCart(@PathVariable Long id) throws SQLException{
		Cart cart = new Cart();
		cart.setId(id);
		cart.setUser(new User("krystian.cordero"));
		cart.setStatus(new Status());
		cart.setCreateUser("krystian.cordero");
		cart.setCreateDate(LocalDateTime.now());
		
		return cart;
		
	}
//	@GetMapping("/{id}")
//	public State getState(@PathVariable Long id) throws SQLException {
////		try {
//			return stateService.getState(id);
////		}catch(Exception e){
////			return new ErrorResponse("200",e.getMessage());
////		}
//		
//	}


}
