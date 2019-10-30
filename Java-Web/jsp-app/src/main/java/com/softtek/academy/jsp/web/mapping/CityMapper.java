package com.softtek.academy.jsp.web.mapping;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;

import com.softtek.academy.jsp.domain.dto.CityDto;

public class CityMapper implements EntityMapper<CityDto> {

    @Override
    public CityDto mapEntity(HttpServletRequest request) {

        Long id = null;
        String idParam = request.getParameter("id");
        if (NumberUtils.isDigits(idParam)) {
            id = new Long(idParam);
        }

        String description = request.getParameter("description");

        Long stateId = null;
        String stateIdParam = request.getParameter("stateId");
        if (NumberUtils.isDigits(stateIdParam)) {
            stateId = new Long(stateIdParam);
        }

        return new CityDto(id, description, stateId);
    }

}
