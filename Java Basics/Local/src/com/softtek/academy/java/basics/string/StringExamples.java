package com.softtek.academy.java.basics.string;

import java.util.Scanner;

public class StringExamples {

	public static void main(String[] args) {
		// String is nor-primitive, is an objet
		
		String myString = new String();
		myString = "hello";
		System.out.println(myString);
		
		String myStringConstructor = new String("In constructor");
		String myStringEasy = "Just";
		
		myStringEasy = myStringEasy + " this";
		myStringEasy += " easy";
		System.out.println(myStringEasy.contains("easy"));
		
		//comparing two strings
		
		String one = "JAVA";
		String two = "java";
		
		System.out.println(one.equalsIgnoreCase(two));
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Type something: ");
		
		String typed = sc.nextLine();
		
		typed += " plus";
		
		System.out.println(typed);
		
		
	}

}
