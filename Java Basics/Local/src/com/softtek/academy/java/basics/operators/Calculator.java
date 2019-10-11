package com.softtek.academy.java.basics.operators;

public class Calculator {

	//Addittion
	public int getSum(int x,int y) {
		
		int total = 0;
		total = x + y;
		return total;
	}
	
	//Substraction
		public int getSubstraction(int x,int y) {
			
			return x-y;
		}
	
		//Multiplication
				public int getMultiplication(int x,int y) {
					
					return (x*y);
				}
				
				//Division
				public float getDivision(int x,int y) {
					
					return (x/y);
				}
				//Modulus
				public float getMod(int x,int y) {
					
					return (x%y);
				}
				//Is positive
				public boolean isPositive(int x) {
					
					return x > 0;
				}
}

