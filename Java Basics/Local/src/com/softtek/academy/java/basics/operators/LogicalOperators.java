package com.softtek.academy.java.basics.operators;

import java.util.Scanner;

public class LogicalOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 10;
		
		Scanner sc = new Scanner(Sistem.in);
		
		System.out.println("First: ");
		
		int x = sc.nextInt();
		
		System.out.println("Second: ");
		
		int y = sc.nextInt();
		
		Calculator myCalculator = new Calculator();
		
		//grater tan
		
		System.out.println("Greater? ");
		System.out.println(myCalculator.getSum(x, y) > n);
		
		//grater tan or equal to 
		
				System.out.println("Greater or equal?");
				System.out.println(myCalculator.getSum(x, y) > n);
				
				//grater and 
				
				System.out.println("Greater or equal?");
				System.out.println(n > 1    );
				
		

	}

}
