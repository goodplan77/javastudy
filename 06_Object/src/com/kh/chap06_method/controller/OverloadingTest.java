package com.kh.chap06_method.controller;

public class OverloadingTest {

	/*
	 * 메소드 오버로딩
	 * - 한 클래스 내에 같은 메소드명으로 여러개의 메소드를 정의 하는 방법
	 * - 단 , 매개변수의 자료형의 개수 , 순서가 달라야 한다
	 * - 그 외 , 매개변수명 , 접근제헌자 , 반환형 등은 오버로딩에 영향을 주지 않는다.
	 */

	public void test() {

	}

	public void test(int a) {

	}

	public void test(int a , String s) {

	}
	
	public void test(String s , int a) {
		
	}
	
	// 메소드 오버로딩이 되지 않는 경우
	// 매개변수명과 오버로딩은 아무런 상관이 없음.
	// 즉 , 매개변수명과 무관하게 자료형의 개수 및 순서가 달라야함
	
	/*
	 * public void test(String s , int a) {}
	 * 
	 * 바로 위 함수와 동일 선상으로 봄.
	 */

}
