package com.softtek.academy.java.basics.interfaces.impl;

import com.softtek.academy.java.basics.interfaces.Figure;

public class Triangle implements Figure{
	
	private double b;
	private double h;

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (b*h)/2;
	}

	@Override
	public void getCommonFunctionality() {
		// TODO Auto-generated method stub
		System.out.println("I´m a triangle" + Figure.COLOR);
		
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	
	@Override
	public String toString() {
		return "I am apinty";
	}

}
