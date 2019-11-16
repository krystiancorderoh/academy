package com.softtek.academy.jstl.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.jstl.dao.TaskToUserDao;
import com.softtek.academy.jstl.domain.dto.TaskToUserDto;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.domain.model.TaskToUser;
import com.softtek.academy.jstl.exception.InvalidInputException;
@Service
public class TaskToUserService {
	@Autowired
	private TaskToUserDao taskToUserDao;
	
	

	public List<TaskToUser> getTaskToUsersOfOneTask(int idTask) {
		
		return taskToUserDao.findAllOfOneTask(idTask);
	}
	
	public List<TaskToUser> setTaskToUserTask(TaskToUserDto taskToUserDto) {
		return taskToUserDao.save(taskToUserDto);
	}
	
	public List<TaskToUser> getTaskToUsers() throws SQLException{
        return taskToUserDao.findAll();
    }
}

