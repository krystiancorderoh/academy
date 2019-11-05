package com.softtek.academy.jstl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.domain.dto.CityDto;
import com.softtek.academy.jstl.domain.model.City;
import com.softtek.academy.jstl.domain.model.State;

public class CityDao {

    private static List<City> cities;

    private static StateDao stateDao;


    static {
        cities = new ArrayList<>();

        stateDao = new StateDao();

        State bajaCalifornia = null;
        State bajaCaliforniaSur = null;
        try {
            bajaCalifornia = stateDao.findOne(1L);
            bajaCaliforniaSur = stateDao.findOne(2L);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cities.add(new City(11L, "Mexicali", bajaCalifornia));
        cities.add(new City(12L, "Tijuana", bajaCalifornia));
        cities.add(new City(13L, "Ensenada", bajaCalifornia));
        cities.add(new City(21L, "La Paz", bajaCaliforniaSur));
    }

    public City findOne(Long id) {
        for (City city : cities) {
            if (city.getId().equals(id)) {
                return city;
            }
        }

        return null;
    }

    public List<City> findAll() {
        return cities;
    }

    public City save(CityDto cityDto) throws SQLException {
        State state = stateDao.findOne(cityDto.getStateId());
        City city = new City(1L, cityDto.getDescription(), state);

        cities.add(city);

        return city;
    }

    public City update(CityDto cityDto) throws SQLException {
        City originalCity = this.findOne(1L);
        originalCity.setDescription(cityDto.getDescription());
        State state = stateDao.findOne(cityDto.getStateId());
        originalCity.setState(state);

        return originalCity;
    }

    public Boolean delete(Long cityId) {
        City city = this.findOne(cityId);
        cities.remove(city);

        return true;
    }

}