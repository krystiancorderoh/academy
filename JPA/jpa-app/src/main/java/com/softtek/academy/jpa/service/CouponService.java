package com.softtek.academy.jpa.service;

import com.softtek.academy.jpa.domain.model.CouponEntity;

public interface CouponService {

    CouponEntity getCoupon(final String couponId);

}
