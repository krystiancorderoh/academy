package com.softtek.academy.servlet.web.mapping;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;

import com.softtek.academy.servlet.domain.model.CityEntity;
import com.softtek.academy.servlet.domain.model.StateEntity;

public class CityMapper implements EntityMapper<CityEntity>{
	
	@Override
    public CityEntity mapEntity(HttpServletRequest request) {
        Long id = null;
        String idParam = request.getParameter("id");
        if (NumberUtils.isDigits(idParam)) {
            id = new Long(idParam);
        }

        String description = request.getParameter("description");
        StateEntity state = new StateEntity (Long.parseLong(request.getParameter("stateId")),request.getParameter("state"));

        return new CityEntity(id, description,state);
    }

}
