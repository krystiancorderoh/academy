package com.softtek.academy.spring.knightquest;

public class SavePrincessQuest implements Quest{
	
	String startDate;
	public void start() {
		
		System.out.println("salvar princesa");
		
	}

	public void setStarDate(String fecha) {
		this.startDate = fecha;
	}

}
