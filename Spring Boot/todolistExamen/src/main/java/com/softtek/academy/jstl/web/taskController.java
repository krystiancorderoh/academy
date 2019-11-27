package com.softtek.academy.jstl.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.service.TaskService;
import com.softtek.academy.jstl.service.TaskServiceInt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/tasks")
public class taskController {
	
	@Autowired
	private TaskServiceInt taskServiceInt;
	
	@GetMapping
	public List<Task> getTasks() throws SQLException{
		
		log.info("Getting all tasks");
		System.out.println(taskServiceInt.getTasks());
		return taskServiceInt.getTasks();
		
	}
	
	@GetMapping("/{id}")
	public Task getTask(@PathVariable Long id) throws SQLException {
			System.out.println(taskServiceInt.getTask(id));
			return taskServiceInt.getTask(id);

	}
	
	

}
