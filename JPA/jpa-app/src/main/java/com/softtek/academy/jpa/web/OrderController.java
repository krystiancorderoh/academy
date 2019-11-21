package com.softtek.academy.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jpa.domain.model.OrderEntity;
import com.softtek.academy.jpa.service.OrderService;

@RestController
@RequestMapping(path = "/sales", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderController {
	
	@Autowired
    private OrderService orderService;
	
	@GetMapping
	public List<OrderEntity> getOrdersToToday() {
        
        return orderService.getOrdersToToday();
    }
}
