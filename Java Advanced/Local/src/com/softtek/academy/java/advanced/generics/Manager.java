package com.softtek.academy.java.advanced.generics;

public class Manager extends Employee{
	
	private double bonus;

	public Manager(String name, double salary, int year, int month, int day, double bonus) {
		super(name, salary, year, month, day);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	

}
