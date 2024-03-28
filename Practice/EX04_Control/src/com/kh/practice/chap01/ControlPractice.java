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

		/*if (!inputID.equals(ID)) {
			System.out.println("아이디가 틀렸습니다.");

		} else if (!inputPassword.equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.println("로그인 성공");
		}*/
		
		if(inputID.equals(ID)) {
			if(inputPassword.equals(password)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}

	public void practice6() {
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String outh = sc.nextLine();

		switch (outh) {
		case "관리자" :
			System.out.print("회원 관리 , 게시글 관리 , ");
		case "회원" :
			System.out.print("게시글 작성 , 댓글작성 , ");
		case "비회원" :
			System.out.print("게시글 조회");
			break;
		default:
			System.out.print("잘못된 접근");
			break;
		}
	}

	public void practice7() {
		System.out.print("키(m)를 입력해 주세요. :");
		double height = sc.nextDouble();

		System.out.print("몸무게(kg)를 입력해 주세요. :");
		double weight = sc.nextDouble();

		double bmi = weight / (height * height);
		
		System.out.println("BMI 지수 : " + bmi);

		if (bmi < 18.5) {
			System.out.println("저체중");
		} else if (bmi < 23) {
			System.out.println("정상체중");
		} else if (bmi < 25) {
			System.out.println("과체중");
		} else if (bmi < 30) {
			System.out.println("비만");
		} else {
			System.out.println("고도 비만");
		}

	}

	public void practice8() {
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();

		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		sc.nextLine();

		if (num1 > 0 && num2 > 0) {
			System.out.print("연산자를 입력(+,-,*,/,%) : ");
			char operator = sc.nextLine().charAt(0);

			double output;

			switch (operator) {
			case '+':
				output = num1 + num2;
				System.out.printf("%d %c %d = %.0f", num1, operator, num2, output);
				break;
			case '-':
				output = num1 - num2;
				System.out.printf("%d %c %d = %.0f", num1, operator, num2, output);
				break;
			case '*':
				output = num1 * num2;
				System.out.printf("%d %c %d = %.0f", num1, operator, num2, output);
				break;
			case '/':
				output = (double) num1 / num2;
				System.out.printf("%d %c %d = %.6f", num1, operator, num2, output);
				break;
			case '%':
				output = num1 % num2;
				System.out.printf("%d %c %d = %.0f", num1, operator, num2, output);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
				break;
			}
		} else {
			System.out.println("입력값 모두 양수 여야 합니다.");
		}
	}

	public void practice9() {
		System.out.print("중간 고사 점수 : ");
		int middleScore = sc.nextInt();

		System.out.print("기말 고사 점수 : ");
		int finalScore = sc.nextInt();

		System.out.print("과제 점수 : ");
		int homeworkScore = sc.nextInt();

		System.out.print("출석 회수 : ");
		int attendCount = sc.nextInt();

		System.out.println("================= 결과 =================");

		if (attendCount <= 14) {
			System.out.printf("FAIL [출석횟수 부족(%d/20)]\n", attendCount);

		} else {
			System.out.printf("중간 고사 점수(20) : %.1f\n", middleScore * 0.2);
			System.out.printf("중간 고사 점수(30) : %.1f\n", finalScore * 0.3);
			System.out.printf("과제 점수(30) : %.1f\n", homeworkScore * 0.3);
			System.out.printf("출석 점수(20) : %.1f\n", (double) attendCount);

			double score = (middleScore * 0.2) + (finalScore * 0.3) + (homeworkScore * 0.3) + attendCount;
			System.out.printf("총점 : %.1f\n", score);

			if (score >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		}

	}

	public void practice10() {
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");

		int select = sc.nextInt();

		switch (select) {
		case 1:
			practice1();
			break;
		case 2:
			practice2();
			break;
		case 3:
			practice3();
			break;
		case 4:
			practice4();
			break;
		case 5:
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
			break;
		default:
			System.out.println("유효한 값을 입력하세요. (정수 1 ~ 9)");
			break;

		}

	}

	public void practice11() {
		
		System.out.print("비밀번호 입력(1000~9999) : ");
		int password = sc.nextInt();
		
		if(password <1000 || password >9999)
		{
			System.out.println("자릿수 안맞음");
			return;
		}
		
		int num1 = password / 1000;
		int num2 = (password % 1000) / 100 ;
		int num3 = (password % 100) / 10 ; 
		int num4 = password % 10 ; 
		
		/*
		int numbers[] = new int[4];
		numbers[0] = num1;
		numbers[1] = num2;
		numbers[2] = num3;
		numbers[3] = num4;
		*/
		
		System.out.printf("%d %d %d %d\n" , num1 , num2 , num3 , num4);
		
		if(num1 == num2 || num1 == num3 || num1 == num4)
		{
			System.out.println("실패");
		} else if (num2 == num3 || num2 == num4) {
			System.out.println("실패");
		} else if (num3 == num4) {
			System.out.println("실패");
		} else {
			System.out.println("성공");
		}
		
		
		/*
		boolean test = true;
		
	
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = i+1 ; j < 4 ; j++){
				if(numbers[j]==numbers[i]) {
					System.out.println("실패");
					test = false;
					break;
				}
			}
			
			if(test == false) break;
		}
		
		if(test == true) System.out.println("성공");
		*/
		
		
		

	}

}
