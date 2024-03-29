package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;

public class PersonMenu {

	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();

	public void mainMenu() {

		while (true) {
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.printf("현재 저장된 학생은 %d명입니다.\n", pc.personCount()[0]);
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.printf("현재 저장된 사원은 %d명입니다.\n", pc.personCount()[1]);

			System.out.println();

			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");

			System.out.print("메뉴 번호 : ");
			int menuSelect = sc.nextInt();
			sc.nextLine();

			switch (menuSelect) {
			case 1:
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

		}
	}

	public void studentMenu() {

		while (true) {
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");

			if (pc.personCount()[0] == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
			}

			System.out.print("메뉴 번호 : ");
			int menuSelect = sc.nextInt();
			sc.nextLine();

			switch (menuSelect) {
			case 1: {
				if (pc.personCount()[0] == 3) {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
				insertStudent();
				break;
			}
			case 2:
				printStudent();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
	}

	public void employeeMenu() {
		while (true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");

			if (pc.personCount()[1] == 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더 이상 활성화 되지 않습니다.");
			}

			System.out.print("메뉴 번호 : ");
			int menuSelect = sc.nextInt();
			sc.nextLine();

			switch (menuSelect) {
			case 1: {
				if (pc.personCount()[1] == 10) {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
				insertEmployee();
				break;
			}
			case 2:
				printEmployee();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
	}

	public void insertStudent() {
		while (pc.personCount()[0] <= 3) {
			System.out.print("학생 이름 : ");
			String inputStudentName = sc.nextLine();

			System.out.print("학생 나이 : ");
			int inputStudentAge = sc.nextInt();

			System.out.print("학생 키 : ");
			double inputStudentHeight = sc.nextDouble();

			System.out.print("학생 몸무게 : ");
			double inputStudentWeight = sc.nextDouble();

			System.out.print("학생 학년 : ");
			int inputStudentGrade = sc.nextInt();
			sc.nextLine();

			System.out.print("학생 전공 : ");
			String inputStudentMajor = sc.nextLine();

			pc.insertStudent(inputStudentName, inputStudentAge, inputStudentHeight, inputStudentWeight,
					inputStudentGrade, inputStudentMajor);

			if (pc.personCount()[0] < 3) {
				System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 :");
				char continueInsert = sc.nextLine().charAt(0);

				if (continueInsert == 'n' || continueInsert == 'N') {
					break;
				} else {
					continue;
				}
			} else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다");
				break;
			}
		}

	}

	public void printStudent() {
		for (int i = 0; i < pc.personCount()[0]; i++) {
			System.out.println(pc.printStudent()[i].toString());
		}

	}

	public void insertEmployee() {
		while (pc.personCount()[0] < 10) {
			System.out.print("사원 이름 : ");
			String inputEmpolyeeName = sc.nextLine();

			System.out.print("사원 나이 : ");
			int inputEmpolyeeAge = sc.nextInt();

			System.out.print("사원 키 : ");
			double inputEmpolyeeHeight = sc.nextDouble();

			System.out.print("사원 몸무게 : ");
			double inputEmpolyeeWeight = sc.nextDouble();

			System.out.print("사원 급여 : ");
			int inputEmpolyeeSalary = sc.nextInt();
			sc.nextLine();

			System.out.print("사원 부서 : ");
			String inputEmpolyeeMajor = sc.nextLine();

			pc.insertEmployee(inputEmpolyeeName, inputEmpolyeeAge, inputEmpolyeeHeight, inputEmpolyeeWeight,
					inputEmpolyeeSalary, inputEmpolyeeMajor);

			if (pc.personCount()[0] <= 10) {
				System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 :");
				char continueInsert = sc.nextLine().charAt(0);

				if (continueInsert == 'n' || continueInsert == 'N') {
					break;
				} else {
					continue;
				}
			} else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다");
				break;
			}
		}
	}

	public void printEmployee() {
		for (int i = 0; i < pc.personCount()[1]; i++) {
			System.out.println(pc.printEmployee()[i].toString());
		}
	}

}
