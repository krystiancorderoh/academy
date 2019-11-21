package com.softtek.academy.jpa.service.factory;

import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.domain.model.CityEntity;
import com.softtek.academy.jpa.domain.model.StateEntity;

@Component
public class CityFacotyr implements EntityFactory<CityDto, CityEntity> {

    @Override
    public CityEntity createEntity(CityDto dto) {

        CityEntity city = new CityEntity();
        city.setId(dto.getId());
        city.setDescription(dto.getDescription());
        city.setState(new StateEntity(dto.getStateId()));
        city.getState().setDescription(dto.getStateName());

        return city;
    }

}
