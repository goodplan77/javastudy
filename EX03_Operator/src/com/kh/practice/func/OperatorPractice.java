package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {

	Scanner sc = new Scanner(System.in);

	public void practice1() {
			System.out.print("인원 수 : ");
			int count = sc.nextInt();
			
			System.out.print("사탕 개수 : ");
			int candy = sc.nextInt();
			
			System.out.println("1인당 사탕 개수 : " + (candy / count));
			System.out.println("남는 사탕 개수 : " + (candy % count));
	}

	public void practice2() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(숫자만) : ");
		int classes = sc.nextInt();
		
		System.out.print("번호(숫자만) : ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine();
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		

	}

	public void practice3() {

	}

	public void practice4() {

	}

	public void practice5() {

	}

	public void practice6() {

	}

	public void practice7() {

	}

	public void practice8() {

	}

}
