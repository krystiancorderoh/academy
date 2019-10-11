package com.softtek.academy.java.basics.firstDayExercises;

import java.util.Scanner;

public class NumbersExercise {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Primer número: ");
		
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("Segundo número: ");
		
		
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("La suma de ambos numeros es: "+ (num1+num2));
	
	}

}
