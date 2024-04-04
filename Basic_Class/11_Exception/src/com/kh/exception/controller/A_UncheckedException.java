package com.kh.exception.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A_UncheckedException {
	/*
	 * RuntimeException
	 * - 프로그램이 실행중 발생되는 예외들
	 * 
	 * RuntimeException
	 * - NullPointerException : 참조 하고 있는 변수가 null 인 상태에서 접근 하려고 할 때
	 * - ArrayIndexOutOfBoundsException : 존재하지 않는 인덱스에 접근시
	 * - ClassCastException : 허용할 수 없는 자료형의 변환시 발생 (객체 다운 캐스팅?)
	 * - ArithmeticException : 나누기(/ , %) 연산시 0으로 나눌 때 발생.
	 * - NegativeArraySizeException : 배열의 크기를 음수로 지정시 발생
	 * ...
	 * 
	 * => RuntimeException과 관련된 예외들을 "예측이 가능"하기 때문에 , 예외 처리가 발생이 안되게끔 조건식을 걸어서 해결 할 수 있음.
	 * => 따라서 굳이 예외 처리를 할 필요가 없음
	 * 예외 처리 (예외가 발생 했을때 실행할 내용을 정의해두는것)
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		// ArithmeticException
		
		// 사용자에게 두개의 정수값을 입력받아 나누는 프로그램 생성
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
	
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		sc.nextLine();
		
		// 해결 방법 1. 조건문으로 처리하기.
		// 예외가 발생할 가능성을 차단. => 예외 처리는 아님?
		
		/*
		if(num2 != 0) {
			System.out.println("나눗셈 연산 결과 : " + (num1 / num2));
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		*/
		
		// 해결 방법 2. 예외처리 구문으로 해결
		// 예외가 발생할 경우의수 를 열어두고 , 예외(에러) 발생시 대신 실행할 구문을 정의함.
		
		/*
		 * try - catch문
		 * [표현법]
		 * try {
		 * 예외 발생할 수 있는 코드;
		 * } catch (발생할예외 클래스명 변수명) {
		 * 예외 발생시 대신 실행할 구문
		 * }
		 */
		
		try {
			System.out.println("나눗셈 연산 결과 : " + (num1 / num2));
		} catch(ArithmeticException e) { // 발생된 에러를 저장할 매개 변수
			System.out.println("0으로 나눌수 없습니다.");
			e.printStackTrace(); // 오류를 추적 할 수 있는 출력문
		}
		
		System.out.println("프로그램 종료");
	
	}
	
	public void method2() {
		
		System.out.print("정수 입력(0제외) : ");
		
		try {
			int num = sc.nextInt(); //첫번째 에러발생부분 (InputMismatchException)
			
			System.out.println("나눗셈 연산 결과 : " + (10 / num)); //두번째 에러 발생 부분 (ArithmeticException)
			
		} catch (InputMismatchException e) {
			System.out.println("정수를 똑바로 입력하세요.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} // 다중 catch블럭 : 예외가 여러개 발생할 가능성이 있는 경우 사용.
		
		System.out.println("프로그램 종료");
	}
	
	public void method3() {
		// ArrayIndexOutOfBoundsException :
		// NegativeArraySizeException :
		// 두 예외에 대한 처리를 구현한 코드 작성
		
		System.out.print("배열의 크기를 입력 : ");
		
		/*
		if(size<0) {
			System.out.println("배열의 크기를 음수로 제시할 수 없습니다.");
		} else if (size<101) {
			System.out.println("부적절한 인덱스 입니다.");
		} else {
			int [] arr = new int[size];
			System.out.println("100번 인덱스의 값 : " + arr[100]);
		}
		*/
		
		
		try {
			int size = sc.nextInt();
			int [] arr = new int[size];
			System.out.println("100번 인덱스의 값 : " + arr[100]);
		} catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기를 음수로 제시할 수 없습니다.");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("부적절한 인덱스 입니다.");
		} catch(RuntimeException e) { // 다형성을 이용하여 자식에러 객체 받아줌.
			System.out.println("알 수 없는 오류 발생");
			e.printStackTrace();
		}
		
		// RuntimeException 의 예외 처리 최상위 클래스 (부모 클래스)
		// catch 문의 경우 상위 catch 부터 차례대로 처리. 중간에 해당하는 catch 문 존재시 하위 catch문은 실행되지 않고 종료됨.
		// 따라서 , RuntimeException 처리시 가장 나중 catch문으로 사용해야 함. (하위 에러 확인이 불가능 할 때만?)
		
	}
	
	/*
	 * RuntimeException 관련된 예외들은
	 * - 조건문으로 해결 가능함. => 예외 자체가 발생하지 않게 끔 개발자가 소스코드로 핸들링 가능함. (예외 원천 차단 가능)
	 * - 예외처리구문으로 해결가능 => 예외가 발생했을 때를 대비해서 , 에러 발생시 대신 실행할 내용을 기술하는 것.
	 * 
	 * 예외에 대한 예측이 가능한 상황에서는 항상 "조건문" 으로 해결하는 것을 권장한다.
	 * RuntimeException 계열들은 예측이 가능한 상황들이기 때문에 , 예외처리가 필수가 아니다.
	 * => 필수가 아닌 예외처리들은 UncheckedException
	 * 
	 */
}
