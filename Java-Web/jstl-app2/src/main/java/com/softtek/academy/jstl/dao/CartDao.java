package com.softtek.academy.jstl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.dao.mapping.CartRowMapper;
import com.softtek.academy.jstl.dao.mapping.RowMapper;
import com.softtek.academy.jstl.domain.model.Cart;

public class CartDao extends AbstractDao {

    private RowMapper<Cart> cartRowMapper;


    public CartDao() {
        cartRowMapper = new CartRowMapper();
    }

    public List<Cart> findAll() throws SQLException {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT c.*, st.*, s.*");
        sql.append("  FROM cart c");
        sql.append("  JOIN users u ON u.username = c.user_id");
        sql.append("  JOIN status s ON s.id = c.status_id");

        final List<Cart> carts = new ArrayList<>();
        try (
                Connection connection = super.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
                ) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                carts.add(cartRowMapper.mapRow(rs));
            }
        }

        return carts;
    }

}