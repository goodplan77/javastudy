package com.kh.operator;

import java.util.Scanner;

public class F_Logical {
	/*
	 * 논리 연산자 : 논리값 두개를 비교하는 연산자
	 * 
	 * AND && : A && B
	 * -> A , B 둘 다 true 이어야 true , 하나라도 false 라면 false
	 * OR || : A || B
	 * -> A , B 하나라도 참이면 true , 둘 다 false 라면 false
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		System.out.print("정수값을 입력하세요. : ");
		int sum = sc.nextInt();
		
		// 사용자가 입력한 값이 양수 이면서 짝수인지 판단
		
		boolean result = (sum > 0) && (sum % 2 == 0);
		System.out.println("사용자가 입력한 값이 양수이면서 짝수 입니까? :" + result);
	}
	
	public void method2() {
		System.out.print("정수값을 입력하세요. : ");
		int num = sc.nextInt();
		
		//정수값이 1에서부터 100사이의 값인지 확인
		
		boolean result = (num >= 1) && (num <=100);
		System.out.println("사용자가 입력한 값이 1이상 100이하의 값입니까? " + result);
	}
	
	public void method3() {
		System.out.print("A~Z까지의 문자를 입력해주세요. : ");
		char ch = sc.nextLine().charAt(0);
		
		// 사용자가 제대로 A~Z까지의 값을 입력했는지 확인
		
		boolean result = (ch >= 65) && (ch <= 90);
		System.out.println("사용자가 입력한 값이 영어 대문자 입니까? : " + result);
	}
	
	public void method4() {
		System.out.print("계속하시려면 y를 입력하세요. ");
		char ch = sc.nextLine().charAt(0);
		
		// y Y
		boolean result = (ch == 'y') || (ch == 'Y');
		System.out.println("사용자가 입력한 값이 y 이거나 Y입니까? " + result);
	}
	
	public void method5() {
		int num1 = 10;
		
		boolean result1 = (num1 < 5) && (++num1 > 0);
		
		// && 연산의 경우 앞의 값이 false인 경우 뒤쪽 연산을 수행하지 않음
		
		System.out.println("result1 : " + result1);
		System.out.println("num1 : " + num1);
		
		int num2 = 10;
		boolean result2 = (num2 < 20) || (++num2 > 0);
		
		System.out.println("result2 : " + result2);
		System.out.println("num2 : " + num2);
		
		boolean result3 = true || (num1 > 0);
		
	}

}
