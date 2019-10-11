package com.softtek.academy.java.basics.condicionals;

public class Number {
	
	public boolean isPositiveNumber(int num) {
		
		boolean isPositive = false;
		
		if(num > 0) {
			isPositive = true;
		}else {
			isPositive = false;
		}
		return isPositive;
	}

}
