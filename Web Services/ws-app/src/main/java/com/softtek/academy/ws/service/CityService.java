package com.softtek.academy.ws.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softtek.academy.ws.dao.CityDao;
import com.softtek.academy.ws.domain.dto.CityDto;
import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.exception.InvalidInputException;
@Service
public class CityService {
	@Autowired
    private CityDao cityDao;
	
	

	public Page<City> getCitiesPages(Pageable page) throws SQLException{
		return cityDao.getCitiesPages(page);
	}

    public City getCity(Long id) throws SQLException {
        return cityDao.findOne(id);
    }

    public List<City> getCities() throws SQLException {
        return cityDao.findAll();
    }

    public City save(CityDto cityDto) throws SQLException {
        validate(cityDto);

        return cityDao.save(cityDto);
    }

    private void validate(CityDto cityDto) throws InvalidInputException {
        if (StringUtils.isBlank(cityDto.getDescription()) || cityDto.getStateId() == null) {
            throw new InvalidInputException("Valid id, description and stateId requiered");
        }

    }

    public City update(Long cityId, CityDto cityDto) throws InvalidInputException, SQLException {
        validate(cityDto);

        return cityDao.update(cityId, cityDto);
    }

    public void delete(Long cityId) throws SQLException {
        cityDao.delete(cityId);
    }
}
