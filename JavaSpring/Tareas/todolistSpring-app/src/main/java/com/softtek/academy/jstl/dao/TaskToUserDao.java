package com.softtek.academy.jstl.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jstl.dao.mapping.TaskRowMapper;
import com.softtek.academy.jstl.domain.model.Task;

@Repository
public class TaskToUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Task> findAll(){

		List<Task> tasks = new ArrayList<>();
//
//		try (Connection connection = connectionDao.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement("Select * from task");) {
//
//			ResultSet rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				tasks.add(taskRowMapper.mapRow(rs));
//			}
//		}
//
		return tasks;
	}

}
