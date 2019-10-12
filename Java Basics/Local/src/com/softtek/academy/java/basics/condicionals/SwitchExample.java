package com.softtek.academy.java.basics.condicionals;

public class SwitchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 15;
		
		if(age <18) {
			if(age <15) {
				if(age <10) {}
			}
			
		}else if(age < 30) {
			
		}else if(age < 60) {
			
		}
			
			
		switch (age) {
		case 10:
			System.out.println("Kid");
			break;
		case 15:
			System.out.println("Teenager super tennager adult ");
			break;
		case 18:
			System.out.println("super tennager adult ");
			break;
		case 30:
			System.out.println("adult");
			break;

		default:
			System.out.println("dont know");
			break;
		}	
		

	}

}
