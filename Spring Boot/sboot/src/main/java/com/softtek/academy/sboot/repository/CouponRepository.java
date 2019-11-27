package com.softtek.academy.sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.sboot.domain.model.CouponEntity;

public interface CouponRepository extends JpaRepository<CouponEntity, String> {

}