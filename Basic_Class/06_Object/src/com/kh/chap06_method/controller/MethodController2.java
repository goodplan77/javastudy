package com.kh.chap06_method.controller;

public class MethodController2 {
	
	static int count = 0;
	int count2 = 0;
	
	/*
	 *  static 메소드
	 *  접근제한 static [예약어] 반환형 함수명 ([매개변수]) {
	 *  수행내용;
	 *  [return 반환값]
	 *  }
	 *  
	 *  - 호출시 객체 생성할 필요가 없음
	 *  - 클래스명.메서드명(반환값); 으로 호출
	 *  - 프로그램 시작시, static 메모리 영역에 메소드가 할당되기 때문.
	 *  - 예약어 , 매개변수 , return문은 상황에 따라 생략가능(일반 메서드와 동일)
	 */
	
	public static int multiply(int num1 , int num2) {
		System.out.println("static 메소드");
		
		// 매개 변수 2개로 연산시 문제X
		// return num1 * num2;
		
		// 같은 범위에서 연산가능
		// count는 프로그램 시작과 동시에 저장공간 할당
		// num1은 multiply함수 호출시 할당
		// return count * num1;
		
		// count2는 현재 객체 생성전 까지는 메모리 영역에 값을 할당받지 못함
		// multiply 함수는 객체 생성 하지 않더라도 호출이 가능함
		//return count2 * num1;
		
		return num1 * num2;
	}

}
