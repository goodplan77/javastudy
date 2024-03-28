package com.kh.chap01.condition;

import java.util.Scanner;

public class A_If {
	/*
	 * 선택적으로 특정코드만 실행 : 조건문
	 * 특정코드만 반복 : 반목문 반복문 내부에서 흐름 제어 : 분기문
	 */

	Scanner sc = new Scanner(System.in);

	public void method1() {

		/*
		 * 단독 if문 if(조건식) { 조건식의 결과가 참이면 실행되는 영역 }
		 */

		System.out.print("정수를 입력하세요. : ");
		int num = sc.nextInt();

		// String result = num > 0 ? "양수입니다" : "양수가아닙니다."

		String result = "양수입니다.";

		if (num > 0) {
			result = "양수입니다.";
		}

		if (num <= 0) {
			result = "양수가아닙니다.";
		}

		System.out.println(result);

	}

	public void method2() {
		/*
		 * if ~ else if(조건식) { 조건식이 참 일 때 실행 } else { 조건식이 거짓 일 때 실행 }
		 */

		System.out.print("정수를 입력하세요. : ");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.println("양수");
		} else {
			System.out.println("양수 아님");
		}

	}

	public void method3() {
		System.out.print("정수를 입력하세요. : ");
		int num = sc.nextInt();

		/*
		 * if ~ else if 같은 비교대상으로 여러개의 조건을 제시해야하는 경우 사용
		 * 
		 * if(조건식 1) { 조건식 1이 참인 경우 실행 } else if(조건식2) { 조건식1이 거짓인데 조건식2인 경우 실행 단 ,
		 * 조건식1이 참이면 해당 영역은 실행되지 않음 } else if(조건식3) { 조건식1 , 조건식2 은 거짓 인데 조건식3은 참인 경우 실행
		 * } ... else { 모든 조건식이 거짓일 경우 자동 실행 }
		 * 
		 * -> else 까지 내려가기 전에 하나라도 참인 영역이 실행 되는 경우 나머지 영역은 넘어가고 해당 영역 실행후 종료됨
		 */

		if (num > 0) {
			System.out.println("양수");
		} else if (num == 0) {
			System.out.println("0");
		} else {
			System.out.println("음수");
		}
	}

	public void method4() {
		// 사용자가 입력한 나이값을 가지고 어린이/청소년/성인 확인

		System.out.print("나이 : ");
		int age = sc.nextInt();

		// age가 13세 이하 : 어린이
		// age가 13세 초과 ~ 19세 이하 : 청소년
		// age가 19세 초과 : 성인

		if (age <= 13) {
			System.out.println("어린이");
		} else if (age <= 19) {
			System.out.println("청소년");
		} else {
			System.out.println("성인");
		}
	}

	public void method5() {
		// 사용자에게 이름, 성별을 입력받아 남자인지 여자인지 출력
		System.out.println("이름 : ");
		String name = sc.nextLine();

		System.out.print("성(M/F) : ");
		char gender = sc.nextLine().charAt(0);

		String result;

		if (gender == 'M') {
			result = "남학생";
		} else if (gender == 'F') {
			result = "여학생";
		} else {
			System.out.println("성별을 잘못 입력하셨습니다.");
			return; // 메서드 종료
		}

		System.out.printf("%s님은 %s이다.\n", name, result);
	}

	public void method6() {
		// 문자열 간의 비교
		System.out.print("이름 : ");
		String name = sc.nextLine();

		if (name.equals("민경민")) {
			System.out.println("반갑습니다");
		} else {
			System.out.println("누구세요");
		}

		/*
		 * 기본자료형 : boolean , byte , short , int , long , float , double , char 참조자료형 :
		 * String
		 * 
		 * 기본자료형 간 비교시 != , == 사용 가능 but , 참조자료형의 경우 equals 함수 사용
		 * 
		 * A문자열.equals(B문자열) -> A문자열과 B문자열이 같은지 검사. 같으면 참 , 아니면 거짓 반환
		 */
	}

	public void method7() {
		// 양수를 입력 받고 입력 받은 값이 짝수인지 홀수인지 판별
		// 양수가 아니면 양수가 아닙니다 출력
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			if(input % 2 == 0) {
				System.out.println("짝수 입니다.");
			} else {
				System.out.println("홀수 입니다.");
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}
	}
}
