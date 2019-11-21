package com.softtek.academy.jpa.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.model.CouponEntity;

@Component
@Scope("prototype")
public class CouponRowMapper implements RowMapper<CouponEntity> {

    @Override
    public CouponEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final CouponEntity coupon = new CouponEntity();

        coupon.setId(rs.getString("id"));
        coupon.setValidFrom(rs.getTimestamp("valid_from"));
        coupon.setValidTo(rs.getTimestamp("valid_to"));
        coupon.setValue(rs.getDouble("value"));
        coupon.setRedeemed(rs.getDouble("redeemed"));
        coupon.setBalance(rs.getDouble("balance"));
        coupon.setActive(rs.getString("active").equals("Y"));
        coupon.setCreateUser(rs.getString("create_user"));
        coupon.setCreateDate(rs.getTimestamp("create_date"));
        coupon.setUpdateUser(rs.getString("update_user"));
        coupon.setUpdateDate(rs.getTimestamp("update_date"));

        return coupon;
    }

}
