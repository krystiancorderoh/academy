package com.softtek.academy.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jsp.domain.dto.CityDto;
import com.softtek.academy.jsp.domain.model.CityEntity;
import com.softtek.academy.jsp.domain.model.StateEntity;

public class CityDao {

    private static List<CityEntity> cities;

    private static StateDao stateRepository;


    static {
        cities = new ArrayList<>();

        stateRepository = new StateDao();

        final StateEntity bajaCalifornia = stateRepository.findOne(1L);
        final StateEntity bajaCaliforniaSur = stateRepository.findOne(2L);

        cities.add(new CityEntity(11L, "Mexicali", bajaCalifornia));
        cities.add(new CityEntity(12L, "Tijuana", bajaCalifornia));
        cities.add(new CityEntity(13L, "Ensenada", bajaCalifornia));
        cities.add(new CityEntity(21L, "La Paz", bajaCaliforniaSur));
    }

    public CityEntity findOne(final Long id) {
        for (final CityEntity city : cities) {
            if (city.getId().equals(id)) {
                return city;
            }
        }

        return null;
    }

    public List<CityEntity> findAll() {
        return cities;
    }

    public CityEntity save(CityDto cityDto) {
        StateEntity state = stateRepository.findOne(cityDto.getStateId());
        CityEntity city = new CityEntity(cityDto.getId(), cityDto.getDescription(), state);

        cities.add(city);

        return city;
    }

    public CityEntity update(CityDto cityDto) {
        CityEntity originalCity = this.findOne(cityDto.getId());
        originalCity.setDescription(cityDto.getDescription());
        StateEntity state = stateRepository.findOne(cityDto.getStateId());
        originalCity.setState(state);

        return originalCity;
    }

    public Boolean delete(final Long cityId) {
        final CityEntity city = this.findOne(cityId);
        cities.remove(city);

        return true;
    }

}