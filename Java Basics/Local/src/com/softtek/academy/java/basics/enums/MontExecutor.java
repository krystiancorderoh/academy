package com.softtek.academy.java.basics.enums;

public class MontExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mes = MonthEnum.MAY.toString();
		
		for (MonthEnum month: MonthEnum.values()) {
			System.out.println(month);
		}
		
		MonthEnum myMonth = MonthEnum.APRIL;
		
		//switch (myMonth)
		
		
	}

}
