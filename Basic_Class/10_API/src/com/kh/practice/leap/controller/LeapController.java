package com.kh.practice.leap.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LeapController {

	public boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public long leapDate(Calendar c) {
		long sum = 0;
		int thisYear = c.get(Calendar.YEAR);
		int thisMonth = c.get(Calendar.MONTH) + 1;
		int thisDay = c.get(Calendar.DATE);
		

		for (int i = 1; i < thisYear; i++) {
			if (isLeapYear(i)) {
				sum += 366;
			} else {
				sum += 365;
			}
		}
		
		Calendar temp = Calendar.getInstance();
		temp.set(thisYear,0,1,0,0,0);
		sum += ((c.getTimeInMillis() - temp.getTimeInMillis())/1000/60/60/24);
		
		/*
		for (int j = 1; j < thisMonth; j++) {
			switch (j) {
			case 1, 3, 5, 7, 8, 10, 12:
				sum += 31;
				break;
			case 4, 6, 9, 11:
				sum += 30;
				break;
			case 2: {
				if (isLeapYear(thisYear)) {
					sum += 29;
				} else {
					sum += 28;
				}
				break;
			}
			}

		}

		sum += thisDay;
		*/

		return sum;
	}

}