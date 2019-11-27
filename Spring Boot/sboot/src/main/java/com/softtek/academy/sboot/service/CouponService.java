package com.softtek.academy.sboot.service;

import com.softtek.academy.sboot.domain.model.CouponEntity;

public interface CouponService {

    CouponEntity getCoupon(final String couponId);
    
    CouponEntity save(CouponEntity coupon);

}
