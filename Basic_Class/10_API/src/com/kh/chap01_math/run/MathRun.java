package com.kh.chap01_math.run;

// Math => java.lang.Math
// java.lang.*는 보이지는 않지만 항상 import 되어 있음
public class MathRun {

	public static void main(String[] args) {

		// Math클래스에서 제공하고 있는 함수들

		// 파이 -> Math 클래스에서 상수필드로 정의 되어 있음
		System.out.println("파이 : " + Math.PI);

		// 메소드명(매개변수) : 반환형
		// 올림 => Math.ceil(double) : double
		double num1 = 4.349;
		System.out.println("올림 : " + Math.ceil(num1));

		// 반올림 => Math.round(double) : long
		System.out.println("반올림 : " + Math.round(num1));

		// 버림 => Math.floor(double) : double
		System.out.println("버림 : " + Math.floor(num1));

		// 절대값 => Math.abs(int/double/long/float) : 반환값(int/double/long/float)
		int num2 = -10;
		System.out.println("절대값 : " + Math.abs(num2));

		// ----

		// 최소값 => Math.min(int,int) : int
		System.out.println("최소값 : " + Math.min(10, 2));

		// 최대값 => Math.max(int,int) : int
		System.out.println("최대값 : " + Math.max(5, 10));

		// 제곱근(루트) => Math.sqrt(double) : 반환값 double
		System.out.println("4의 제곱근 : " + Math.sqrt(4));

		// 제곱 => Math.pow(double,double) : 반환값 double
		System.out.println("2의 10제곱 : " + Math.pow(2,10));
		
		/*
		 * Math 클래스의 특징
		 * - 모든 필드가 상수필드
		 * - 모든 메소드가 static 메소드
		 * 
		 * 전부 Math.?? 으로 접근 가능. (객체 생성할 필요가 없음)
		 * 객체를 생성할 필요가 없으므로 , private 로 생체 생성을 막아줌
		 */
	}

}
