package com.softtek.academy.java.advanced.generics.comparator;

import java.util.Comparator;

import com.softtek.academy.java.advanced.generics.Employee;

public class SalaryComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getSalary() - o2.getSalary());
	}
	
	

}
