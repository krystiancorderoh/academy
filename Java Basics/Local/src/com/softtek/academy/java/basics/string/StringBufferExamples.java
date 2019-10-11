package com.softtek.academy.java.basics.string;

public class StringBufferExamples {

	public static void main(String[] args) {
		// String vs StringBuffer
		// String creates an objet everytime using +
		// StringBuffer is only an objet that can be modified and then convert to String
		
		StringBuffer sb = new StringBuffer();
		sb.append("Name: ");
		
		System.out.println(sb);
		
		sb.append(" Last Name: ");
		System.out.println(sb);
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Name");

	}

}
