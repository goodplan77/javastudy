package com.kh.practice.chap01_poly.view;

import java.util.Scanner;
import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.*;

public class LibraryMenu {

	LibraryController lc = new LibraryController();
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		System.out.print("나이 : ");
		int inputAge = sc.nextInt();
		sc.nextLine();

		System.out.print("성별 : ");
		String inputGender = sc.nextLine();

		Member temp = new Member(inputName, inputAge, inputGender.charAt(0));
		lc.insertMember(temp);

		while (true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회 ");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");

			System.out.print("메뉴 번호 : ");
			int menuSelect = sc.nextInt();
			sc.nextLine();

			switch (menuSelect) {
			case 1:
				System.out.println(lc.myInfo().toString());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void selectAll() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "번 도서 : " + lc.selectAll()[i].toString());
		}
		System.out.println();
	}

	public void searchBook() {
		System.out.print("검색할 제목 키워드 : ");
		String inputWord = sc.nextLine();

		Book[] result = lc.searchBook(inputWord);

		if (result == null) {
			System.out.println();
			return;
		} else {
			for (Book temp : result) {
				System.out.println(temp.toString());
			}
		}
		System.out.println();
	}

	public void rentBook() {
		selectAll();
		System.out.print("대여할 도서 번호 선택 : ");
		int result = lc.rentBook(sc.nextInt());
		sc.nextLine();

		switch (result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
			break;
		default:
			System.out.println("오류 발생");
			break;
		}

		System.out.println();
	}

}
