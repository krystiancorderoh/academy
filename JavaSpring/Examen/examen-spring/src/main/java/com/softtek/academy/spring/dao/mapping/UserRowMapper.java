package com.softtek.academy.spring.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.softtek.academy.spring.domain.model.User;



@Repository
public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setIdUser(rs.getInt("idUser"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
    	
    	return user;
	}

}
