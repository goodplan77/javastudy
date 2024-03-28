package com.kh.operator;

import java.util.Scanner;

public class G_Triple {
	/*
	 * 삼항 연산자 : 3개의 항목을 가지고 연산하는 연산자
	 * [표현법]
	 * 조건식 ? 참일때 결과값 : 거짓일때 결과값
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		
		// 사용자가 입력한 정수값이 양수인지 아닌지 판별.
		// 양수라면 : 양수입니다.
		// 음수라면 : 음수입니다.
		
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		String str = (num > 0) ? "양수입니다." : "음수입니다.";
		System.out.println(num + "은 " + str);
		
	}
	
	public void method2() {
		// 사용자로부터 종료의사여부를 입력받은후 판별해서 출력
		// 사용자가 y,Y 입력시 -> "계속 진행 합니다."
		// 그 외의 값 입력시 -> "프로그램을 종료합니다.
		
		System.out.print("계속하시려면 y를 입력하세요. ");
		char ch = sc.nextLine().charAt(0);
		String str = (ch == 'y') || (ch == 'Y') ? "계속 진행합니다." : "프로그램을 종료합니다.";
		System.out.println(str);
	}
	
	public void method3() {
		// 사용자가 입력한 값이 양수 , 0 , 음수인지 정확하게 판별
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "양수입니다." : (num == 0 ? "0입니다." : "음수입니다.");
		System.out.println(result);
	}
	
	public void method4() {
		/*
		 * 두개의 정수값과 + 혹은 - 의 문자를 하나 입력받아서
		 * +일경우 덧셈 , -일 경우 뺼셈 연산한 결과 출력.
		 * 둘다 아닌 경우 "잘못 입력했습니다. 출력
		 */
		
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		sc.nextLine(); //개행 비우기
		System.out.print("연산자 입력(+ or -) : ");
		char op = sc.nextLine().charAt(0);
		
		String str = op == '+' ? Integer.toString(num1 + num2) : (op == '-' ? Integer.toString(num1 - num2) : "잘못입력했습니다.");
		System.out.println(str);
	}

}
