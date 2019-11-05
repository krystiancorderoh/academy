package com.softtek.academy.jstl.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

import com.softtek.academy.jstl.domain.dto.TaskToUserValDto; 
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.dao.mapping.RowMapper;
import com.softtek.academy.jstl.dao.mapping.TaskRowMapper;
import com.softtek.academy.jstl.dao.mapping.TaskToUserValDtoRowMapper;

public class TaskToUserValDtoDao extends AbstractDao{
	
	private RowMapper<TaskToUserValDto> taskToUserValDtoRowMapper;
	
	public TaskToUserValDtoDao() {
		taskToUserValDtoRowMapper = new TaskToUserValDtoRowMapper();
    }
	
	public List<TaskToUserValDto> findAll(int id) throws SQLException {

        List<TaskToUserValDto> taskToUserValDtos = new ArrayList<>();

        try (   Connection connection = super.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement
                		("SELECT usr.[name] as userName, usr.email as userEmail, pr.name as priority,st.name as status " + 
                				"  FROM [ToDoList].[dbo].[TaskToUser] as ttu" + 
                				"  join Task on task.idTask = ttu.idTask" + 
                				"  join [User] as usr on usr.idUser = ttu.idUser" + 
                				"  join Priority as pr on pr.idPriority = ttu.idPriority" + 
                				"  join Status as st on st.idStatus = ttu.idStatus" + 
                				"  Where task.idTask = ?");) {
        	preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	taskToUserValDtos.add(taskToUserValDtoRowMapper.mapRow(rs));
            }
        }

        return taskToUserValDtos;
    }
	
	
	
}
