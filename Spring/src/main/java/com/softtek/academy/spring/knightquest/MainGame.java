package com.softtek.academy.spring.knightquest;

public class MainGame {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		Knight knight = context.getBean(Knight.class);
		System.out.println("nombre caballero"+ knight.getName());
		knight.startQuest();
	}

}
