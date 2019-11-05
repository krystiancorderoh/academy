package com.softtek.academy.jstl.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.jstl.dao.CityDao;
import com.softtek.academy.jstl.domain.dto.CityDto;
import com.softtek.academy.jstl.domain.model.City;
import com.softtek.academy.jstl.exception.InvalidInputException;

public class CityService {

    private CityDao cityDao;


    public CityService() {
        cityDao = new CityDao();
    }

    public City getCity(final Long id) {
        return cityDao.findOne(id);
    }

    public List<City> getCities() {
        return cityDao.findAll();
    }

    public City save(CityDto cityDto) throws InvalidInputException, SQLException {
        validate(cityDto);

        return cityDao.save(cityDto);
    }

    private void validate(CityDto cityDto) throws InvalidInputException {
        if (StringUtils.isBlank(cityDto.getDescription()) || cityDto.getStateId() == null) {
            throw new InvalidInputException("Valid id, description and stateId requiered");
        }

    }

    public City update(CityDto cityDto) throws InvalidInputException, SQLException {
        validate(cityDto);

        return cityDao.update(cityDto);
    }

    public void delete(final Long cityId) {
        cityDao.delete(cityId);
    }
}
