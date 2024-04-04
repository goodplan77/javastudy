package com.kh.exception.controller;

public class C_CustomException extends RuntimeException{
	
	/*
	 * 특정 상황에서 발생하는 에러를 직접 만드는 방법.
	 * 
	 * 1.	예외처리 클래스 만든 후 , Exception 계열 클래스 상속 받기.
	 * 
	 * 2.	super 키워드를 통해 부모 생성자에게 매개변수로 전달 받은 에러메세지 전달
	 * 		부모 생성자에서 메세지 내용 호출하면서 예외 처리 하기.
	 */
	
	public C_CustomException () {
		
	}
	
	public C_CustomException (String msg) {
		super(msg);
	}

}
