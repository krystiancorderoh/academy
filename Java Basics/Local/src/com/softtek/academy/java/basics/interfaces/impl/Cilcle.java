package com.softtek.academy.java.basics.interfaces.impl;

import com.softtek.academy.java.basics.interfaces.Figure;

public class Cilcle implements Figure{
	
	private final double PI = 3.1416;
	private double r;
	
	@Override
	public double getArea() {
		
		return Math.pow(r, 2) * PI;
	}
	
	@Override
	public void getCommonFunctionality() {
		
		String color = Figure.COLOR;
		System.out.println("I´m a circule" + color);
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	
	
	

}
