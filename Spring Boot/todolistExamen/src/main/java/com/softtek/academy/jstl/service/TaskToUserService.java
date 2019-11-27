package com.softtek.academy.jstl.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.jstl.dao.TaskToUserDaoInt;
import com.softtek.academy.jstl.domain.dto.TaskToUserDto;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.domain.model.TaskToUser;
import com.softtek.academy.jstl.exception.InvalidInputException;
import com.softtek.academy.jstl.exception.NotFoundException;
@Service
public class TaskToUserService implements TaskToUserServiceInt{
	
	@Autowired
	private TaskToUserDaoInt taskToUserDao;
	
	public List<TaskToUser> getTaskToUsersOfOneTask(Long idTask) {
//		return taskToUserDao.findById(idTask).orElseThrow(() -> new NotFoundException("No data found for : " + id));
		return null;
	}
	
	
	
}

