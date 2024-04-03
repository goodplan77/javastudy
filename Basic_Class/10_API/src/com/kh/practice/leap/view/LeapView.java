package com.kh.practice.leap.view;

import com.kh.practice.leap.controller.LeapController;
import java.util.Calendar;

public class LeapView {

	public LeapView() {
		LeapController lc = new LeapController();
		Calendar today = Calendar.getInstance();

		boolean isLeapYear = lc.isLeapYear(today.get(Calendar.YEAR));
		String result = isLeapYear ? "윤년" : "평년";
		System.out.println(today.get(Calendar.YEAR) + "년은 " + result + "입니다.");

		long sumDate = lc.leapDate(today);
		System.out.println("총 날짜 수 : " + sumDate);
	}
}
