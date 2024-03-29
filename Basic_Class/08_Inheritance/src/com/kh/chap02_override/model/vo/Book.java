package com.kh.chap02_override.model.vo;

import com.kh.chap01_beforeVsAfter.after.model.vo.override;

public class Book {

	private String title;
	private String author;
	private int price;
	
	public Book() {
		//super();
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 * 오버라이딩
	 * - 상속받고 있는 부모 클래스의 메소드를 자식 클래스에서 재정의(Over ride) 하는 것
	 * - 부모가 제공하고 있는 메소드를 자식이 일부 고쳐서 사용하겠다 는 의미
	 * - 실행시 자식 메소드가 우선권을 가짐
	 * 
	 * 성립 조건
	 * - 부모 메소드의 메소드명과 동일해야 함
	 * - 매개변수의 자료형 , 개수 , 순서가 완전히 동일 해야함 (매개 변수 명은 상관 없음)
	 * - 반환 형도 동일 해야함
	 * 
	 * @Override 어노테이션(주석)
	 * - 생략 가능(명시를 안해도 부모 메소드와 형태가 같으면 오버라이딩이 자동적으로 이루어짐)
	 * - 어노테이션을 붙이는 이유
	 * -> 잘못 기술시 오류를 알려줌 -> 수정 가능
	 * -> 부모 클래스의 메소드가 나중에 수정된 경우 , 오류를 알려주기 때문에 검토 할 수있음
	 * -> 이 메소드가 오버라이딩 된 메소드임을 알리는 목적
	 */
	
	@Override
	public String toString() {
		return "title : " + title + ", author : " + author + ", price : " + price;
	}
	
}
