package com.softtek.academy.jstl.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.softtek.academy.jstl.domain.model.Task;


public class TaskRowMapper implements RowMapper<Task>{
	
	@Override
    public Task mapRow(final ResultSet rs) throws SQLException {

    	Task task = new Task();
    	task.setIdTask(rs.getInt("idTask"));
    	task.setName(rs.getString("name"));
    	task.setDescription(rs.getString("description"));
    	task.setCreationDate(rs.getDate("creationDate").toLocalDate());
    	task.setDueDate(rs.getDate("dueDate").toLocalDate());
    	
    	return task;
    }

}
