package com.softtek.academy.jpa.service.factory;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CityDto;
import com.softtek.academy.jpa.domain.model.StateEntity;

@Component
public class StateFromCityFactory implements EntityFactory<CityDto, StateEntity> {

    @Override
    public StateEntity createEntity(CityDto dto) {

    	StateEntity state = new StateEntity();
    	state.setDescription(dto.getStateName());

        return state;
    }

}
