package com.softtek.academy.java.basics.secondDayExercises;

import java.util.Scanner;

public class PairOrOdd {

	public static void main(String[] args) {
		//Pedir un número en consola y mostrar en pantalla si es par o impar.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Give me a number: ");
		
		int num = Integer.parseInt(sc.nextLine());
		
		if (num % 2 == 0) {
			System.out.println("The number is Pair");
		}else {
			System.out.println("The number is Odd");
		}
	}

}
