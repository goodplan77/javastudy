package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {

	Scanner sc = new Scanner(System.in);

	public void practice1() {

		System.out.printf("1. 입력\n2. 수정 \n3. 조회\n4. 삭제\n7. 종료\n");
		System.out.print("메뉴 번호를 입력하세요. : ");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("조회 메뉴 입니다.");
			break;
		case 2:
			System.out.println("수정 메뉴 입니다.");
			break;
		case 3:
			System.out.println("조회 메뉴 입니다.");
			break;
		case 4:
			System.out.println("삭제 메뉴 입니다.");
			break;
		case 7:
			System.out.println("프로그램이 종료 됩니다.");
			break;
		default:
			System.out.println("잘못된 번호를 적으셨습니다.");
			break;
		}

	}

	public void practice2() {
		System.out.print("숫자를 한 개 입력하세요. : ");
		int num = sc.nextInt();

		if (num > 0) {
			if (num % 2 == 0) {
				System.out.println("짝수입니다.");
			} else {
				System.out.println("홀수입니다.");
			}
		} else {
			System.out.println("양수만 입력하세요.");
		}
	}

	public void practice3() {
		System.out.print("국어 :");
		int kor = sc.nextInt();

		System.out.print("영어 :");
		int eng = sc.nextInt();

		System.out.print("수학 :");
		int math = sc.nextInt();

		int sum = kor + eng + math;
		double avg = (double) sum / 3;

		if (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("영어 : " + eng);
			System.out.println("수학 : " + math);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}

	}

	public void practice4() {
		System.out.print("1~12 사이의 정수 입력  : ");
		int input = sc.nextInt();
		switch (input) {
		case 12, 1, 2:
			System.out.println(input + "월은 겨울입니다.");
			break;
		case 3, 4, 5:
			System.out.println(input + "월은 봄입니다.");
			break;
		case 6, 7, 8:
			System.out.println(input + "월은 여름입니다.");
			break;
		case 9, 10, 11:
			System.out.println(input + "월은 가을입니다.");
			break;
		default:
			System.out.println(input + "월은 잘못 입력된 달입니다.");
			break;
		}
	}

	public void practice5() {
		String ID = "minmin";
		String password = "Min1234";

		System.out.print("아이디 : ");
		String inputID = sc.nextLine();
		System.out.print("비밀번호 : ");
		String inputPassword = sc.nextLine();
	}

}
