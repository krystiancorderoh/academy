package com.softtek.academy.jpa.repository.impl;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jpa.domain.enums.SerializingFormat;
import com.softtek.academy.jpa.domain.model.CartEntity;
import com.softtek.academy.jpa.repository.CartRepository;

//@Repository
//public class CartRepositoryImpl implements CartRepository {
	public class CartRepositoryImpl {

//    private static final SimpleDateFormat formatter = new SimpleDateFormat(SerializingFormat.DATE_TIME.getFormat());
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private ObjectFactory<CartRowMapper> rowMapperFactory;
//
//
//    @Override
//    public CartEntity save(CartEntity cart) {
//        final Object[] params = new Object[] {
//                cart.getUserId(),
//                cart.getLinesAmount(),
//                cart.getStatus().getId(),
//                cart.getCreateUser(),
//                formatter.format(cart.getCreateDate())
//        };
//
//        jdbcTemplate.update("INSERT INTO cart(user_id, lines_amount, status_id, create_user, create_date) "
//                + "VALUES(?, ?, ?, ?, ?)", params);
//
//        cart = jdbcTemplate.queryForObject( "SELECT * from cart "
//                + "WHERE user_id = ? AND lines_amount = ? AND status_id = ? AND create_user = ? AND create_date = ?",
//                params, rowMapperFactory.getObject());
//
//        return cart;
//    }
//
//    @Override
//    public CartEntity update(CartEntity cart) {
//        final Object[] params = new Object[] {
//                cart.getLinesAmount(),
//                cart.getId()
//        };
//
//        jdbcTemplate.update("UPDATE cart SET lines_amount = ? WHERE id = ?", params);
//
//        return jdbcTemplate.queryForObject( "SELECT * from cart WHERE id = " + cart.getId(), rowMapperFactory.getObject());
//    }


}