package com.softtek.academy.jstl.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academy.jstl.domain.dto.TaskToUserDto;
import com.softtek.academy.jstl.domain.model.TaskToUser;
import com.softtek.academy.jstl.service.TaskService;
import com.softtek.academy.jstl.service.TaskToUserService;

@RestController
@RequestMapping(value = "/tasks/{id}/assignments")
public class taskToUserController {
	
	@Autowired
	private TaskToUserService taskToUserService;
	
	@GetMapping
	public List<TaskToUser> getTaskToUsersOfOneTask(@PathVariable Long id) throws SQLException{

		return taskToUserService.getTaskToUsersOfOneTask(id);
	
	}
	
//	@PostMapping
//	public List<TaskToUser> setTaskToUserTask(@PathVariable Integer id, @RequestBody TaskToUserDto taskToUserDto) throws SQLException {
//		taskToUserDto.setIdTask(id);	
//		return taskToUserService.setTaskToUserTask(taskToUserDto);
//
//	}
//	
//	@GetMapping
//	public List<TaskToUser> getTaskToUsers() throws SQLException{
////	public String getTasks() throws SQLException{
//		
////		return "hola mundo";
//		System.out.println(taskToUserService.getTaskToUsers());
//		return taskToUserService.getTaskToUsers();
////		
//	}
	

	
	

}
