package com.softtek.academy.sboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.sboot.domain.model.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
