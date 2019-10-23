package com.softtek.academy.java.advanced.generics;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetOfStrings {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		set.add("hola 1");
		set.add("hola 2");
		set.add("hola 2");
		
		for(String s: set) {
			//System.out.println(s);
			
		}
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("mundo 1");
		set2.add("mundo 2");
		
		set.addAll(set2);
		
		for(String s: set) {
			//System.out.println(s);
			
		}
		
		List<String> list = new ArrayList<String>();
		list.add("maravilloso 1");
		list.add("maravilloso 2");
		
		for(String s: list) {
			//System.out.println(s);
			
		}
		
		set.addAll(list);
		
		for(String s: set) {
			//System.out.println(s);
			
		}
		
		TreeSet<String> treeSet = new TreeSet<String>(set);
		
		for(String s: treeSet) {
			System.out.println(s);
			
		}
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("hola 1");
		set3.add("hola 2");
		
		HashSet<String> set4 = new HashSet<String>();
		set4.add("hola 1");
		set4.add("hola 3");
		
		if (comparaSets(set3,set4))
			System.out.println("Los sets son iguales");
	}
	public static boolean comparaSets(Set<String> s1,Set<String> s2) {
		
		return s1.equals(s2);
		
	}

}
