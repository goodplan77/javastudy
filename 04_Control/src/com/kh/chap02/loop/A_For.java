package com.kh.chap02.loop;

import java.util.Scanner;

public class A_For {

	/*
	 * <반복문> 프로그램 흐름을 제어하는 제어문중 하나 , 어떤 실행코드를 '반복적'으로 수행 시켜 줌
	 * 
	 * 반복문 : for / while
	 * 
	 * [표현법] for(초기식 ; 조건식 ; 증감식) { 반복적으로 실행시키고자 하는 코드 } - 초기식 : 반복문 시작 시
	 * "초기에 한번만 실행" 되는 구문. 반복문에서 사용할 변수를 선언 및 초기화 시키는 역할 ex) int i = 0; - 조건식 :
	 * "반복문이 수행될 조건" 을 작성하는 구문. 조건이 참 이면 반복문 실행. 거짓이면 반복을 멈추고 빠져나옴. 초기식에 선언한 변수를 가지고
	 * 조건식 작성 ex) i < 10 - 증감식 : 반복문을 제어하는 변수값을 증감시키는 구문. 초기식에 제시된 변수를 가지고 증감식 작성
	 * ex) i++ , i-- , i+=2
	 */

	public void method1() {
		// 1000번 반복?
//		for(int i = 0 ; i < 1000 ; i++) {
//			System.out.println("안녕하세요.");
//		}

		for (int i = 1; i < 6; i++) {
			System.out.println(i);
		}

		for (int i = 1; i < 6;) {
			System.out.println(i++);
		}

		int i = 1;
		for (;;) {
			System.out.println(i++);
			if (i >= 6)
				break;
		}
	}

	public void method2() {
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 5; i >= 1; i--) {
			System.out.print(i + " ");
		}

		System.out.println();

		// 1값이 1에서부터 10사이에 홀수 출력

		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println();

		for (int i = 0; i <= 9; i++) {
			System.out.print((i+1) + " ");
		}
	}
	
	public void method3() {
		// 반복문을 활용해서 1부터 10까지의 총 합을 구함
		
		int sum = 0;
		for(int i = 1 ; i<=10 ; i++) {
			sum+=i;
		}
		
		System.out.println("1부터 10까지의 총 합 : " + sum);
	}
	
	public void method4() {
		// 스캐너를 활용한 1~n 까지의 총합 구하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("양수를 입력하세요. ");
		int num = sc.nextInt();
		
		if(num >=0) {
			int sum = 0;
			for(int i = 1 ; i <=num ; i++) {
				sum +=i;
			}
			System.out.printf("1에서 부터 %d까지의 총 합계 : %d\n" , num , sum);
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

}
