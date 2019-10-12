package com.softtek.academy.java.basics.firstDayExercises;

public class StringBufferExercise {

	public static void main(String[] args) {
		// De la oración: "This is Java Language", imprime la longitud
		
		StringBuffer cB = new StringBuffer("This is Java Language");
		
		System.out.println(cB.length());
		
		//De la oración: "This is Java Language", imprimela al revés
		
		System.out.println(cB.reverse());
		
		//De la oración: "This is Java Language", imprime solo la palabra "Java"
		
		cB.reverse();
		
		System.out.println(cB.substring(8,12));
		
		//De la oración: "This is Java Language", elimina la palabra Java e imprime la nueva oración
		
		
		System.out.println(cB.delete(7,12));
		
		
	}

}
