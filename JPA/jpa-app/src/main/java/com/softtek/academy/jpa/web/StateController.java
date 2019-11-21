package com.softtek.academy.jpa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jpa.domain.model.StateEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.service.StateService;

@RestController
@RequestMapping(path = "/states", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateController.class);

    @Autowired
    private StateService stateService;


    @GetMapping(path = "")
    public List<StateEntity> getStates() {
        LOGGER.info("Getting states");
        List<StateEntity> states=stateService.getStates();
        LOGGER.info(states.toString());
        for(StateEntity st: states) {
        	LOGGER.info(st.getDescription()+" cities="+st.getCities());	
        }
        
        return states;
    }


    @GetMapping(path = "/{stateId}")
    public StateEntity getState(@PathVariable Long stateId) {
        LOGGER.info("Getting satateId: {}", stateId);

        return stateService.getState(stateId);
    }

//    @GetMapping(path = "/chiapas")
//    public StateEntity getStateChiapas(@PathVariable Long stateId) {
//        LOGGER.info("Getting satateId: {}", stateId);
//
//        return stateService.getStateChiapas();
//    }
    
    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StateEntity save(@RequestBody StateEntity state) throws InvalidInputException {
        LOGGER.info("Saving: {}", state);

        return stateService.save(state);
    }

    @PutMapping(path = "/{stateId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StateEntity update(@PathVariable Long stateId, @RequestBody StateEntity state) throws InvalidInputException {
        LOGGER.info("Updating state: {} - {}", stateId, state);

        return stateService.update(state);
    }

    @DeleteMapping(path = "/{stateId}")
    public void delete(@PathVariable Long stateId) {
        LOGGER.info("Deleting state: {}", stateId);

        stateService.delete(stateId);
    }
}
