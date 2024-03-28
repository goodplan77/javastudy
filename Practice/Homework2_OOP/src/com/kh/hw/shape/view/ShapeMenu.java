package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {

	private Scanner sc = new Scanner(System.in);

	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();

	public void inputMenu() {
		while (true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int input = sc.nextInt();
			sc.nextLine();

			if (input == 3) {
				triangleMenu();

			} else if (input == 4) {
				squareMenu();

			} else if (input == 9) {
				System.out.println("프로그램 종료");
				break;

			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}

	}

	private void triangleMenu() {

		while (true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int input = sc.nextInt();
			sc.nextLine();

			if (input == 1) {
				inputSize(0, 1);
			} else if (input == 2) {
				inputSize(0, 2);
			} else if (input == 3) {
				printInformation(0);
			} else if (input == 9) {
				System.out.println("메인으로 돌아갑니다.");
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				 continue;
			}
		}
	}

	private void squareMenu() {
		while (true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 면적");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int input = sc.nextInt();
			sc.nextLine();

			if (input == 1) {
				inputSize(1, 1);
			} else if (input == 2) {
				inputSize(1, 2);
			} else if (input == 3) {
				inputSize(1, 3);
			} else if (input == 4) {
				printInformation(1);
			} else if (input == 9) {
				System.out.println("메인으로 돌아갑니다.");
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}
	}

	private void inputSize(int type, int menuNum) {
		switch (type) {
		case 0: {
			switch (menuNum) {
			case 1: {
				System.out.print("높이 : ");
				int inputHeight = sc.nextInt();

				System.out.print("너비 : ");
				int inputWidth = sc.nextInt();
				sc.nextLine();
				
				System.out.println("삼각형 면적 : " + tc.calcArea(inputHeight, inputWidth));
				break;
			}
			case 2: {
				System.out.print("색깔을 입력하세요 : ");
				String inputColor = sc.nextLine();
				tc.paintColor(inputColor);
				System.out.println("색이 수정되었습니다");
				break;
			}
			}
			return;
		}
		case 1: {
			switch (menuNum) {
			case 1, 2: {
				System.out.print("높이 : ");
				int inputHeight = sc.nextInt();

				System.out.print("너비 : ");
				int inputWidth = sc.nextInt();
				sc.nextLine();
				
				if (menuNum == 1) {
					System.out.println("사각형 둘레 : " + scr.calcPerimeter(inputHeight, inputWidth));
				} else if (menuNum == 2) {
					System.out.println("사각형 면적 : " + scr.calcArea(inputHeight, inputWidth));
				}
				break;
			}
			case 3: {
				System.out.print("색깔을 입력하세요 : ");
				String inputColor = sc.nextLine();
				scr.paintColor(inputColor);
				System.out.println("색이 수정되었습니다");
				break;
			}
			}
			break;
		}
		}
		return;
	}

	private void printInformation(int type) {
		switch (type) {
		case 0:
			System.out.println(tc.print());
			break;
		case 1:
			System.out.println(scr.print());
			break;
		}
	}

}
