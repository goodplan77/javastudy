package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {

	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();

	public void mainMenu() {

		while (true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("3. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuSelect = sc.nextInt();
			sc.nextLine();

			switch (menuSelect) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 3:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("종료합니다.");
				return;
			}
		}
	}

	public void circleMenu() {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("3. 메인으로");
		System.out.print("메뉴 번호 : ");
		int menuSelect = sc.nextInt();
		sc.nextLine();

		switch (menuSelect) {
		case 1:
			calcCircum();
			break;
		case 2:
			calcCircleArea();
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	public void rectangleMenu() {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("3. 메인으로");
		System.out.print("메뉴 번호 : ");
		int menuSelect = sc.nextInt();
		sc.nextLine();

		switch (menuSelect) {
		case 1:
			calcPerimeter();
			break;
		case 2:
			calcRectArea();
			break;
		case 9:
			break;
		default:
			break;
		}
	}

	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int inputX = sc.nextInt();

		System.out.print("y 좌표 : ");
		int inputY = sc.nextInt();

		System.out.print("반지름 : ");
		int inputRadius = sc.nextInt();

		System.out.println(cc.calcCircum(inputX, inputY, inputRadius));
	}

	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int inputX = sc.nextInt();

		System.out.print("y 좌표 : ");
		int inputY = sc.nextInt();

		System.out.print("반지름 : ");
		int inputRadius = sc.nextInt();

		System.out.println(cc.calcArea(inputX, inputY, inputRadius));
	}

	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int inputX = sc.nextInt();

		System.out.print("y 좌표 : ");
		int inputY = sc.nextInt();

		System.out.print("높이 : ");
		int inputHeight = sc.nextInt();

		System.out.print("너비 : ");
		int inputWidth = sc.nextInt();

		System.out.println(rc.calcPerimeter(inputX, inputY, inputHeight, inputWidth));
	}

	public void calcRectArea() {

		System.out.print("x 좌표 : ");
		int inputX = sc.nextInt();

		System.out.print("y 좌표 : ");
		int inputY = sc.nextInt();

		System.out.print("높이 : ");
		int inputHeight = sc.nextInt();

		System.out.print("너비 : ");
		int inputWidth = sc.nextInt();

		System.out.println(rc.calcArea(inputX, inputY, inputHeight, inputWidth));
	}

}
