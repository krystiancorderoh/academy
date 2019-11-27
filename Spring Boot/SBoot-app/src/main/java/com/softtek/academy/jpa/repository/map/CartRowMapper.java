package com.softtek.academy.jpa.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.domain.model.StatusEntity;

@Component
@Scope("prototype")
public class CartRowMapper implements RowMapper<CartEntity> {

    @Override
    public CartEntity mapRow(final ResultSet rs, int rowNum) throws SQLException {

        StatusEntity status = new StatusEntity();
        status.setId(rs.getLong("status_id"));

        CartEntity cart = new CartEntity();
        cart.setId(rs.getLong("id"));
        cart.setUserId(rs.getString("user_id"));
        cart.setLinesAmount(rs.getDouble("lines_amount"));
        cart.setStatus(status);
        cart.setCreateUser(rs.getString("create_user"));
        //cart.setCreateDate(rs.getTimestamp("create_date"));

        return cart;
    }

}
