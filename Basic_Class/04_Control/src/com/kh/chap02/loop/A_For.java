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
			System.out.print((i + 1) + " ");
		}
	}

	public void method3() {
		// 반복문을 활용해서 1부터 10까지의 총 합을 구함

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}

		System.out.println("1부터 10까지의 총 합 : " + sum);
	}

	public void method4() {
		// 스캐너를 활용한 1~n 까지의 총합 구하기

		Scanner sc = new Scanner(System.in);
		System.out.print("양수를 입력하세요. ");
		int num = sc.nextInt();

		if (num > 0) {
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.printf("1에서 부터 %d까지의 총 합계 : %d\n", num, sum);
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	public void method5() {
		/* 1에서부터 랜덤값(1~10사이의 정수) 까지의 총 합계 
		 * 
		 * java.lang.Math 클래스에 정의되어 있는 random() 메소드를 호출하여 매번 다른 랜덤값을 얻어 올 수 있음.
		 * 
		 * 0.0 ~ 0.999999999 사이의 랜덤값 발생
		 * 1미만의 값
		 * 0.0 <= 랜덤값 < 1
		 * 
		 * [표현법]
		 * Math.random() * 출력하고자 하는 갯수 + 시작수
		 * 시작수 ~ (시작수 + 갯수)
		 */
		
		int random = (int)(Math.random() * 45 + 1); // 1 ~46
		
		int sum = 0;
		for(int i = 1 ; i <= random ; i++) {
			sum+=i;
		}
		
		System.out.println("random = " + random);
		System.out.println("sum = " + sum);
		
	}
	
	public void method6() {
		String str = "hello";
		
		/*
		 * h -> str.charAt(0)
		 * e -> str.charAt(1)
		 * l -> str.charAt(2)
		 * l -> str.charAt(3)
		 * o -> str.charAt(4)
		 * 
		 * 문자열.legnth() ; 문자열 길이를 반환
		 * ex) str.length -> 5
		 */
		
		for(int i = 0 ; i < str.length() ; i++) {
			System.out.print(str.charAt(i) + " ");
		}
	}
	
	public void method7() {
		/*
		 * 구구단 출력
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * 2 X 3 = 6
		 * ...
		 * 2 X 9 = 18
		 */
		
		for(int i = 1 ; i <= 9 ; i++) {
			System.out.printf("%d X %d = %d\n", 2, i ,2*i);
		}
	}
	
	public void method8() {
		//2 ~ 9단 모두 출력
		// 중첩 반복문
		
		for(int i = 2 ; i <= 9 ; i++) {
			System.out.printf("==========%d 단==========\n",i);
			for(int j = 1 ; j <= 9 ; j++) {
				System.out.printf("%d X %d = %d\n",i,j,(i*j));
			}
			System.out.println();
		}
	}
	
	public void method9() {
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j = 1 ; j <=5 ; j++) {
				if(i==j) {
					System.out.printf("%d " , j);
				} else {
					System.out.printf("* ");
				}
			}
			System.out.println();
		}
	}

}
