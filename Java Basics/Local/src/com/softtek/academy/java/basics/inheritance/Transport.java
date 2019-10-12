package com.softtek.academy.java.basics.inheritance;

public class Transport {

	String color;
	private int year;
	protected String model;
	public String ruta;
	
	public Transport() {
		
		System.out.println("Empty constructor");
	}
	
	public Transport(int spinTimes) {
		
		this.spin(spinTimes);
		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	protected void accelerate(final int kmHour) {
		//kmHour = 5;
		System.out.println("I am accelerating to: " + kmHour);
		
	}
	
	private void spin(final int times) {
		 System.out.println("I am going ti spin " + times + "times");
		
	}
	
	public void go() {
		
		this.ruta = "Blv Costero";
		this.year = 2019;
		this.model= "tesla";
		this.color= "blue";
		System.out.println("...going");
		
	}
	
	
}
