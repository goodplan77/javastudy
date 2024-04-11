package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.library.model.vo.Book;

public class BookController {

	private List bookList = new ArrayList();

	public BookController() {
		bookList.add(new Book("자바의 정석", "남궁 성", "기타", 20000));
		bookList.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		bookList.add(new Book("대화의 기술", "강보람", "인문", 17500));
		bookList.add(new Book("암 정복기", "박신우", "의료", 21000));
	}

	public void insertBook(Book bk) {
		bookList.add(bk);
	}

	public ArrayList selectList() { // public List selectList() 로 하는 경우가 많음?
		return (ArrayList) bookList;
	}

	public ArrayList searchBook(String keyword) {
		ArrayList searchList = new ArrayList();
		for (Object o : bookList) {
			Book b = (Book) o;
			if (b.getTitle().contains(keyword)) {
				searchList.add(b);
			}
		}

		return searchList;
	}

	public Book deleteBook(String title, String author) {
		Book removeBook = null;
		for (int i = 0; i < bookList.size(); i++) {
			Book searchBook = (Book) bookList.get(i);
			String sTitle = searchBook.getTitle();
			String sAuthor = searchBook.getAuthor();
			if (sTitle.equals(title) && sAuthor.equals(author)) {
				removeBook = searchBook;
				bookList.remove(i);
				// removeBook = (Book) bookList.remove(i); // 리스트에 지우면서 지워지는 객체를 동시에 반환
				// remove : 인덱스를 넣어준 경우 바로 접근. 객체를 넣어준 경우 반복문을 돌려서 equals() 메소드로 확인해서 지움
				break;
			}
		}

		return removeBook;
	}

	public int ascBook() {
		try {
			Collections.sort(bookList);
		} catch(Exception e) {
			return 0;
		}
		
		return 1;
	}
}
