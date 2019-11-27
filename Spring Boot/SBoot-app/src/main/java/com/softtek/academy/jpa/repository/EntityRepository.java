package com.softtek.academy.jpa.repository;

import java.util.List;

public interface EntityRepository<T, K> {

    default List<T> findAll() {
        throw new RuntimeException("Not implemented method");
    }

    default T findOne(K id) {
        throw new RuntimeException("Not implemented method");
    }

    default T save(final T entity) {
        throw new RuntimeException("Not implemented method");
    }

    default T update(final T entity) {
        throw new RuntimeException("Not implemented method");
    }

    default Boolean delete(final K id) {
        throw new RuntimeException("Not implemented method");
    }

}
