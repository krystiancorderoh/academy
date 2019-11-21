package com.softtek.academy.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.domain.model.CityEntity;
import com.softtek.academy.jpa.domain.model.StateEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.repository.CityRepository;
import com.softtek.academy.jpa.repository.StateRepository;
import com.softtek.academy.jpa.service.CityService;
import com.softtek.academy.jpa.service.factory.EntityFactory;
import com.softtek.academy.jpa.service.validation.ObjectValidator;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ObjectValidator<CityDto> cityValidator;

    @Autowired
    private EntityFactory<CityDto, CityEntity> cityFactory;
    
    @Autowired
    private EntityFactory<CityDto, StateEntity> stateFromCityFactory;


    @Override
    public Page<CityEntity> getPageOfCities(final Pageable pageable) {
        return cityRepository.findAll(pageable);
    }
    
    @Override
    public Page<CityEntity> getPageOfAguascalientesCities(final Pageable pageable) {
        return cityRepository.findAguascalientesCities(pageable);
//    	return null;
    }

    @Override
    public Page<CityEntity> getPageOfBajaCaliforniaCities(final Pageable pageable) {
        return cityRepository.findBajaCaliforniaCities(pageable);
//        return null;
    }
    
    @Override
    public CityEntity getCity(final Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public List<CityEntity> getCities() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public CityEntity save(final CityDto cityDto) throws InvalidInputException {
        //this.cityValidator.validate(cityDto);

    	CityEntity city = cityFactory.createEntity(cityDto);
        
        StateEntity state=stateRepository.save(city.getState());
        city.setState(state);
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public CityEntity update(final CityDto cityDto) throws InvalidInputException {
        this.cityValidator.validate(cityDto);

        final CityEntity city = cityFactory.createEntity(cityDto);

        return cityRepository.save(city);
    }

    @Override
    public void delete(final Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
