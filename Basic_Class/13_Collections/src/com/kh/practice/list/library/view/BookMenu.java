package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();

	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		System.out.println();

		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제 ");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");

			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int menuSelect = Integer.parseInt(sc.nextLine());

			switch (menuSelect) {
			case 1:
				insertBook();
				break;
			case 2:
				selectList();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				ascBook();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				break;
			}
		}
	}

	public void insertBook() {
		System.out.println("===== 새 도서 추가 =====");
		System.out.println("책 정보를 입력해주세요.");

		System.out.print("도서 명 : ");
		String inputTitle = sc.nextLine();

		System.out.print("저자 명 : ");
		String inputAuthor = sc.nextLine();

		System.out.print("장르(1. 인문 / 2. 과학 / 3. 외국어 / 4. 기타) : ");
		int inputCatrgorytemp = Integer.parseInt(sc.nextLine());

		String inputCatrgory;
		switch (inputCatrgorytemp) {
		case 1:
			inputCatrgory = "인문";
			break;
		case 2:
			inputCatrgory = "자연과학";
			break;
		case 3:
			inputCatrgory = "의료";
			break;
		default:
			inputCatrgory = "기타";
			break;
		}

		System.out.print("가격 : ");
		int inputPrice = Integer.parseInt(sc.nextLine());

		Book bk = new Book(inputTitle, inputAuthor, inputCatrgory, inputPrice);
		bc.insertBook(bk);
	}

	public void selectList() {
		ArrayList<Book> temp = bc.selectList();
		if (temp.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다");
		} else {
			for (Book m : temp) {
				System.out.println(m);
			}
		}
	}

	public void searchBook() {
		System.out.print("검색 키워드 : ");
		String searchKeyword = sc.nextLine();
		ArrayList<Book> temp = bc.searchBook(searchKeyword);
		if (temp.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다");
			return;
		}

		for (Book m : temp) {
			System.out.println(m);
		}

	}

	public void deleteBook() {
		System.out.print("삭제할 도서 명 : ");
		String inputTitle = sc.nextLine();

		System.out.print("삭제할 저자 명 : ");
		String inputAuthor = sc.nextLine();

		Book remove = bc.deleteBook(inputTitle, inputAuthor);
		if (remove == null) {
			System.out.println("삭제할 도서를 찾지 못했습니다");
			return;
		}

		System.out.println("성공적으로 삭제되었습니다");
	}

	public void ascBook() {
		if (bc.ascBook() > 0) {
			System.out.println("정렬에 성공하였습니다");
		} else {
			System.out.println("정렬에 실패하였습니다.");
		}
	}

}
