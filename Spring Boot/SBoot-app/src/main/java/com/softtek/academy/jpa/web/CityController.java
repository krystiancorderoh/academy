package com.softtek.academy.jpa.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.domain.model.CityEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.service.CityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping(params = {"page", "size"})
    public Page<CityEntity> getCities(Pageable pageable) {
        log.info("Getting all cities paged by: {}", pageable);

        return cityService.getPageOfCities(pageable);
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CityEntity saveState(@RequestBody CityDto cityDto) throws InvalidInputException {
        log.info("Saving: {}", cityDto);

        return cityService.save(cityDto);
    }


    @PutMapping(path = "/{id}")
    public CityEntity postEdit(@PathVariable Long id, @RequestBody CityDto cityDto) throws InvalidInputException {
        log.info("Updating city: {} - {}", id, cityDto);

        return cityService.update(cityDto);
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteteState(@PathVariable Long id) throws IOException {
        log.info("Deleting city: {}", id);;

        cityService.delete(id);
    }
}
