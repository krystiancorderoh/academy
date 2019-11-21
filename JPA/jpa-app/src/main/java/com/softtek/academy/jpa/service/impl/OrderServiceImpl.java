package com.softtek.academy.jpa.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.academy.jpa.domain.model.OrderEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.repository.OrderRepository;
import com.softtek.academy.jpa.repository.StateRepository;
import com.softtek.academy.jpa.service.OrderService;
//import com.softtek.academy.jpa.service.validation.ObjectValidator;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

//    @Autowired
//    private ObjectValidator<OrderEntity> orderoValidator;


    @Override
	public List<OrderEntity> getOrdersToToday() {
		
    	LocalDateTime actualDay = LocalDateTime.now();
    	return orderRepository.getOrdersToToday(actualDay);
		
	}
    
//    @Override
//    public StateEntity getState(final Long id) {
//        return stateRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<StateEntity> getStates() {
//        return stateRepository.findAll();
//    }
//
//    @Override
//    public StateEntity save(final StateEntity state) throws InvalidInputException {
//        stateValidator.validate(state);
//
//        return stateRepository.save(state);
//    }
//
//    @Override
//    @Transactional
//    public StateEntity update(final StateEntity state) throws InvalidInputException {
//        stateValidator.validate(state);
//
//        return stateRepository.save(state);
//    }
//
//    @Override
//    public Boolean delete(final Long stateId) {
//        stateRepository.deleteById(stateId);
//
//        return true;
//    }

	
}
