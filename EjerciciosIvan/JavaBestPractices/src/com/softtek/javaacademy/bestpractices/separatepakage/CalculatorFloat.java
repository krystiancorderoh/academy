package com.softtek.javaacademy.bestpractices.separatepakage;

public class CalculatorFloat extends Calculator{
	
	public float additionOfTwoNumbers(float num1, float num2) {
		return num1 + num2;
	}
	
	public float substractionOfTwoNumbers(float num1, float num2) {
		 return num1 - num2;
	}
	
	public float multiplicationOfTwoNumbers(float num1, float num2) {
		return num1 * num2;
	}
	
	public double divisionOfNumbers(float num1, float num2) {
		return (double)num1 / (double)num2;
	}

}
