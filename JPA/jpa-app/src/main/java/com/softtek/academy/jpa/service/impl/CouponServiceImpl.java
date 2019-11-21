package com.softtek.academy.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.jpa.domain.model.CouponEntity;
import com.softtek.academy.jpa.repository.CouponRepository;
import com.softtek.academy.jpa.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;


    @Override
    public CouponEntity getCoupon(final String couponId) {
        return couponRepository.findOne(couponId);
    }

}
