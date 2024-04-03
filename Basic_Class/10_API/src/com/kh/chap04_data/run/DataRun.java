package com.kh.chap04_data.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataRun {

	public static void main(String[] args) {
		DataRun dr = new DataRun();
		dr.test4();
	}

	/*
	 * Calendar : 날짜와 시간에 관한 데이터를 손쉽게 처리 할 수 있는 추상 클래스 (국가마다 사용하는 달력 객체가 다르기 때문에 ,
	 * 나라마다 다른 달력 객체 반환을 위해 추상클래스로 만듬.)
	 */

	public void test1() {
		// 그레고리 달력 객체 생성
		Calendar cal1 = new GregorianCalendar();

		// 로컬 컴퓨터상의 지역정보 바탕으로 객체 자동생성
		Calendar cal2 = Calendar.getInstance();

		// 조회
		System.out.println(cal1.get(Calendar.YEAR)); // 년도
		System.out.println(cal1.get(Calendar.MONTH) + 1); // 월 (0부터 시작)
		System.out.println(cal1.get(Calendar.DATE)); // 일

		System.out.println(cal1.get(Calendar.HOUR)); // 시간
		System.out.println(cal1.get(Calendar.HOUR_OF_DAY)); // 24 기준 현재 시간
		System.out.println(cal1.get(Calendar.MINUTE)); // 분
		System.out.println(cal1.get(Calendar.SECOND)); // 초

		// 요일 구하기
		// (일 1 , 월 2 , 화 3 , 수 4 , 목 5 , 금 6 , 토 7)
		System.out.println(cal1.get(Calendar.DAY_OF_WEEK));
		char[] dayofWeek = { '일', '월', '화', '수', '목', '금', '토' };
		System.out.println("현재 요일은 " + dayofWeek[cal1.get(Calendar.DAY_OF_WEEK) - 1] + "요일 입니다.");

		printCalendar(cal1);

	}

	/*
	 * 특정일 기준으로 Calendar 객체 생성
	 */

	public void test2() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2024, 9, 1, 0, 0, 0); // 2024년 10월 1일 0시 0분 0초
		printCalendar(cal1);
		
		Calendar cal2 = new GregorianCalendar(2024,1,1,0,0,0); // 2024년 1월 1일 0시 0분 0초
		printCalendar(cal2);
		
		// 날짜 차이 계산하기
		// 현재 시간 가져오기
		// 내년 1월 1일 데이터 가져오기
		// 새해까지 남은 D-DAY 구하기
		
		Calendar now = Calendar.getInstance(); // 2024년 4월 3일 (코드 작성 시각 기준)
		Calendar newYear = new GregorianCalendar(2025,0,1); // 2025년 1월 1일

		// 현재시간을 밀리초단위로 변환
		long num1 = now.getTimeInMillis();
		long num2 = newYear.getTimeInMillis();
		
		// 1970년 1월 1일 자정기준 ~ 해당하는 시간까지 흐른 밀리초 반환
		// mills / 1000(초) / 60(분) / 60(시) / 24(일)
		long diff = (num2 - num1) / 1000 / 60 / 60 / 24;
		System.out.println(diff);
		System.out.println("새해까지 D-" + (diff+1) + "일 남았습니다.");
	}
	
	/*
	 * java.util.Date 클래스
	 * - 날짜와 시간에 대한 정보를 담을 수 있는 클래스
	 * - 초창기에 급하게 만들어져 완성도 낮음
	 */
	
	public void test3() {
		// 기본생성자를 통한 Data객체 생성 => 현재 날짜 및 시간을 가져오
		Date today = new Date();
		System.out.println("기본 생성자 Date() : " + today);
		
		// 내가 원하는 날짜가 (2024-04월-19일)
		
		// 방법 1.	년, 월, 일 생성자를 매개변수로 받는 생성자 통해 생성
		//			년도 => 세팅하고자하는 년도 - 1900
		Date date1 = new Date(2024 - 1900, 4 - 1, 19);
		System.out.println(date1);
		
		// 방법 2.	long타입 매개변수 하나를 받는 생성자를 통한 객체 생성 (권장)
		//			long타입? mill second를 매개변수로 전달
		Calendar cal2 = new GregorianCalendar(2024,4-1,19,18,0,0);
		long mills = cal2.getTimeInMillis();
		Date date2 = new Date(mills);
		System.out.println(date2);
	}
	
	/*
	 * SimpleDateFormat : Date 클래스 형식응 이용한 포맷?
	 */
	
	public void test4() {
		
		// 내 입맛대로 형식을 지정한 시간 문자열을 작성하고자 할 때 사용할 수 있는클래스
		// java.text.SimpleDateFormat
		
		// 객체 생성 방법
		// 1. 생성자 매개변수에 형식을 지정하여 객체 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		Date d1 = new Date();
		
		// 2. sdf.format(Data객체) => 포맷에 지정된 문자열대로 변환한 시간데이터 반환
		String formatDate = sdf.format(d1);
		System.out.println(formatDate);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat();
		sdf2.applyPattern("yyyy-MM-dd (E) hh:mm:ss"); // 함수를 통한 패턴 추가
		String formatDate2 = sdf2.format(d1);
		System.out.println(formatDate2);
	}

	// yyyy/MM/dd hh24:mm:ss
	public void printCalendar(Calendar c) {
		System.out.printf("%d/%02d/%02d %02d:%02d:%02d\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
	}
}
