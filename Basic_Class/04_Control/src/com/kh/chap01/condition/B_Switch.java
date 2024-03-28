package com.kh.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	/*
	 * switch문은 if문과 동일한 조건문
	 * if(조건식) => 조건식 복잡하게 기술가능.
	 * switch(값) => 확신한 값만 기술하여 동등비교만 수행
	 * 
	 * [표현법]
	 * switch(동등비교를 수행할 변수){
	 * case 값1 : 값1과 일치시 실행;
	 *		break; // 값1과 일치하는 코드 실행후 switch문을 빠져 나감
	 * case 값2 : ...;
	 * 		break;
	 * ...
	 * default : case 중에 일차하는 경우가 없을때 실행 코드;
	 * 		break;
	 * }
	 * 
	 * 케이스간의 동일 연산 속도가 나와야 하는 경우 switch 문 사용
	 * 동등 비교를 여러번 (5번?) 해야 할 때 사용 고려
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		// 1 ~ 3 사이 정수 값을 입력받아
		// 1: 빨간불
		// 2: 파란불
		// 3: 초록불
		// 잘못 입력시 잘못입력을 출력
		
		System.out.print("1~3 사이의 정수 입력 : ");
		int input = sc.nextInt();
		
		switch(input) {
		case 1 : 
			System.out.println("빨간불");
			break;
		case 2 :
			System.out.println("파란불");
			break;
		case 3 :
			System.out.println("초록불");
			break;
			default :
				System.out.println("잘못 입력");
				break;
		}
	}
	

}
