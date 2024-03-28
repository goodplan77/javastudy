package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {

	Scanner sc = new Scanner(System.in);
	SnackController scr = new SnackController();

	public void menu() {
		System.out.println("스낵류를 입력하세요.");

		System.out.print("종류 : ");
		String inputKind = sc.nextLine();

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		System.out.print("맛 : ");
		String inputFlavor = sc.nextLine();

		System.out.print("개수 : ");
		int inputNumOf = sc.nextInt();

		System.out.print("가격 : ");
		int inputPrice = sc.nextInt();

		sc.nextLine();

		System.out.println(scr.saveData(inputKind, inputName, inputFlavor, inputNumOf, inputPrice));

		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		char confirm = sc.nextLine().charAt(0);

		if (confirm == 'Y' || confirm == 'y')
			System.out.println(scr.confirmData());

	}

}
