package com.softtek.academy.jpa.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.jpa.domain.model.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Long> {

	Collection<StateEntity> findByChiapas();
}