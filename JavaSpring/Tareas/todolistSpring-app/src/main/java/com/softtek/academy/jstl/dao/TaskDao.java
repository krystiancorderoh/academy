package com.softtek.academy.jstl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;


import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.service.TaskService;
import com.softtek.academy.jstl.dao.mapping.RowMapper;
import com.softtek.academy.jstl.dao.mapping.TaskRowMapper;

@Repository
public class TaskDao{

//	@Autowired 
//	private ConnectionDao connectionDao;
//
//	@Autowired
//	private RowMapper<Task> taskRowMapper;
//
//	public Task findOne(int id) throws SQLException {
//		Task task = null;
//
//		try (Connection connection = connectionDao.getConnection();
//				PreparedStatement preparedStatement = connection
//						.prepareStatement("" + "Select * from task where idTask= ?");) {
//
//			preparedStatement.setLong(1, id);
//
//			final ResultSet rs = preparedStatement.executeQuery();
//			if (rs.next()) {
//				task = taskRowMapper.mapRow(rs);
//			}
//		}
//
//		return task;
//	}
//
//	public List<Task> findAll() throws SQLException {
//
//		List<Task> tasks = new ArrayList<>();
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
//		return tasks;
//	}
}
