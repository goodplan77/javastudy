package com.kh.hw.employee.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.employee.controller.EmployeeController;

public class EmployeeMenu {

	Scanner sc = new Scanner(System.in);
	EmployeeController ec = new EmployeeController();

	public EmployeeMenu() {
		while (true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 수정");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 사원 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호를 누르세요 : ");

			int input = sc.nextInt();
			sc.nextLine();

			if (input == 1) {
				insertEmp();

			} else if (input == 2) {
				updateEmp();

			} else if (input == 3) {
				deleteEmp();

			} else if (input == 4) {
				printEmp();

			} else if (input == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("잘못 입력했습니다.");

			}
		}
	}

	public void insertEmp() {
		System.out.print("사원 번호 : ");
		int inputEmpNo = sc.nextInt();
		sc.nextLine();

		System.out.print("사원 이름 : ");
		String inputName = sc.nextLine();

		System.out.print("사원 성별 : ");
		char inputGender = sc.nextLine().charAt(0);

		System.out.print("전화 번호 : ");
		String inputPhone = sc.nextLine();

		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char addSelect = sc.nextLine().charAt(0);

		if (addSelect == 'y' || addSelect == 'Y') {

			System.out.print("사원 부서 : ");
			String inputDept = sc.nextLine();

			System.out.print("사원 연봉 : ");
			int inputSalary = sc.nextInt();

			System.out.print("보너스 율 : ");
			double inputBouns = sc.nextDouble();

			ec.add(inputEmpNo, inputName, inputGender, inputPhone, inputDept, inputSalary, inputBouns);

		} else {
			ec.add(inputEmpNo, inputName, inputGender, inputPhone);
		}

	}

	public void updateEmp() {

		while (true) {

			System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
			System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
			System.out.println("1. 전화 번호");
			System.out.println("2. 사원 연봉");
			System.out.println("3. 보너스 율");
			System.out.println("9. 돌아가기");

			System.out.print("메뉴 번호를 누르세요 : ");
			int select = sc.nextInt();
			sc.nextLine();

			if (select == 1) {
				System.out.print("수정할 전화 번호 : ");
				ec.modify(sc.nextLine());

			} else if (select == 2) {
				System.out.print("수정할 사원연봉 : ");
				ec.modify(sc.nextInt());

			} else if (select == 3) {
				System.out.print("수정할 보너스 율 : ");
				ec.modify(sc.nextDouble());

			} else if (select == 9) {
				System.out.println("메인메뉴로 돌아갑니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

	}

	public void deleteEmp() {
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		char removeSelect = sc.nextLine().charAt(0);

		if (removeSelect == 'y' || removeSelect == 'Y') {
			if (ec.remove() == null) {
				System.out.println("데이터 삭제에 성공하였습니다.");
			} else {
				System.out.println("데이터 삭제에 실패하였습니다.");
			}
		}

	}

	public void printEmp() {
		if (ec.inform() == null) {
			System.out.println("사원 데이터가 없습니다");
		} else {
			System.out.println(ec.inform());
		}
	}

}
