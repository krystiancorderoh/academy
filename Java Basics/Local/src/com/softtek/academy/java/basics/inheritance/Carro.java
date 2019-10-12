package com.softtek.academy.java.basics.inheritance;

public class Carro extends Transport{

	public Carro() {
		super(5);
		go();
		//this.color = super.color;
		this.model = "Volkswagen";
		//this.ruta = super.ruta;
		
		
	}
//	@Override
	public void go() {
		super.go();
		System.out.println("car going");
		
	}
	
}
