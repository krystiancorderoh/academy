package com.softtek.academy.jstl.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jstl.domain.model.Priority;
import com.softtek.academy.jstl.domain.model.Status;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.domain.model.TaskToUser;
import com.softtek.academy.jstl.domain.model.User;

@Repository
public class TaskToUserRowMapper implements RowMapper<TaskToUser>{
	
	
    public TaskToUser mapRow(final ResultSet rs, int rowNum) throws SQLException {
		
		TaskToUser taskToUser = new TaskToUser();
    	Task task = new Task();
    	User user = new User();
    	Priority priority = new Priority();
    	Status status = new Status();
    	
    	task.setIdTask(rs.getInt("idTask"));
    	task.setName(rs.getString("taskName"));
    	task.setDescription(rs.getString("taskDescription"));
    	task.setCreationDate(rs.getDate("taskCreationDate").toLocalDate());
    	task.setDueDate(rs.getDate("taskDueDate").toLocalDate());
    	
    	user.setIdUser(rs.getInt("idUser"));
    	user.setName(rs.getString("userName"));
    	user.setEmail(rs.getString("userEmail"));
    	
    	priority.setIdPriority(rs.getInt("idPriority"));
    	priority.setName(rs.getString("priorityName"));
    	priority.setDescription(rs.getString("priorityDescription"));
    	
    	status.setIdStatus(rs.getInt("idStatus"));
    	status.setName(rs.getString("statusName"));
    	status.setDescription(rs.getString("statusDescription"));
    	
    	taskToUser.setIdTaskToUser(rs.getInt("idTaskToUser"));
    	taskToUser.setUser(user);
    	taskToUser.setTask(task);
    	taskToUser.setPriority(priority);
    	taskToUser.setStatus(status);
    	
    	return taskToUser;
    }

	
}
