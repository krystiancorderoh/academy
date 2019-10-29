package com.softtek.academy.java.basics.examen;

import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		TaskWithDeadline task1 = new TaskWithDeadline();
		TaskWithDeadline task2 = new TaskWithDeadline("en proceso");
		
		task1.setName("Terminar el examen");
		task2.setName("Apurarse");
		//task1.setDueDate("2019-10-29");
		//System.out.println(task1.getReminder());
	}

}
