package com.softtek.academy.java.basics.firstDayExercises;

public class StringBufferExercise {

	public static void main(String[] args) {
		// De la oraci�n: "This is Java Language", imprime la longitud
		
		StringBuffer cB = new StringBuffer("This is Java Language");
		
		System.out.println(cB.length());
		
		//De la oraci�n: "This is Java Language", imprimela al rev�s
		
		System.out.println(cB.reverse());
		
		//De la oraci�n: "This is Java Language", imprime solo la palabra "Java"
		
		cB.reverse();
		
		System.out.println(cB.substring(8,12));
		
		//De la oraci�n: "This is Java Language", elimina la palabra Java e imprime la nueva oraci�n
		
		
		System.out.println(cB.delete(7,12));
		
		
	}

}
