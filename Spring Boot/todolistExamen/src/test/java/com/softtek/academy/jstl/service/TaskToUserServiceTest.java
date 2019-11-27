package com.softtek.academy.jstl.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.softtek.academy.jstl.dao.TaskToUserDao;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.domain.model.TaskToUser;

@RunWith(MockitoJUnitRunner.class)
public class TaskToUserServiceTest {
	
	@Mock
	private TaskToUserDao taskToUserDao;
	
	@InjectMocks
	private TaskToUserService taskToUserService;
	
	@Test
	public void testGetTaskToUsersOfOneTask() {
		Mockito.when(taskToUserDao.findAllOfOneTask(1)).thenReturn(null);
	
		List<TaskToUser> res = taskToUserService.getTaskToUsersOfOneTask(1);
		Mockito.verify(taskToUserDao).findAllOfOneTask(1);
	
	}
	
}
