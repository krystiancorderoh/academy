package com.softtek.academy.jpa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jpa.domain.model.CouponEntity;
import com.softtek.academy.jpa.service.CouponService;

@RestController
@RequestMapping(path = "/coupons", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CouponController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    private CouponService couponService;


    @GetMapping(path = "/{couponId}")
    public CouponEntity getCuopon(@PathVariable String couponId) {
        LOGGER.info("Getting couponId: {}", couponId);

        return couponService.getCoupon(couponId);
    }

}
