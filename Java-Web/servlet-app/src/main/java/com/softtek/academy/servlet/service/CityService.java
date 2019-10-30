package com.softtek.academy.servlet.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.servlet.dao.CityDao;
import com.softtek.academy.servlet.domain.model.CityEntity;
import com.softtek.academy.servlet.exception.InvalidInputException;

public class CityService {
	
	private CityDao cityDao;


    public CityService() {
        cityDao = new CityDao();
    }

    public CityEntity getCity(final Long id) {
        return cityDao.findOne(id);
    }

    public List<CityEntity> getCities() {
        return cityDao.findAll();
    }

    public CityEntity save(final CityEntity city) throws InvalidInputException {
        if (city.getId() == null || StringUtils.isBlank(city.getDescription())) {
            throw new InvalidInputException("Valid id and description requiered");
        }

        return cityDao.save(city);
    }


}
