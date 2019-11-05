package com.softtek.javaacademy.bestpractices.separatepakage;

import java.util.Arrays;

/**
 * 
 * @author Jose Moreno
 */
public class UtilMathOperations {
	/**
	* Suma todos los digitos de un numero
	* @param num 	numero del cual se obtendra la suma de sus digitos
	* @return 		resultado de la suma de los digitos
	*/
	public int sumOfDigits(int num) {
        if (num != 0) {
            return (num % 10 + sumOfDigits(num / 10)); //calling the function itself recursively
        } else {
            return 0;
        }
    }
	
	/**
	 * Evaluar si un numero es par o no
	 * @param num 	numero a evaluar
	 * @return true or false
	 */
	public boolean evaluateParity(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * Generar una piramide de numeros
	 * @param num 	numero que va en el tope de la piramide
	 * @return true or false
	 */
	public void generateNumbersPyramid(int n) {
		
		String renglon = "";
        for(int i = 1; i <= n  ; i++) {
        	for(int j= 1; j<=i; j++) {
        		renglon += Integer.toString(j);
        	}
        	System.out.println(renglon);
        	renglon="";
        }
        for(int i = n-1; i >= 1  ; i--) {
        	for(int j= 1; j<=i; j++) {
        		renglon += Integer.toString(j);
        	}
        	System.out.println(renglon);
        	renglon="";
        }
    }
	
	/**
	 * Contar numeros diferentes en un arreglo
	 * @param numeros	arreglo de numeros que se evaluara
	 * @return true or false
	 */
	public int countArray(int[] numeros) {
		
		int contador = 1;
		
		Arrays.sort(numeros);
		
		for(int i= 1; i<numeros.length; i++ ) {
			if (numeros[i] != numeros[i-1]) {
				contador++;
			}
		}
		return contador;
	}
	
}
