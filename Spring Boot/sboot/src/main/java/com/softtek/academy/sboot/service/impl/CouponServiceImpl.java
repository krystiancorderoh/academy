package com.softtek.academy.sboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.sboot.domain.model.CouponEntity;
import com.softtek.academy.sboot.exception.NotFoundException;
import com.softtek.academy.sboot.repository.CouponRepository;
import com.softtek.academy.sboot.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;


    @Override
    public CouponEntity getCoupon(String couponId) {
        return couponRepository.findById(couponId).orElseThrow(() -> new NotFoundException("No datafound coupon: "+couponId));
    }


	@Override
	public CouponEntity save(CouponEntity coupon) {
		
		return couponRepository.save(coupon);
	}

}
