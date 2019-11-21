package com.softtek.academy.jpa.service.factory;

public interface EntityFactory<D, E> {

    E createEntity(D dto);

}
