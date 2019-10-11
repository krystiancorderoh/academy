package com.softtek.academy.java.basics.condicionals;

public class NumberExecutor {

	public static void main(String[] args) {
			
		int num = -15;
		Number myNumber = new Number();
		
		if(myNumber.isPositiveNumber(num)) {
			System.out.println("Is Positive");
		}else {
			System.out.println("Is negative");
		}
		
	}

}
