package com.softtek.academia.spring.knightquest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainGame {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("META-INF/spring/kinghtContext.xml");
		
		Quest quest=context.getBean(KillDragonQuest.class);
		quest.setStartDate("Noviembre 2019");
		
		Knight knight= context.getBean(Knight.class);		
		System.out.println("Nombre del caballero "+knight.getName());
		knight.startQuest();
		
		quest.setStartDate("Enero 2020");
		King king= context.getBean(King.class);
		king.startQuest();
	}
}
