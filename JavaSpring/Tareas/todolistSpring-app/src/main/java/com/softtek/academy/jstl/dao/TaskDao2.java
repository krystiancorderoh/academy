package com.softtek.academy.jstl.dao;



import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jstl.dao.mapping.TaskRowMapper;
import com.softtek.academy.jstl.domain.model.Task;

@Repository
public class TaskDao2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Integer getItemCount() {
		return this.jdbcTemplate.queryForObject("Select count(*) from task", Integer.class);
	}
	
	public Task findOne(int id) {
		List<Task> tasks = this.jdbcTemplate.query("Select * from task where idTask= ?", new Object[]{id},new TaskRowMapper());
		return tasks.isEmpty()? null:tasks.get(0);
		
	}
	
	public List<Task> getItemLessThan(float priority) {
		return this.jdbcTemplate.query("SELECT idTask, idPriority FROM task where idPriority <?", 
				new Object[]{priority}, new TaskRowMapper());
	}
}
