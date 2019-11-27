package com.softtek.academy.webservice_exam.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.academy.webservice_exam.dao.TaskDaoImp;
import com.softtek.academy.webservice_exam.domain.model.Task;
import com.softtek.academy.webservice_exam.exception.EmptyResultDataAccessException;
import com.softtek.academy.webservice_exam.exception.NotFoundException;

@RunWith(MockitoJUnitRunner.class)

public class TaskServiceImpTest {

	@Mock
	private TaskDaoImp taskDao;
	
	@InjectMocks
	private TaskServiceImp taskService;
	
	@Test
	public void testGetNullTask() throws SQLException {
		Mockito.when(taskDao.findOne(10)).thenReturn(null);
		
		Task res = taskService.findOne(10);
		Mockito.verify(taskDao).findOne(10);
		
		assertNull(res);
		assertTrue(res==null);
		
	}
	
	@Test
	public void testGetTask() throws SQLException {
		Mockito.when(taskDao.findOne(10)).thenReturn(new Task());
		
		Task res = taskService.findOne(10);
		Mockito.verify(taskDao).findOne(10);
		
		assertNotNull(res);
		assertTrue(res.getId()==0);
		assertTrue(res != null);
	}
	
	@Test
	public void testFindOneWithId() throws SQLException {
		Task task = new Task();
		task.setId(10);
		Mockito.when(taskDao.findOne(10)).thenReturn(task);
		
		Task res = taskService.findOne(10);
		Mockito.verify(taskDao).findOne(10);
		
		assertNotNull(res);
		assertNull(res.getId());
		assertTrue(res.getId() == 10);
		assertTrue(res != null);
		
		taskService.delete(10);
	    res = taskService.findOne(10);
		assertNull(res);
	}
	
	@Test(expected = NotFoundException.class)
	public void shouldThrowEx() throws SQLException{
		Mockito.when(taskDao.findOne(10)).thenThrow(EmptyResultDataAccessException.class);
		
		Task res = taskService.findOne(10);
		assertNull(res);
	}
}
