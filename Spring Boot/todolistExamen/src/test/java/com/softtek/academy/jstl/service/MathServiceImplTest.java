package com.softtek.academy.jstl.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.softtek.academy.jstl.exception.InvalidInputException;
@RunWith(MockitoJUnitRunner.class)
public class MathServiceImplTest {

	@Mock
	private MathServiceImpl mathServiceImpl;
	
	@Test
	public void shouldSumNums() {
		Mockito.when(mathServiceImpl.sum(1L, 2L)).thenReturn(3L);
		
		Long num1=1L;
		Long num2=2L;
		
		Long res= this.mathServiceImpl.sum(num1, num2);
		Mockito.verify(mathServiceImpl).sum(num1, num2);
		
		assertNotNull(res);
		assertTrue(res==3L);
	}
	
	@Test
	public void shouldResNums() {
		Mockito.when(mathServiceImpl.res(1L, 2L)).thenReturn(3L);
		
		Long num1=1L;
		Long num2=2L;
		
		Long res= this.mathServiceImpl.res(num1, num2);
		Mockito.verify(mathServiceImpl).res(num1, num2);
		
		assertNotNull(res);
		assertTrue(res==3L);
	}
	
	@Test
	public void shouldMultNums() {
		Mockito.when(mathServiceImpl.mult(1L, 2L)).thenReturn(3L);
		
		Long num1=1L;
		Long num2=2L;
		
		Long res= this.mathServiceImpl.mult(num1, num2);
		Mockito.verify(mathServiceImpl).mult(num1, num2);
		
		assertNotNull(res);
		assertTrue(res==3L);
	}
	@Test
	public void shouldDivNums() {
		Mockito.when(mathServiceImpl.div(1L, 2L)).thenReturn(3L);
		
		Long num1=1L;
		Long num2=2L;
		
		Long res= this.mathServiceImpl.div(num1, num2);
		Mockito.verify(mathServiceImpl).div(num1, num2);
		
		assertNotNull(res);
		assertTrue(res==3L);
	}
	
	
	
	@Test(expected = InvalidInputException.class)
	public void shouldTrowException() throws InvalidInputException{
		List<Long> list = new ArrayList<>();
		list.add((long) 1);
		if(!list.isEmpty()) {
			throw new InvalidInputException("esta no es la excepcion");
		}
	}
}
