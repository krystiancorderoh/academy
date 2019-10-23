package com.softtek.academy.java.advanced.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.softtek.academy.java.advanced.generics.comparator.SalaryComparator;

public class Main {
	
	Employee empleado1 = new Employee("Krystian", 45000, 2019, 10, 21);
	Employee empleado2 = new Employee("Stephania", 45000, 2022, 11, 23);
	Employee empleado3 = new Employee("Canche", 20000, 2018, 03, 3);
	Employee empleado4 = new Employee("Griselda", 60000, 2040, 8, 13);
	Employee empleado5 = new Employee("Jesus", 23000, 2020, 4, 1);
	Employee empleado6 = new Employee("Efren", 40000, 2035, 5, 3);
	Employee empleado7 = new Employee("Lambo", 39000, 2019, 10, 22);
	Employee empleado8 = new Employee("Eduardo", 28000, 2019, 10, 20);
	Employee empleado9 = new Employee("Emiliano", 25518, 2019, 9, 21);
	Employee empleado10 = new Employee("Sanabia", 39002, 2018, 2, 18);
	Employee empleado11 = new Employee("Levi", 35000, 2017, 8, 7);
	Employee empleado12 = new Employee("Paco", 25000, 2019, 10, 21);
	
	
	public static void main(String[] args) {
		System.out.println(Pair.getMiddle("a","b","c"));
		Main myMain = new Main();
		myMain.callingGenerics();
		//myMain.sortingEmployees();
		myMain.getSet();
		
	}
	
	public void callingGenerics() {
		
		Pair<Employee> pairEmp = new Pair<>(empleado1,empleado2);
		
		Manager ceo = new Manager("Krystian", 45000, 2019, 10, 21,100);
		Manager cfo = new Manager("Stephania", 45000, 2022, 11, 23,50);
		
		Pair<Employee> pairMan = new Pair<>(ceo, cfo);
		
		System.out.println(pairMan);
		
		
	}
	
	public void sortingEmployees() {
		
		List<Employee> empleados = new ArrayList<>();
		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
		empleados.add(empleado4);
		empleados.add(empleado5);
		empleados.add(empleado6);
		empleados.add(empleado7);
		empleados.add(empleado8);
		empleados.add(empleado9);
		empleados.add(empleado10);
		empleados.add(empleado11);
		empleados.add(empleado12);
		
		
		
		//Collections.sort(empleados);
		Collections.sort(empleados, new SalaryComparator());
		
		for(Employee e: empleados) {
			System.out.println(e.toString());
			
		}
		
	}
	
	public void getSet() {

		Set<Employee> empleados = new HashSet<>();
		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
		empleados.add(empleado4);
		empleados.add(empleado5);
		empleados.add(empleado6);
		empleados.add(empleado7);
		empleados.add(empleado8);
		empleados.add(empleado9);
		empleados.add(empleado10);
		empleados.add(empleado11);
		empleados.add(empleado12);
		
		for(Employee e: empleados) {
			System.out.println(e.toString());
		}
		
	}
	
	public void getMap() {
		Map<String, Employee> empleados = new HashMap<>();
		empleados.put(empleado1.getName(),empleado1);
		empleados.put(empleado2.getName(),empleado2);
		empleados.put(empleado3.getName(),empleado3);
		empleados.put(empleado4.getName(),empleado4);
		empleados.put(empleado5.getName(),empleado5);
		empleados.put(empleado6.getName(),empleado6);
		empleados.put(empleado7.getName(),empleado7);
		empleados.put(empleado8.getName(),empleado8);
		empleados.put(empleado9.getName(),empleado9);
		empleados.put(empleado10.getName(),empleado10);
		empleados.put(empleado11.getName(),empleado11);
		empleados.put(empleado12.getName(),empleado12);
		
		Iterator<Employee> myIterator = empleados.values().iterator();
		while(myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}
		
		
	}
}
