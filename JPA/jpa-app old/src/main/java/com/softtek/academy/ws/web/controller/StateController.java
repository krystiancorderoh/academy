package com.softtek.academy.ws.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.service.StateService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/states", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping
	public List<State> getStates() throws SQLException {
		return stateService.getStates();
	}

	// Si no coincide el nombre se debe usar el name en PathVariable
	@GetMapping("/{id}")
	public State getState(@PathVariable(name = "id") Long stateId) throws SQLException {
		return stateService.getState(stateId);
	}
	
	@GetMapping(params = {"page", "size","description"})
	public Page<State> getPageOfStatesByDescription(Pageable page,@RequestBody String description) throws SQLException {
		log.info(page.getPageNumber() + " " +  page.getPageSize());
		return stateService.findByDescription(page,description);
	}

//	@PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public State saveState(@RequestBody String description) throws SQLException {
//		State state = new State(null, description);
//		return stateService.save(state);
//	}
//
//	@PutMapping(value = "/{stateId}", consumes = MediaType.TEXT_PLAIN_VALUE)
//	public State updateState(@PathVariable Long stateId, @RequestBody String description) throws SQLException {
//		State state = new State(stateId, description);
//		return stateService.save(state);
//	}

//	@DeleteMapping("/{stateId}")
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Long stateId) throws SQLException {
//		stateService.delete(stateId);
//	}

}
