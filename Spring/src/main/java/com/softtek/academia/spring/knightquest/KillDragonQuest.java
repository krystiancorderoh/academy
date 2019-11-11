package com.softtek.academia.spring.knightquest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KillDragonQuest implements Quest {

	private String startDate;

	public void start() {
		System.out.println("Let's kill the Dragon! on " +this.startDate);
	}

	public void setStartDate(String fecha) {
		this.startDate=fecha;
	}
}
