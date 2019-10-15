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
		
		System.out.println("How many prime numbers do you want? ");
		
		int num = Integer.parseInt(sc.nextLine());
		
		ArrayList<Integer> primos = new ArrayList<Integer>();
		
		primos.add(2); 
		
		Iterator<Integer> myIterator;
		
		boolean bandera = false;
		
		for (int i =3; i<1000; i++) {
			
			myIterator = primos.iterator();
			
			while(myIterator.hasNext()){
				
				int primo = myIterator.next();
				
				if(primo > i/2) {
					
					break;
				}
				if( i % primo == 0) {
					
					bandera = true;
				}
			}
			if (!bandera) {
				primos.add(i);
			}
			bandera = false;
			if (primos.size() == num) {
				break;
			}
		}
		myIterator = primos.iterator();
		while(myIterator.hasNext()){
			int elemento = myIterator.next();
			System.out.print(elemento+" / ");
		}
	}

}
