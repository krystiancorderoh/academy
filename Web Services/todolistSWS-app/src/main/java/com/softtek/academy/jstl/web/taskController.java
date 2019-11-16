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

@RestController
@RequestMapping(value = "/tasks")
public class taskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<Task> getTasks() throws SQLException{
//	public String getTasks() throws SQLException{
		
//		return "hola mundo";
		System.out.println(taskService.getTasks());
		return taskService.getTasks();
		
	}
	
	@GetMapping("/{id}")
	public Task getTask(@PathVariable Integer id) throws SQLException {
			System.out.println(taskService.getTask(id));
			return taskService.getTask(id);

	}
	
	

}
