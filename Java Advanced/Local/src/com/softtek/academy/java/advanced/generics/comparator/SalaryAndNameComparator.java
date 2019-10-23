package com.softtek.academy.java.advanced.generics.comparator;

import java.util.Comparator;

import com.softtek.academy.java.advanced.generics.Employee;

public class SalaryAndNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int result = (int)(o1.getSalary() - o2.getSalary());
		if (result == 0) {
			
			result= o1.getName().compareTo(o2.getName());
			
		}
		return result;
	}
	
	

}
