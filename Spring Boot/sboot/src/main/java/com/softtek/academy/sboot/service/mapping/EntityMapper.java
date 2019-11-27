package com.softtek.academy.sboot.service.mapping;

public interface EntityMapper<D, E> {

    E mapEntity(D dto);

}
