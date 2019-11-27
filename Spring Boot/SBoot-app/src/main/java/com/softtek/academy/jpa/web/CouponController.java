package com.softtek.academy.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jpa.domain.model.CouponEntity;
import com.softtek.academy.jpa.service.CouponService;

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

}
