package com.softtek.academy.jstl.service;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.softtek.academy.jstl.dao.TaskDao;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.exception.InvalidInputException;

@Service
public class TaskService {
	
//	@Autowired
//	private TaskDao taskDao;
//	
//	
//	public Task getTask(final int id) throws SQLException  {
//        return taskDao.findOne(id);
//    }
//	public List<Task> getTasks() throws SQLException{
//        return taskDao.findAll();
//    }

}
