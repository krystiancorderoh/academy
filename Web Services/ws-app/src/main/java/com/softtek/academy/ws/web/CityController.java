package com.softtek.academy.ws.web;

import java.sql.SQLException;
import java.util.List;

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

import com.softtek.academy.ws.domain.dto.CityDto;
import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.service.CityService;

@RestController
@RequestMapping(value = "/cities", 
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping
	public List<City> getCities() throws SQLException{
		return cityService.getCities();
	}
	
	@GetMapping(params= {"page"})
	public Page<City> getCitiesPages(Pageable page) throws SQLException{
		return cityService.getCitiesPages(page);
	}
	
	@GetMapping("/{id}")
	public City getCity(@PathVariable Long id) throws SQLException {
		
		return cityService.getCity(id);
	}
	
	@PostMapping
	@ResponseStatus(code= HttpStatus.CREATED)
	public City saveCity(@RequestBody CityDto cityDto) throws SQLException {
		
		return cityService.save(cityDto);
		
	}
	
	@PutMapping(value="/{id}")
	public City updateState(@PathVariable Long id,@RequestBody CityDto cityDto) throws SQLException {
		return cityService.update(id, cityDto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws SQLException {
		cityService.delete(id);
	}

}
