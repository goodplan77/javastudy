package com.kh.operator;

public class E_Comparison {
	/*
	 * 비교 연산자 / 관계 연산자 (이항 연산자) 두 개의 값을 가지고 비교 비교 연산한 결과가 참일 경우 true / 거짓 일 경우 false
	 * -> 결과 값은 항상 논리값 (true/false)
	 * 
	 * 크고 작음 비교 < , > , <= , >=
	 * 
	 * 동일성 비교 a==b : a와 b가 일치? a!=b : a와 b가 불일치?
	 * 
	 * 문자열 동일성 비교 equals String a = "1234"; String b = "1234"; a == b X a.equlas(b)
	 */

	public void method1() {
		int a = 10;
		int b = 25;

		System.out.println("a > b ? " + (a > b));
		// 연산자 우선순위 1. 산술 연산 2. 비교 연산
		// 따라서 괄호로 묶어서 우선순위를 높여야함

		boolean result = (a == b); // 대입은 보통 우선순위가 제일 낮음 (그래도 헷갈리니 괄호 추천)

		// 산술연산 + 비교연산
		System.out.println(a - b < 0); // true
		System.out.println(a * 2 > b / 5); // true

		boolean result1 = (a % 2 == 0); // true
		boolean result2 = (a % 2 != 0); // false
		boolean result3 = !(a % 2 == 0); // false
		boolean result4 = (a % 2 == 1); // false
		// 짝수 홀수 배수 구할때 자주 사용함
	}

}
