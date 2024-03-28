package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.inform();
		
		Book book2 = new Book("title1","publisher1","author1");
		book2.inform();	
		
		Book book3 = new Book("title2","publisher2","author2",10000,10);
		book3.inform();
		
	}

}
