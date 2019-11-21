package com.softtek.academy.jpa.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.domain.model.CityEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.service.CityService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;


    @GetMapping(path = "/cities")
    public Page<CityEntity> getCities(final Pageable pageable) {
        LOGGER.info("Getting all cities paged by: {}", pageable);

        return cityService.getPageOfCities(pageable);
    }


    @GetMapping(path = "/cities/aguascalientes")
    public Page<CityEntity> getAguascalientesCities(final Pageable pageable) {
        LOGGER.info("Getting all aguascalientes cities paged by: {}", pageable);

        return cityService.getPageOfAguascalientesCities(pageable);
    }
    
    @GetMapping(path = "/cities/bajacalifornia")
    public Page<CityEntity> getBajaCaliforniaCities(final Pageable pageable) {
        LOGGER.info("Getting all bajacalifornia cities paged by: {}", pageable);

        return cityService.getPageOfBajaCaliforniaCities(pageable);
    }

    @PostMapping(path = "/cities", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CityEntity saveState(@RequestBody CityDto cityDto) throws InvalidInputException {
        LOGGER.info("Saving: {}", cityDto);

        return cityService.save(cityDto);
    }


    @PutMapping(path = "/{cityId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CityEntity postEdit(@PathVariable Long cityId, @RequestBody CityDto cityDto) throws InvalidInputException {
        LOGGER.info("Updating city: {} - {}", cityId, cityDto);

        return cityService.update(cityDto);
    }


    @DeleteMapping(path = "/states/{stateId}/cities/{cityId}")
    public void deleteteState(@PathVariable Long stateId, @PathVariable Long cityId) throws IOException {

        LOGGER.info("Deleting city: {}", cityId);;

        cityService.delete(cityId);
    }
}
