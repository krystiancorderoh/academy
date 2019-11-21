package com.softtek.academy.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.jpa.domain.model.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}