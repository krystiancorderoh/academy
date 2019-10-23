package com.softtek.academy.java.advanced.generics;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{
//public class Employee {
	@Override
	
	public int compareTo(Employee o) {

		return (int)(this.salary - o.getSalary());
		//return o.getName();
	}
	
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name, double salary, int year,int month, int day) {
		super();
		this.name = name;
		this.salary = salary;
		this.hireDay = LocalDate.of(year, month, day);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void setHireDay(LocalDate hireDay) {
		this.hireDay = hireDay;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Employee)obj).getName());
	}
	
	

}
