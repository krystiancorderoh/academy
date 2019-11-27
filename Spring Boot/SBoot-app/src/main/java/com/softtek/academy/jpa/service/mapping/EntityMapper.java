package com.softtek.academy.jpa.service.mapping;

public interface EntityMapper<D, E> {

    E mapEntity(D dto);

}
