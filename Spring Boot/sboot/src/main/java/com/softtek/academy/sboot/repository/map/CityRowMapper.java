package com.softtek.academy.sboot.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.sboot.domain.model.CityEntity;
import com.softtek.academy.sboot.domain.model.StateEntity;

@Component
@Scope("prototype")
public class CityRowMapper implements RowMapper<CityEntity> {

    @Override
    public CityEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        StateEntity state = new StateEntity();
        state.setId(rs.getLong("state_id"));
        state.setDescription(rs.getString("state_description"));

        CityEntity city = new CityEntity();
        city.setId(rs.getLong("id"));
        city.setDescription(rs.getString("description"));
        city.setState(state);

        return city;
    }

}
