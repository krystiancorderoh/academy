package com.softtek.academy.jstl.web.mapping;

import javax.servlet.http.HttpServletRequest;

public interface EntityMapper<T> {

    T mapEntity(HttpServletRequest request);

}
