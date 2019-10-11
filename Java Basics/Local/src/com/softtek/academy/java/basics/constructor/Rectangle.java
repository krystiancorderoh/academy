package com.softtek.academy.java.basics.constructor;

public class Rectangle {
	
	int x,y;
	
	public Rectangle() {
		
		y = 20;
		x = 10;
		
	}
	
	public Rectangle(int x) {
		
		this.x = x;
		
	}
	
	public Rectangle(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}

	public static void main(String[] args) {
		
		Rectangle myRectangle = new Rectangle();
		System.out.println("X: "+ myRectangle.x);
		System.out.println("Y: "+ myRectangle.y);
		
		Rectangle myRectangle2 = new Rectangle(50);
		System.out.println("X: "+ myRectangle2.x);
		
		Rectangle myRectangle3 = new Rectangle(50,100);
		System.out.println("X: "+ myRectangle3.x);
		System.out.println("Y: "+ myRectangle3.y);

	}

}
