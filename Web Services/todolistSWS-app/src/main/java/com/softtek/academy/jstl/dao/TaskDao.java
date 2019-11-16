package com.softtek.academy.jstl.dao;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jstl.dao.mapping.TaskRowMapper;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.exception.NotFoundException;

@Repository
public class TaskDao {
	
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
    private ObjectFactory<RowMapper<Task>> rowMapperFactory;
	
	public List<Task> findAll() throws SQLException {
		
		return jdbcTemplate.query("SELECT * FROM task", rowMapperFactory.getObject());
		
	}
	
	public Task findOne(int id) {
		
		 String sql = "SELECT * FROM task WHERE idTask = :id";
		 MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		 Task task = null;
	        try {
	        	task = jdbcTemplate.queryForObject(sql, params, rowMapperFactory.getObject());
	        }catch(EmptyResultDataAccessException e) {
	        	throw new NotFoundException("No data found for taskId: " + id);
	        }
	        return task;  
	}
	
//	public Integer getItemCount() {
//		return this.jdbcTemplate.queryForObject("Select count(*) from task", Integer.class);
//	}
	

	
//	public List<Task> getItemLessThan(float priority) {
//		return this.jdbcTemplate.query("SELECT idTask, idPriority FROM task where idPriority <?", 
//				new Object[]{priority}, new TaskRowMapper());
//	}
}
