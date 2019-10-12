package com.softtek.academy.java.basics.abstracts;

public abstract class LivingThing {
	
	private String name;
	public abstract void walk();
	
	public void breath() {
		System.out.println("Breathing..name.");
	}
	public void eat() {
		System.out.println("eat living thing.");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
