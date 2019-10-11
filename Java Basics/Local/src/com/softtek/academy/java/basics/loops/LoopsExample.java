package com.softtek.academy.java.basics.loops;

public class LoopsExample {

	public static void main(String[] args) {
		// There are 4 looping structures for executing
		
		//one block multiple
		
		//while, do while. for . for each
		
		int loop = 5;
		
		int i=0;
		
		while(i<loop) {
			
			System.out.println("loop " +i);
			i++;
		}
		
		do{
			i--;
			System.out.println("loop " +i);
			
		}while(i>0);
		
		for(int x = 0;x<10;x++) {
			System.out.println(x);
		}
		
		int x = 0;
		for(;x<10;x++) {
			System.out.println(x);
		}
		System.out.println(x);
		

	}

}
