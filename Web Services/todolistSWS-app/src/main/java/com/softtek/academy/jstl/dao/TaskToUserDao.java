package com.softtek.academy.jstl.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jstl.dao.mapping.TaskRowMapper;
import com.softtek.academy.jstl.domain.dto.TaskToUserDto;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.domain.model.TaskToUser;

@Repository
public class TaskToUserDao {
	
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
    private ObjectFactory<RowMapper<TaskToUser>> rowMapperFactory;
	
	

	public List<TaskToUser> findAllOfOneTask(int idTask) {
		String sql = "SELECT	ttu.idTaskToUser, " + 
				"		task.idTask,task.[name] as taskName, task.description as taskDescription, " + 
				"		task.creationDate as taskCreationDate, task.dueDate as taskDueDate, " + 
				"		usr.idUser, usr.[name] as userName, usr.email as userEmail, " + 
				"		pr.idPriority, pr.[name] as priorityName, pr.description as priorityDescription," + 
				"		st.idStatus,st.name as statusName, st.description as statusDescription " + 
				"  FROM [ToDoList].[dbo].[TaskToUser] as ttu " + 
				"  join Task on task.idTask = ttu.idTask " + 
				"  join [User] as usr on usr.idUser = ttu.idUser " + 
				" join Priority as pr on pr.idPriority = ttu.idPriority " + 
				" join Status as st on st.idStatus = ttu.idStatus where Task.idTask = :idTask";
		MapSqlParameterSource params = new MapSqlParameterSource("idTask", idTask);
		return jdbcTemplate.query(sql,params, rowMapperFactory.getObject());
	}
	
	public List<TaskToUser> save(TaskToUserDto taskToUserDto) {
		String sqlSelect = "SELECT	ttu.idTaskToUser, " + 
				"		task.idTask,task.[name] as taskName, task.description as taskDescription, " + 
				"		task.creationDate as taskCreationDate, task.dueDate as taskDueDate, " + 
				"		usr.idUser, usr.[name] as userName, usr.email as userEmail, " + 
				"		pr.idPriority, pr.[name] as priorityName, pr.description as priorityDescription," + 
				"		st.idStatus,st.name as statusName, st.description as statusDescription " + 
				"  FROM [ToDoList].[dbo].[TaskToUser] as ttu " + 
				"  join Task on task.idTask = ttu.idTask " + 
				"  join [User] as usr on usr.idUser = ttu.idUser " + 
				" join Priority as pr on pr.idPriority = ttu.idPriority " + 
				" join Status as st on st.idStatus = ttu.idStatus where ttu.idTask = :idTask and ttu.idUser = :idUser";
		MapSqlParameterSource params = new MapSqlParameterSource("idTask", taskToUserDto.getIdTask());
		params.addValue("idUser", taskToUserDto.getIdUser());
		List<TaskToUser> taskToUserExistentes = jdbcTemplate.query(sqlSelect,params, rowMapperFactory.getObject());
		
		if(taskToUserExistentes.isEmpty()) {
			String sql = "INSERT INTO TaskToUser(idTask,idUser,idPriority,idStatus) VALUES(:idTask,:idUser,:idPriority,:idStatus)";
	    	MapSqlParameterSource params2 = new MapSqlParameterSource("idTask", taskToUserDto.getIdTask());
	        params2.addValue("idUser", taskToUserDto.getIdUser());
	        params2.addValue("idPriority", taskToUserDto.getIdPriority());
	        params2.addValue("idStatus", taskToUserDto.getIdStatus());
	        jdbcTemplate.update(sql, params2);
	        
		}
		return findAllOfOneTask(taskToUserDto.getIdTask());
	}
	
	//este no lo ocupo en el examen
	public List<TaskToUser> findAll(){
		String sql = "SELECT	ttu.idTaskToUser, " + 
				"		task.idTask,task.[name] as taskName, task.description as taskDescription, " + 
				"		task.creationDate as taskCreationDate, task.dueDate as taskDueDate, " + 
				"		usr.idUser, usr.[name] as userName, usr.email as userEmail, " + 
				"		pr.idPriority, pr.[name] as priorityName, pr.description as priorityDescription," + 
				"		st.idStatus,st.name as statusName, st.description as statusDescription " + 
				"  FROM [ToDoList].[dbo].[TaskToUser] as ttu " + 
				"  join Task on task.idTask = ttu.idTask " + 
				"  join [User] as usr on usr.idUser = ttu.idUser " + 
				" join Priority as pr on pr.idPriority = ttu.idPriority " + 
				" join Status as st on st.idStatus = ttu.idStatus";
		return jdbcTemplate.query(sql, rowMapperFactory.getObject());
		
	
	}

	
}
