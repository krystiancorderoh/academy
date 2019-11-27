package com.softtek.academy.sboot.service.mapping;

import org.springframework.stereotype.Component;

import com.softtek.academy.sboot.domain.dto.CityDto;
import com.softtek.academy.sboot.domain.model.CityEntity;
import com.softtek.academy.sboot.domain.model.StateEntity;

@Component
public class CityMapper implements EntityMapper<CityDto, CityEntity> {

    @Override
    public CityEntity mapEntity(CityDto dto) {

        CityEntity city = new CityEntity();
        city.setId(dto.getId());
        city.setDescription(dto.getDescription());
        city.setState(new StateEntity(dto.getStateId()));


        return city;
    }

}
