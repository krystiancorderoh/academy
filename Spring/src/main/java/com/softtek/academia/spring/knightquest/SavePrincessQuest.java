package com.softtek.academia.spring.knightquest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SavePrincessQuest implements Quest {

	String startDate;
	
	public void start() {
		System.out.println("Let's save the princess! On "+this.startDate);
	}

	public void setStartDate(String fecha) {
		this.startDate=fecha;
	}

}
