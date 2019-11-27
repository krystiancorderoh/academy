package com.softtek.academy.jstl.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.softtek.academy.jstl.dao.TaskToUserDao;
import com.softtek.academy.jstl.domain.dto.TaskToUserDto;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.domain.model.TaskToUser;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/spring/applicationContext.xml")
public class TaskToUserServiceTestInt {
	
	@Autowired
	TaskToUserDto taskToUserDto;
	
	@Autowired
	private TaskToUserService taskToUserService;
	
	@Test
	public void testGetTaskToUsersOfOneTask() {
		
		
		
		List<TaskToUser> res = taskToUserService.getTaskToUsersOfOneTask(1);
		
		assertNotNull(res);
		
		TaskToUser taskToUser = res.get(0);
		
		assertNotNull(taskToUser.getIdTaskToUser());
		
		assertTrue(taskToUser.getIdTaskToUser()==1);
		
		assertTrue(taskToUser.getIdTaskToUser() > 0);
//		assertTrue(taskToUser.getPriority().getClass() == Integer.class)
	}
	
	@Test
	public void testSetTaskToUserTask() {
		taskToUserDto.setIdPriority(2);
		taskToUserDto.setIdStatus(2);
		taskToUserDto.setIdTask(2);
		taskToUserDto.setIdUser(2);
		
		List<TaskToUser> taskToUsers = taskToUserService.setTaskToUserTask(taskToUserDto);
		
		assertTrue(taskToUsers.size()!= 0);
		
		assertTrue(taskToUsers.get(1).getPriority().getIdPriority() == 2);	 
	}
	
}

