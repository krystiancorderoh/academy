package com.softtek.academy.spring.knightquest;

public class KillDragonQuest implements Quest{

	String startDate;

	
	public void start() {
		System.out.println("matar al dragon");
		
	}

	public void setStarDate(String fecha) {
		this.startDate = fecha;
	}

}
