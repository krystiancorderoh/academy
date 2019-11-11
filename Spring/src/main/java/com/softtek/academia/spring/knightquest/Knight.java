package com.softtek.academia.spring.knightquest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Knight {

	@Value("#{settings['knight.name']}")
	private String name="Sir Yorch";
	
	@Autowired
	@Qualifier("savePrincessQuest")
	private Quest quest;
	

	public void startQuest() {
		this.quest.start();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setQuest(Quest quest) {
		this.quest=quest;
	}
}
