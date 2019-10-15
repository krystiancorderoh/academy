package com.softtek.academy.java.basics.secondDayExercises;

import java.util.Scanner;

public class Order {

	public static void main(String[] args) {
		// Pide 5 números por consola, crea un array de int y ordénalos de menor a mayor.
		
		System.out.println("Dame 5 numeros ");
		Scanner sc = new Scanner(System.in);
		int[] arrayNumbers = new int[5];
		int temp = 0;
		
		for(int i=0;i < 5; i++) {
			arrayNumbers[i] = Integer.parseInt(sc.nextLine());
		}
		
		for(int j=1; j< 5; j++) {
			for(int i=0;i < 4; i++) {
				
				if(arrayNumbers[i]>arrayNumbers[i+1]) {
						
					temp = arrayNumbers[i];
					arrayNumbers[i] = arrayNumbers[i+1];
					arrayNumbers[i+1] = temp;
								
				}
			}
		
		}
		System.out.println("Los numeros en orden acendente quedan asi: ");
		for(int i=0;i < 5; i++) {
			System.out.println(arrayNumbers[i]);
		}
	}

}
