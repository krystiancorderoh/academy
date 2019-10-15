package com.softtek.academy.java.basics.secondDayExercises;

import java.util.Scanner;

public class CuentaPalabrasDuplicadas {

	public static void main(String[] args) {
		// Pedir en consola una frase con palabras duplicadas, 
		// cada palabra será insertada como un elemento de array de strings, 
		// identificar qué palabras son las que aparecen más de una vez.
		
		System.out.println("Dame una frase con palabras duplicadas ");
		Scanner sc = new Scanner(System.in);
		
		String cadena = sc.nextLine();
		String [] arreglo = cadena.split(" ");
		
		int contador;
		String temp1 ="";
		String temp2 ="";
		for(int j=0; j< (arreglo.length) - 1 ; j++) {
			
			contador = 0;
			for (int i=j+1;i < arreglo.length;i++) {
				
				if(arreglo[j].equals(arreglo[i]) && !arreglo[j].equals("")) {
				
					contador++;
					
					arreglo[i]="";
				}
				
			}
			if(contador>0) {
				
				System.out.println("La Palabra: "+arreglo[j]+" aparece "+(contador+1)+" veces");
			}
				
		}
			

	}

}
