package com.softtek.academy.jstl.service;

import java.sql.SQLException;
import java.util.List;

import com.softtek.academy.jstl.dao.CartDao;
import com.softtek.academy.jstl.domain.model.Cart;

public class CartService {

    private CartDao cartDao;


    public CartService() {
        cartDao = new CartDao();
    }

    public List<Cart> getCarts() throws SQLException {
        return cartDao.findAll();
    }

}