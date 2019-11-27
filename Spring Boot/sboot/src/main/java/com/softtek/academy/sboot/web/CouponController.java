package com.softtek.academy.sboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.sboot.domain.model.CouponEntity;
import com.softtek.academy.sboot.service.CouponService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/coupons", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CouponController {

    @Autowired
    private CouponService couponService;


    @GetMapping(path = "/{id}")
    public CouponEntity getCuopon(@PathVariable String id) {
        log.info("Getting coupon: {}", id);

        return couponService.getCoupon(id);
    }
    
    @PostMapping
    public CouponEntity saveCuopon(@RequestBody CouponEntity coupon) {
//        log.info("Getting coupon: {}", id);

        return couponService.save(coupon);
    }

}
