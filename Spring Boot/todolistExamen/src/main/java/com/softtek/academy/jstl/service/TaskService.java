package com.softtek.academy.jstl.service;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.softtek.academy.jstl.dao.TaskDaoInt;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.exception.InvalidInputException;
import com.softtek.academy.jstl.exception.NotFoundException;

@Service
public class TaskService implements TaskServiceInt{
	
	@Autowired
	private TaskDaoInt taskDaoInt;

	public List<Task> getTasks() throws SQLException{
        return taskDaoInt.findAll();
    }
	
	public Task getTask(final Long id) throws SQLException  {
      return taskDaoInt.findById(id).orElseThrow(() -> new NotFoundException("No data found for city: " + id));
  }

}
