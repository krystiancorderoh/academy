package com.softtek.academy.java.advanced.generics;

public class Pair <T> {
	
	private T first;
	private T second;
	
	public Pair() {
		first = null;
		second = null;
	}

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
	
	// getMiddle (1,2,3,4) => [1,2,3,4]
	public static <T>T getMiddle(T... a){
		return a[a.length/2];
	}
	

}
