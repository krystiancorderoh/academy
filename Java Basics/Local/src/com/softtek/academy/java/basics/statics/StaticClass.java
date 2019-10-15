package com.softtek.academy.java.basics.statics;

public class StaticClass {
	
	public static int x = 12;
	int y = 10;
	
	//Methods and variables statics that can ve accesed without instance
	public static void staticMethod() {
		
		StaticClass.x++;
		System.out.println();
	
		
	}
	public void nonStaticMethod(){
		y++;
		System.out.println("Non static method " + y);
		
	}

	
}
