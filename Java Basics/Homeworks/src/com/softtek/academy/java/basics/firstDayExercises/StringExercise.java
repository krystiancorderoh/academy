package com.softtek.academy.java.basics.firstDayExercises;

public class StringExercise {

	public static void main(String[] args) {
		
		String cadena = " Java ";
		
		System.out.println(cadena.replace(" ",""));
		
		cadena = "This is Java Language";
		
		System.out.println(cadena.substring(8,12));
		
		System.out.println(cadena.indexOf("Java"));
		
		System.out.println(cadena.indexOf("Language"));
		System.out.println(cadena.replace("Language","Technology"));
		
		//De la oración: "This is Java Language", imprímelo todo en minúsculas
		
		System.out.println(cadena.toLowerCase());
		
		//De la oración: "This is Java Language", imprímelo todo en mayúsculas
		
		System.out.println(cadena.toUpperCase());
		
		

	}

}
