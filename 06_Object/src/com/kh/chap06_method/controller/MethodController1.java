package com.kh.chap06_method.controller;

public class MethodController1 {
	/*
	 * 메소드
	 * 
	 * 접근제한자 [예약어] 반환형 메소드명([매개변수]) { 수행코드; [return 반환값;] //반환형이 void일 경우 생략 가능. 아니면
	 * return 존재 해야함 }
	 */

	// 1. 매개변수가 없고 , 반환형이 없는 메소드
	public void method1() {
		System.out.println("매개변수 , 반환값 둘다 없는 메소드 입니다.");
		sum(10);

		// return; void형은 생략 가능. JVM이 자동적으로 처리?
	}

	// 2. 매개변수는 없고 , 반환값은 있는 메소드
	public int random() {
		int sum = 0;
		for (int i = 1; i <= 10; i++)
			sum += i;

		System.out.println("매개변수는 없고 반환값은 있는 메소드 입니다.");

		return (int) (Math.random() * 100 + 1);
	}

	// 3. 매개변수는 있고 , 반환값은 없는 메소드

	public void sum(int num) {
		int sum = 0;
		for (int i = 1; i <= num; i++)
			sum += i;
		
		System.out.printf("1부터 %d까지의 합계 : %d\n",num,sum);
	}
	
	// 4. 매개변수 있고 , 반환형도 있는 메소드
	public int multiply (int a , int b) {
		System.out.println("매개변수 있고, 반환형도 있는 메소드");
		return a*b;
	}

}
