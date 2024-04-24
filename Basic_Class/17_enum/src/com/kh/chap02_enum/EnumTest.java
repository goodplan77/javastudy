package com.kh.chap02_enum;

import com.kh.chap02_enum.model._enum.CarColor;

public class EnumTest {
	
	/*
	 * enum
	 * - Enumeration(열거)의 약자형. 클래스 내부에 상수값들을 열거했다고 하여 enum이라 명칭함.
	 * - 상수 열거형 데이터를 간결하게 다룰 수 있게 도와주는 것이 enum 클래스.
	 */
	
	public static void main(String[] args) {
		System.out.println(CarColor.BLACK);
		System.out.println(CarColor.BLACK.getColor());
		System.out.println(CarColor.valueof(1));
		CarColor.valueof(2).printTest();
	}
	
	/*
	 * enum 장점
	 * 1) 컴파일 단계에서 타입을 검증
	 * 2) 동일한 의미를 가진 상수 값들을 모아서 관리 할 수 있다. (웹 프로그래밍?)
	 * 3) 상수값마다 고유한 메서드를 부여 할 수 있다.
	 * 4) 반복문을 통해 원하는 상수값을 찾을 수 있다.
	 */

}
