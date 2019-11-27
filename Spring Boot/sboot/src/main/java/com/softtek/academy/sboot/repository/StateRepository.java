package com.softtek.academy.sboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.sboot.domain.model.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Long> {

}