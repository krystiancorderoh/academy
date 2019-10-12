package com.softtek.academy.java.basics.secondDayExercises;

public class invertPhrase {

	public static void main(String[] args) {
		// En base al string “This is Java Language”, 
		// insertar cada character en un array e invertir la frase, mostrarla en pantalla .

		String cadena = "This is Java Language";
		char[] arreglo = new char[cadena.length()];
		
		
		for (int i = 0;i<cadena.length(); i++ ) {
			
			arreglo[i] = cadena.charAt(i);
			
		}
		
		for (int i = cadena.length()-1;i>=0; i-- ) {
			
			 System.out.println(arreglo[i]);
			
		}
		
		
	}

}
