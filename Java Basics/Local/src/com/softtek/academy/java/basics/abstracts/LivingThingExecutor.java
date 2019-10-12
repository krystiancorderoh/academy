package com.softtek.academy.java.basics.abstracts;

public class LivingThingExecutor {

	public static void main(String[] args) {
		
		LivingThing human = new Human();
		human.walk();
		human.eat();
		human.breath();
		//human.extraMethod();
		
		Human onlyHuman = new Human();
		
		onlyHuman.walk();
		onlyHuman.eat();
		onlyHuman.breath();
		onlyHuman.extraMethod();
		
		LivingThing[] arrayThings = new LivingThing[2];
		arrayThings[0] = new Human();
		//arrrayThings[1] = new Animal();
		
		for(LivingThing thing: arrayThings) {
			thing.breath();
		}
		
	}

}
