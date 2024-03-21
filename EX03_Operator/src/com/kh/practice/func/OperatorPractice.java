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
		char gender = sc.nextLine().charAt(0);
		String genderAnswer = gender =='M' ? "남학생" : "여학생";

		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();

		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f 입니다.", grade, classes, number, name, genderAnswer, score);

	}

	public void practice3() {

		System.out.print("나이 : ");
		int age = sc.nextInt();

		if (age <= 13) {
			System.out.println("어린이");
		} else if (age <= 19) {
			System.out.println("청소년");
		} else {
			System.out.println("청년");
		}

	}

	public void practice4() {

		System.out.print("국어 : ");
		int kor = sc.nextInt();

		System.out.print("영어 : ");
		int eng = sc.nextInt();

		System.out.print("수학 : ");
		int math = sc.nextInt();

		int sum = kor + eng + math;
		double avg = (double) sum / 3;

		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);

		if (avg >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");

	}

	public void practice5() {
		System.out.print("주민 번호를 입력하세요. : ");
		char number = sc.nextLine().charAt(7);

		if (number == '1' || number == '3') {
			System.out.println("남자");
		}

		else if (number == '2' || number == '4') {
			System.out.println("여자");
		}

		else {
			System.out.println("유효하지 않은 정보");
		}

	}

	public void practice6() {
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();

		System.out.print("정수2 : ");
		int num2 = sc.nextInt();

		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		if(input <= num1 || input > num2) System.out.println(true);
		else System.out.println(false);

	}

	public void practice7() {
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		if(num1 == num2){
			if(num2 == num3)
			{
				System.out.println(true);
			}
			else
			{
				System.out.println(false);
			}
		} else
		{
			System.out.println(false);
		}
	}

	public void practice8() {
		
		System.out.print("A사원의 연봉 : ");
		int salaryA = sc.nextInt();
		double finalSalaryA = salaryA*(1+0.4);
		
		System.out.print("B사원의 연봉 : ");
		int salaryB = sc.nextInt();
		double finalSalaryB = salaryB;
		
		System.out.print("C사원의 연봉 : ");
		int salaryC = sc.nextInt();
		double finalSalaryC = salaryC*(1+0.15);
		
		System.out.printf("A사원 연봉/연봉+a %d/%.1f\n" , salaryA , finalSalaryA);
		System.out.println(finalSalaryA >= 3000 ? "3000이상" : "3000미만");
		
		System.out.printf("B사원 연봉/연봉+a %d/%.1f\n" , salaryB , finalSalaryB);
		System.out.println(finalSalaryB >= 3000 ? "3000이상" : "3000미만");
		
		System.out.printf("C사원 연봉/연봉+a %d/%f\n" , salaryC , finalSalaryC);
		System.out.println(finalSalaryC >= 3000 ? "3000이상" : "3000미만");
		
		
		
	}

}
