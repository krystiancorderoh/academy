package com.softtek.academy.ws.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.domain.model.Cart;

@Repository
public class CartDao {

	private static final String SQL_SELECT = "SELECT c.*, st.*, s.* FROM cart c JOIN users u ON u.username = c.user_id JOIN status s ON s.id = c.status_id";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private ObjectFactory<RowMapper<Cart>> rowMapperFactory;
	
    public List<Cart> findAll() throws SQLException {
    	return jdbcTemplate.query(SQL_SELECT, rowMapperFactory.getObject());
    }

}