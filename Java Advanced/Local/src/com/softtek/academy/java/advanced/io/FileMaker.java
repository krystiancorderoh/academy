package com.softtek.academy.java.advanced.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileMaker {

	public static void main(String[] args) {
		try {
			getTextOfFile("test.txt");
			writeInFile("test.txt");
		}catch(FileNotFoundException fileE) {
			System.out.println(fileE.getMessage());
		}catch(IOException ioE) {
			System.out.println(ioE.getMessage());
		}
		
	}
	
	//public static void getTextOfFile(String fileName) throws FileNotFoundException, IOException {
	public static void getTextOfFile(String fileName) throws FileNotFoundException, IOException {
		String fileLine = null;
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		while((fileLine = br.readLine()) != null) {
			System.out.println(fileLine);
		}
		
		br.close();
		fr.close();
	}
	
	public static void writeInFile(String fileName) {
		try {
			File myFile = new File(fileName);
			PrintWriter printWriter = new PrintWriter(myFile);
			printWriter.println("username=krystian");
			printWriter.println("email=krystian@softtek.com");
			printWriter.println("is=KCOH");
			
			printWriter.close();
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
