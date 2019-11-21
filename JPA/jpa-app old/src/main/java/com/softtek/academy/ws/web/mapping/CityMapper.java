package com.softtek.academy.ws.web.mapping;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;

import com.softtek.academy.ws.domain.dto.CityDto;

public class CityMapper implements EntityMapper<CityDto> {

    @Override
    public CityDto mapEntity(HttpServletRequest request) {

        String description = request.getParameter("description");

        Long stateId = null;
        String stateIdParam = request.getParameter("stateId");
        if (NumberUtils.isDigits(stateIdParam)) {
            stateId = new Long(stateIdParam);
        }

        return new CityDto(description, stateId);
    }

}
