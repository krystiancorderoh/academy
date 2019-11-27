package com.softtek.academy.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.domain.model.CityEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.exception.NotFoundException;
import com.softtek.academy.jpa.repository.CityRepository;
import com.softtek.academy.jpa.service.CityService;
import com.softtek.academy.jpa.service.mapping.EntityMapper;
import com.softtek.academy.jpa.service.validation.ObjectValidator;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ObjectValidator<CityDto> cityValidator;

    @Autowired
    private EntityMapper<CityDto, CityEntity> cityMapper;


    @Override
    public Page<CityEntity> getPageOfCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public CityEntity getCity(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new NotFoundException("No data found for city: " + id));
    }

    @Override
    public List<CityEntity> getCities() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public CityEntity save(CityDto cityDto) throws InvalidInputException {
        this.cityValidator.validate(cityDto);

        CityEntity city = cityMapper.mapEntity(cityDto);

        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public CityEntity update(CityDto cityDto) throws InvalidInputException {
        this.cityValidator.validate(cityDto);

        CityEntity city = cityMapper.mapEntity(cityDto);

        return cityRepository.save(city);
    }

    @Override
    public void delete(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
