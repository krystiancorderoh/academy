package com.softtek.academy.ws.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.ws.dao.CartDao;
import com.softtek.academy.ws.domain.model.Cart;
@Service
public class CartService {
	@Autowired
    private CartDao cartDao;

	public List<Cart> getCarts() throws SQLException {
        return cartDao.findAll();
    }

}