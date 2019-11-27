package com.softtek.academy.jpa.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.model.CartLineEntity;
import com.softtek.academy.jpa.domain.model.ItemEntity;

@Component
@Scope("prototype")
public class CartLineRowMapper implements RowMapper<CartLineEntity> {

    @Override
    public CartLineEntity mapRow(final ResultSet rs, int rowNum) throws SQLException {

        ItemEntity item = new ItemEntity();
        item.setId(rs.getLong("item_id"));

        CartLineEntity line = new CartLineEntity();
        line.setId(rs.getLong("id"));
        line.setCartId(rs.getLong("cart_id"));
        line.setItem(item);
        line.setQuantity(rs.getLong("quantity"));

        return line;
    }

}
