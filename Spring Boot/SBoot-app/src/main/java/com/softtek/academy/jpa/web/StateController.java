package com.softtek.academy.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jpa.domain.model.StateEntity;
import com.softtek.academy.jpa.service.StateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/states", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StateController {

    @Autowired
    private StateService stateService;


    @GetMapping
    public List<StateEntity> getStates() {
        log.info("Getting states");

        return stateService.getStates();
    }


    @GetMapping("/{id}")
    public StateEntity getState(@PathVariable Long id) {
        log.info("Getting satateId: {}", id);

        return stateService.getState(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public StateEntity save(@RequestBody StateEntity state) {
        log.info("Saving: {}", state);

        return stateService.save(state);
    }

    @PutMapping(path = "/{id}")
    public StateEntity update(@PathVariable Long id, @RequestBody StateEntity state) {
        log.info("Updating state: {} - {}", id, state);

        return stateService.update(state);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.info("Deleting state: {}", id);

        stateService.delete(id);
    }
}
