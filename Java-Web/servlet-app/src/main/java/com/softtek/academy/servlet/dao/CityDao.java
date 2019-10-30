package com.softtek.academy.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.servlet.domain.model.CityEntity;
import com.softtek.academy.servlet.domain.model.StateEntity;

public class CityDao {
	private static List<CityEntity> cities;

    static {
    	cities = new ArrayList<>();
    	cities.add(new CityEntity(1L,"Ensenada",new StateEntity(1L, "Baja California")));
    	cities.add(new CityEntity(2L,"La Paz",new StateEntity(2L, "Baja California Sur")));
    	cities.add(new CityEntity(3L,"Hermosillo",new StateEntity(3L, "Sonora")));
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

    public CityEntity save(final CityEntity city) {
        cities.add(city);
        return city;
    }

}
