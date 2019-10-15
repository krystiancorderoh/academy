package com.softtek.academy.java.basics.enums;

public enum WeekEnum {
	
	MONDAY(1,"Lunes"),
	TUESDAY(2,"Martes"),
	WEDNESDAY(3,"Miercoles");
	
	private int num;
	private String spanishName;
	
	private WeekEnum(final int num, final String spanishName) {
		
		this.num = num;
		//this.spanishName; 
		
	}
	
	@Override
	public String toString() {
		
		//5 (Name: Viernes )
		
		StringBuffer sb = new StringBuffer();
		return "";
		
	}

}
