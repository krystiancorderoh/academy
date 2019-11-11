package com.softtek.academia.spring.instrumentos;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBand {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("META-INF/spring/instrumentsContext.xml");
		
		OneManBand man=context.getBean(OneManBand.class);
		man.playSong();
	}
}
