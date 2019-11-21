package com.softtek.academy.ws.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softtek.academy.ws.dao.CityDao;
import com.softtek.academy.ws.domain.dto.CityDto;
import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.exception.InvalidInputException;
import com.softtek.academy.ws.repository.CityRepository;

@Service
public class CityService {

//	@Autowired
//    private CityDao cityDao;
	
	@Autowired
	private CityRepository cityRepository;

    public City getCity(Long id) throws SQLException {
        return cityRepository.findById(id).get();
    }
    
    public Page<City> getPageOfCities(Pageable page) throws SQLException {
//    	return cityDao.getPageOfCities(page);
    	return null;
    }

    public List<City> getCities() throws SQLException {
//        return cityDao.findAll();
        return null;
    }

    public City save(CityDto cityDto) throws SQLException {
        validate(cityDto);

//        return cityDao.save(cityDto);
        return null;
    }

    private void validate(CityDto cityDto) {
        if (StringUtils.isBlank(cityDto.getDescription()) || cityDto.getStateId() == null) {
            throw new InvalidInputException("Valid id, description and stateId requiered");
        }

    }

    public City update(Long cityId, CityDto cityDto) throws SQLException {
//        validate(cityDto);

//        return cityDao.update(cityId, cityDto);
    	return null;
        
    }

    public void delete(Long cityId) throws SQLException {
//    	if(!cityDao.delete(cityId)) {
//    		throw new InvalidInputException("Invalid cityId required");
//    	}
    }
    
    public Collection<City> getCitiesFromBajaCalifornia()throws SQLException{
    	return cityRepository.getCitiesFromBajaCalifornia();
    }
}
