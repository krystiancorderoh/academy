package com.softtek.academy.jsp.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.jsp.dao.CityDao;
import com.softtek.academy.jsp.domain.dto.CityDto;
import com.softtek.academy.jsp.domain.model.CityEntity;
import com.softtek.academy.jsp.exception.InvalidInputException;

public class CityService {

    private CityDao cityRepository;


    public CityService() {
        cityRepository = new CityDao();
    }

    public CityEntity getCity(final Long id) {
        return cityRepository.findOne(id);
    }

    public List<CityEntity> getCities() {
        return cityRepository.findAll();
    }

    public CityEntity save(CityDto cityDto) throws InvalidInputException {
        validate(cityDto);

        return cityRepository.save(cityDto);
    }

    private void validate(CityDto cityDto) throws InvalidInputException {
        if (cityDto.getId() == null || StringUtils.isBlank(cityDto.getDescription()) || cityDto.getStateId() == null) {
            throw new InvalidInputException("Valid id, description and stateId requiered");
        }

    }

    public CityEntity update(CityDto cityDto) throws InvalidInputException {
        validate(cityDto);

        return cityRepository.update(cityDto);
    }

    public void delete(final Long cityId) {
        cityRepository.delete(cityId);
    }
}
