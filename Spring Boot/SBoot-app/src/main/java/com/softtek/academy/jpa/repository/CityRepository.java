package com.softtek.academy.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.jpa.domain.model.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
