package com.softtek.academy.jsp.web.mapping;

import javax.servlet.http.HttpServletRequest;

public interface EntityMapper<T> {

    T mapEntity(HttpServletRequest request);

}
