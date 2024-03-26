package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {

	Scanner sc = new Scanner(System.in);

	SquareController scr = new SquareController();
	TriangleController tc = new TriangleController();

	public void inputMenu() {
		while (true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int input = sc.nextInt();

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
			System.out.println("프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int input = sc.nextInt();

			if (input == 1) {

			} else if (input == 2) {

			} else if (input == 3) {

			} else if (input == 9) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}
	}

	private void squareMenu() {
		while (true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 둘레");
			System.out.println("2. 삼각형 면적");
			System.out.println("3. 삼각형 색칠");
			System.out.println("4. 삼각형 정보");
			System.out.println("프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int input = sc.nextInt();

			if (input == 1) {

			} else if (input == 2) {

			} else if (input == 3) {

			} else if (input == 4) {

			} else if (input == 9) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}
	}

	private void inputSize(int type, int menuNum) {

	}

	private void printInformation(int type) {

	}

}
