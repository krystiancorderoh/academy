package com.softtek.academy.java.advanced.exeptions;

import java.util.Arrays;

public class ExceptionExample {

	public static void main(String[] args) {
		
		try {
		System.out.println(modificaCadena("hola hola cara cara papa papa "));
		}
		catch(TamanoIncorrectoException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String modificaCadena(String cadena) throws TamanoIncorrectoException{
		if (cadena.length() > 30) {
		      throw new TamanoIncorrectoException();
		}
		return cadena.substring(0,20).toUpperCase();
		
	}

}
