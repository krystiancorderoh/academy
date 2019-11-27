package com.softtek.academy.sboot.repository.impl;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.sboot.domain.model.CartLineEntity;
import com.softtek.academy.sboot.repository.CartLineRepository;
import com.softtek.academy.sboot.repository.map.CartLineRowMapper;

@Repository
public class CartLineRepositoryImpl implements CartLineRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectFactory<CartLineRowMapper> rowMapperFactory;


    @Override
    public CartLineEntity save(CartLineEntity line) {
        final Object[] params = new Object[] {
                line.getCartId(),
                line.getItem().getId(),
                line.getQuantity()
        };

        jdbcTemplate.update("INSERT INTO cart_line(cart_id, item_id, quantity) VALUES(?, ?, ?)", params);

        line = jdbcTemplate.queryForObject("SELECT * FROM cart_line WHERE cart_id = ? AND item_id = ? AND quantity = ?",
                params, rowMapperFactory.getObject());

        return line;
    }



}