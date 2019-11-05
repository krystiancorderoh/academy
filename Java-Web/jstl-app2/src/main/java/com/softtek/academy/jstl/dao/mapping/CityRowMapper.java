package com.softtek.academy.jstl.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.softtek.academy.jstl.domain.model.City;

public class CityRowMapper implements RowMapper<City> {

    @Override
    public City mapRow(final ResultSet rs) throws SQLException {

        City city = new City();
        city.setId(rs.getLong("id"));
        city.setDescription(rs.getString("description"));

        return city;
    }

}
