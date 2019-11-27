package com.softtek.academy.jstl.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.softtek.academy.jstl.dao.TaskDao;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.exception.NotFoundException;
@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
	@Mock
	private TaskDao taskDao;
	
	@InjectMocks
	private TaskService taskService;
	
	@Test
	public void testGetNullTask() throws SQLException{
		Mockito.when(taskDao.findOne(10)).thenReturn(null);
		
		Task res = taskService.getTask(10);
		Mockito.verify(taskDao).findOne(10);
		
		assertNull(res);
		assertTrue(res==null);
	}
	
	@Test
	public void testGetTask() throws SQLException {
		Mockito.when(taskDao.findOne(10)).thenReturn(new Task());
		
		Task res = taskService.getTask(10);
		Mockito.verify(taskDao).findOne(10);
		
		assertNotNull(res);
		assertTrue(res.getIdTask()==0);
		assertTrue(res != null);
	}

	@Test
	public void testFindOneWithId() throws SQLException {
		Task task = new Task();
		task.setIdTask(10);
		Mockito.when(taskDao.findOne(10)).thenReturn(task);
		
		Task res = taskService.getTask(10);
		Mockito.verify(taskDao).findOne(10);
		
		assertNotNull(res);
		assertNull(res.getIdTask());
		assertTrue(res.getIdTask() == 10);
		assertTrue(res != null);
		
	}
	
	@Test(expected = NotFoundException.class)
	public void shouldThrowEx() throws SQLException{
		Mockito.when(taskDao.findOne(10)).thenThrow(EmptyResultDataAccessException.class);
		
		Task res = taskService.getTask(10);
		assertNull(res);
	}
	
	
}
