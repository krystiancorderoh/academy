package com.softtek.academy.servlet.web.mapping;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;

import com.softtek.academy.servlet.domain.model.StateEntity;

public class StateMapper implements EntityMapper<StateEntity> {

    @Override
    public StateEntity mapEntity(HttpServletRequest request) {
        Long id = null;
        String idParam = request.getParameter("id");
        if (NumberUtils.isDigits(idParam)) {
            id = new Long(idParam);
        }

        String description = request.getParameter("description");

        return new StateEntity(id, description);
    }

}
