package com.kh.chap03.branch;

import java.util.Scanner;

public class A_Break {
	
	/*
	 * break : 반복문 내부에서 break 문을 만나는 순간 현재 속해있는 반복문을 빠져나간다.
	 * 
	 * 주의점 : switch 문 안의 break는 switch문만 빠져나가는 역할을 함
	 */
	
	public void method1() {
		//매번 반복적으로 랜덤값(1-100)을 출력
		//단 , 그 랜덤값이 13의 배수일 경우 반복문을 탈출
		
		while(true) {
			int random = (int)(Math.random() * 100 + 1);
			System.out.println("random : " + random);
			
			if(random % 13 ==0) {
				break;
			}
		}
	}
	
	public void method2() {
		// 매번 사용자에게 문자열을 입력 받은 후
		// 문자열의 길이를 출력.
		// 사용자가 입력한 문자열이 exit와 일치한 경우
		// 반복 종료
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			
			if(str.equals("exit")) {
				break;
			} else {
				System.out.println("문자열 '" + str + "'의 길이 : " + str.length());
			}
		}
	}
	
	public static void main(String[] args) {
		A_Break ab = new A_Break();
		ab.method2();
	}

}
