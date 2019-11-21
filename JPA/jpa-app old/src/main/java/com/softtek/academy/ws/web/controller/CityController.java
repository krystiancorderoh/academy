package com.softtek.academy.ws.web.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.ws.domain.dto.CityDto;
import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.service.CityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping
	public List<City> getCities() throws SQLException {
		return cityService.getCities();
	}
	@GetMapping(path="/bajacalifornia")
	public Collection<City> getCitiesFromBaja() throws SQLException {
		return cityService.getCitiesFromBajaCalifornia();
	}

	@GetMapping(params = { "page", "size" })
	public Page<City> getPageOfCities(Pageable page) throws SQLException {
		log.info(page.getPageNumber() + " " +  page.getPageSize());
		return cityService.getPageOfCities(page);
	}

	@GetMapping("/{cityId}")
	public City getCity(@PathVariable Long cityId) throws SQLException {
		return cityService.getCity(cityId);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public City saveCity(@RequestBody CityDto city) throws SQLException {
		return cityService.save(city);
	}

	@PutMapping("/{cityId}")
	public City updateCity(@PathVariable Long cityId, @RequestBody CityDto city) throws SQLException {
		return cityService.update(cityId, city);
	}

	@DeleteMapping("/{cityId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long cityId) throws SQLException {
		cityService.delete(cityId);
	}

}
