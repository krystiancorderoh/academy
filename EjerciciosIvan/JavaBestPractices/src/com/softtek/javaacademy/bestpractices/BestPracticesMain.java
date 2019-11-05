package com.softtek.javaacademy.bestpractices;

import com.softtek.javaacademy.bestpractices.separatepakage.Calculator;
import com.softtek.javaacademy.bestpractices.separatepakage.UtilMathOperations;

public class BestPracticesMain {
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		UtilMathOperations utilMathOperations = new UtilMathOperations();
		
		int[] numeros = {1,2,2,3,4,5,5,6};
		
		int resultadoSuma = calculator.additionOfTwoNumbers(2, 2);
		int resultadoResta = calculator.substractionOfTwoNumbers(10, 2);
		int resultadoMultiplicacion = calculator.multiplicationOfTwoNumbers(3, 4);
		double resultadoDivision = calculator.divisionOfNumbers(64, 6);
		
		int resultadoSumaDigitos = utilMathOperations.sumOfDigits(1234);
		boolean isPair =  utilMathOperations.evaluateParity(8);
		int numerosDiferentes = utilMathOperations.countArray(numeros);
		
		System.out.println("El Resultado de la suma es: " + resultadoSuma );
		System.out.println("El resultado de la resta es: " + resultadoResta);
		System.out.println("El resultado de la multiplicación es: " + resultadoMultiplicacion);
		System.out.println("El resultado de la división es: " + resultadoDivision);
		
		System.out.println("El Resultado de sumar los digitos de N es: " + resultadoSumaDigitos);
		if (isPair) {
			System.out.println("El número es par");
		}else {
			System.out.println("El número es impar");
		}
		
		utilMathOperations.generateNumbersPyramid(8);
		
		System.out.println("El Arreglo tiene: " + numerosDiferentes + " números diferentes");
		
	}
	
}

