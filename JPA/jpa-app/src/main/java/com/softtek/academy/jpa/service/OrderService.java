package com.softtek.academy.jpa.service;

import java.util.List;

import com.softtek.academy.jpa.domain.model.OrderEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;

public interface OrderService {
	
	
	List<OrderEntity> getOrdersToToday();

//    StateEntity getState(final Long id);
//
//    List<StateEntity> getStates();
//
//    StateEntity save(final StateEntity state) throws InvalidInputException;
//
//    StateEntity update(final StateEntity state) throws InvalidInputException;
//
//    Boolean delete(final Long stateId);
    
    

}
