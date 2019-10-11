package com.softtek.academy.java.basics.arrays;

public class ArraysExample {

	public static void main(String[] args) {
		// data structure that save a collection of values
		// int[] array Name
		
		int[] arrayNumbers = new int[4];
		
		int[] arrayByValue = {4,20,12,11};
		
		arrayNumbers[0] = 4;
		arrayNumbers[1] = 20;
		arrayNumbers[2] = 12;
		arrayNumbers[3] = 11;
		
		for(int x=0;x < arrayNumbers.length; x++) {
			System.out.println(arrayNumbers[x]);
		}
		
		for(int number: arrayByValue) {
			System.out.println(number);
		}

	}

}
