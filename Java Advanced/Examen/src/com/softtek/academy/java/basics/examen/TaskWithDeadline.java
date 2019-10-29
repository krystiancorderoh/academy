package com.softtek.academy.java.basics.examen;

import java.text.ParseException;
import java.util.Date;

public class TaskWithDeadline extends Task implements TaskRecurrent{
	
	
	TaskWithDeadline() {
		super.setStatus("pendiente");
	}
	
	TaskWithDeadline(String status) {
		super.setStatus(status);
	}
	
	protected String dayOfWeek;
	protected String dayOfMonth;

	
	public int getReminder() throws ParseException {
		
		Date today = new Date();
		Date dueDate = super.getDueDate();
		int days=(int) ((dueDate.getTime() - today.getTime())/86400000);
		return days;
	}
	
	@Override
	public void setDayOfWeek(String dw) {
		dayOfWeek = dw;
	}

	@Override
	public void setDayOfMonth(String dm) {
		dayOfMonth = dm;
	}
	
	
}
