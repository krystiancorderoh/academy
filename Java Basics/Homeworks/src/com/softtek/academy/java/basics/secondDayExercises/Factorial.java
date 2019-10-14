package com.softtek.academy.java.basics.secondDayExercises;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// Pedir un número en consola y calcular su factorial, mostrar el resultado.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Give me an integral number: ");
		
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("The Factorial of "+num+ " is: ");
		
		if (num != 0) {
			for (int i= num-1; i >= 1; i--) {
				
				num*=i;
			}
		}
		
		System.out.println(num);

	}

}
