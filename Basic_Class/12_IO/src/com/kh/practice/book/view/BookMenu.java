package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();

	private Book[] bArr; // = null;

	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
	}

	public void mainMenu() {
		while (true) {
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력 ");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				fileSave();
				break;
			case 2:
				fileRead();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}
		}

	}

	public void fileSave() {
		System.out.print("도서 명 : ");
		String title = sc.nextLine();

		System.out.print("저자 명 : ");
		String author = sc.nextLine();

		System.out.print("도서 가격 : ");
		int price = Integer.parseInt(sc.nextLine());

		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String[] date = sc.nextLine().split("-", 3);
		Calendar d1 = Calendar.getInstance();
		d1.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));

		System.out.print("할인율 : ");
		double discount = Double.parseDouble(sc.nextLine());

		Book temp = new Book(title, author, price, d1, discount);

		for (int i = 0; i < bArr.length; i++) {
			if (bArr[i] == null) {
				bArr[i] = temp;
				break;
			}
		}

		bc.fileSave(bArr);
	}

	public void fileRead() {
		for (Book t : bc.fileRead()) {
			if (t != null) {
				System.out.println(t.toString());
			}
		}
		System.out.println();
	}

}
