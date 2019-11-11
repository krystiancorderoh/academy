package com.softtek.academia.spring.knightquest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class King {
	
	private String name;

	@Autowired
	@Qualifier("killDragonQuest")
	private Quest quest;
		
	public void startQuest() {
		System.out.println("El rey es "+name);
		this.quest.start();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}
}
