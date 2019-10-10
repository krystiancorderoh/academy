package com.softtek.academy.java.basics.methods;

public class MethodsExample {

	int variableInstance;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsExample myClass = new MethodsExample();
		myClass.getOutsideMethod();
		System.out.println(myClass.variableInstance);
		System.out.println(myClass.getOutsideMethodWithReturn());
		
	}
	
	
	public void getOutsideMethod() {
		
		String message = "Send message";
		this.getOutsideMethod2(message, message);
		getOutsideMethod2(message, message);
		
	}
	public void getOutsideMethod2(String message1, String message2) {
		
		System.out.println(message1);
		System.out.println(message2);
		
	}
	
	public String getOutsideMethodWithReturn() {
		
		String newMessege = "Metrod asdf";
		return newMessege;
	}

}
