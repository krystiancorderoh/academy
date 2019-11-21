package com.softtek.academy.jpa.repository.impl;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jpa.domain.model.CouponEntity;
import com.softtek.academy.jpa.repository.CouponRepository;
import com.softtek.academy.jpa.repository.map.CouponRowMapper;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectFactory<CouponRowMapper> rowMapperFactory;


    @Override
    public CouponEntity findOne(final String couponId) {
        final String sql = "SELECT * FROM coupon WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{couponId}, rowMapperFactory.getObject());
    }

}