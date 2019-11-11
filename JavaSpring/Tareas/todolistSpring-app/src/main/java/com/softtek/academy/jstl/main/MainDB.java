package com.softtek.academy.jstl.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softtek.academy.jstl.dao.TaskDao2;

public class MainDB {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context= 
			new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
	
		TaskDao2 dao = context.getBean(TaskDao2.class);
		
		System.out.println(" "+dao.getItemCount());
		
		System.out.println("get id = " + dao.findOne(1));
		
		System.out.println("Get Items less than "+dao.getItemLessThan(3));
		
		context.close();
	}
}
