package com.softtek.academy.spring.knightquest;

public class Knight {
	private String name= "Sir Krys";
	private Quest quest;
	
	public Knight(Quest quest) {
		this.quest = quest;
	}
	
	public void startQuest() {
		this.quest.start();
	}
	public String getName() {
		return name;
	}
	
	
}
