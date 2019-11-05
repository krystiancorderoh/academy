package com.softtek.academy.jstl.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.softtek.academy.jstl.domain.model.Cart;
import com.softtek.academy.jstl.domain.model.City;
import com.softtek.academy.jstl.domain.model.Status;
import com.softtek.academy.jstl.domain.model.User;

public class CartRowMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(final ResultSet rs) throws SQLException {

        User user = new User();
        user.setUsername(rs.getString("user_id"));

        City city = new City();
        city.setId(rs.getLong("city_id"));

        Status status = new Status();
        status.setId(rs.getLong("status_id"));
        status.setDescription(rs.getString("description"));

        Cart cart = new Cart();
        cart.setId(rs.getLong("id"));
        cart.setUser(user);
        cart.setLinesAmount(rs.getDouble("lines_amount"));
        cart.setStatus(status);
        cart.setCreateUser(rs.getString("create_user"));
        cart.setCreateDate(rs.getTimestamp("create_date").toLocalDateTime());

        return cart;
    }

}
