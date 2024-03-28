package com.kh.chap01_oneVsMany.run;

import java.util.Scanner;

import com.kh.chap01_oneVsMany.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		/*
		// 1. 기본생성자를 이용해 객체를 생성후 setter 를 통해 필드 초기화
		Book bk1 = new Book();
		bk1.setTitle("자바의 정석");
		bk1.setAuthor("자바신");
		bk1.setPublisher("자바");
		bk1.setPrice(20000);
		
		// 2. 매개 변수 있는 생성자로 객체 생성과 동시에 필드 초기화
		Book bk2 = new Book("자바프로그래밍" , "박은종" , "이지스퍼블리싱" , 25000);
		
		// 3. 매개변수 있는 생성자로 객체 생성과 동시에 필드 초기화
		
		System.out.print("제목 : ");
		String title = sc.nextLine();

		System.out.print("저자 : ");
		String author = sc.nextLine();

		System.out.print("출판사 : ");
		String publisher = sc.nextLine();

		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		Book bk3 = new Book(title , author , publisher , price);
		
		System.out.println(bk1);
		System.out.println(bk2);
		System.out.println(bk3);
		
		System.out.print("검색할 책 제목을 입력해주세요.");
		String searchTitle = sc.nextLine();
		
		if(bk1.getTitle().equals(searchTitle)) {
			System.out.println(bk1);
		}
		
		if(bk2.getTitle().equals(searchTitle)) {
			System.out.println(bk2);
		}
		
		if(bk3.getTitle().equals(searchTitle)) {
			System.out.println(bk3);
		}	
		*/
		
		Book[] arr = new Book[1000];
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = new Book(i+"도서" , i+"저자" , i+"출판사" , i*100);
		}
		
		// 사용자에게 검색할 도서 제목을 입력받아
		// 전체 도서들의 제목과 일일이 비교하여 일치하는 도서의 가격을 출력
		// 만약 , 일치하는 도서를 찾지 못한 경우 "검색한 도서가 없습니다" 를 출력
		
		System.out.print("검색할 제목 : ");
		String input = sc.nextLine();
		
		boolean isFound = false;
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i].getTitle().equals(input)) {
				System.out.print("일치한 도서의 가격 : " + arr[i].getPrice());
				isFound = true;
				break;
			}
		}
		
		if(isFound == false) {
			System.out.println("검색한 도서가 없습니다.");
		}

	}

}
