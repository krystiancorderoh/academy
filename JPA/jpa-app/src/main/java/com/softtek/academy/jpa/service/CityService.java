package com.softtek.academy.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.domain.model.CityEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;

public interface CityService {

    Page<CityEntity> getPageOfCities(final Pageable pageable);

    CityEntity getCity(final Long id);

    List<CityEntity> getCities();

    CityEntity save(final CityDto cityDto) throws InvalidInputException;

    CityEntity update(final CityDto cityDto) throws InvalidInputException;

    void delete(final Long cityId);

	Page<CityEntity> getPageOfAguascalientesCities(Pageable pageable);

	Page<CityEntity> getPageOfBajaCaliforniaCities(Pageable pageable);
}
