package com.softtek.academy.java.basics.secondDayExercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		//  Pedir en consola un número que indique la cantidad 
		//  de números primos a mostrar y en base al número mostrar 
		//  los números primos, por ejemplo:
		//  	¿Cuántos números primos quieres? ---- 6
		//		Resultado: 2, 3, 5, 7, 11, 13
		
		Scanner sc = new Scanner(System.in);
		
		int cont = 0;
		
		ArrayList<Integer> primos = new ArrayList<Integer>();
		
		primos.add(2); 
		
		System.out.println("How many prime numbers do you want? ");
		
		int num = Integer.parseInt(sc.nextLine());
		
		Iterator<Integer> myIterator;
		
		for (int i =3; i<1000; i++) {
			
			myIterator = primos.iterator();
			
			while(myIterator.hasNext()){
				
				
				int elemento = myIterator.next();
				
				if(i/2 >= elemento) {
					
					
					
				}else {
					break;
				}
				
				
				System.out.print(elemento+" / ");
			}
			
				
		}
			

		
		

	}

}
