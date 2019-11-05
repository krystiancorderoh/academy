package com.softtek.academy.jstl.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.jstl.dao.TaskToUserValDtoDao;
import com.softtek.academy.jstl.domain.dto.TaskToUserValDto;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.exception.InvalidInputException;

public class TaskToUserValDtoService {
	private TaskToUserValDtoDao taskToUserValDtoDao;
	
	public TaskToUserValDtoService() {
		taskToUserValDtoDao = new TaskToUserValDtoDao();
    }
	
	public List<TaskToUserValDto> getTaskToUserValDto(int id) throws SQLException{
        return taskToUserValDtoDao.findAll(id);
    }
}
