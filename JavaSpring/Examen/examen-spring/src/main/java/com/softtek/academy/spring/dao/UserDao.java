package com.softtek.academy.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.spring.dao.mapping.UserRowMapper;
import com.softtek.academy.spring.domain.model.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll(){

		List<User> users = this.jdbcTemplate.query("Select * from [User]",new UserRowMapper());
		
		return users;
	}
	
	public void insertAll(List<List<String>> listaArchivo) {
		
		for(List<String> renglon:listaArchivo) {
			String update="insert into [User](name, email) " + 
					"values(?,?)";
			this.jdbcTemplate.update(update, renglon.get(0), renglon.get(1));
		}
	}
}
