package com.softtek.academy.ws.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.exception.InvalidInputException;
import com.softtek.academy.ws.service.StateService;
@RestController
@RequestMapping(value = "/states", 
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StateController {
	@Autowired
	private StateService stateService;
	
	
	@GetMapping
	public List<State> getStates() throws SQLException{
		
		return stateService.getStates();
		
	}
	@GetMapping("/{id}")
	public State getState(@PathVariable Long id) throws SQLException {
//		try {
			return stateService.getState(id);
//		}catch(Exception e){
//			return new ErrorResponse("200",e.getMessage());
//		}
		
	}
	
	@PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public State saveState(@RequestBody String description) throws SQLException {
		
		return stateService.save(description);
		
	}
	
	@PutMapping(value="/{id}",consumes = MediaType.TEXT_PLAIN_VALUE)
	public State updateState(@PathVariable Long id,@RequestBody String description) throws SQLException {
		return stateService.update(id, description);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws SQLException {
		stateService.delete(id);
	}

}
