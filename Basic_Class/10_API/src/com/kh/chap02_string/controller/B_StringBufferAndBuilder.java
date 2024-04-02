package com.kh.chap02_string.controller;

public class B_StringBufferAndBuilder {
	// String은 불변클래스 => 저장공간에서 값이 수정되지 않음.
	// StringBuffer , StringBuilder은 가변 클래스 => 처음 할당받은 저장공간에서 값을 수정한다.
	// 문자열 연산이 빈번하게 발생하는 알고리즘들에서 메모리 부족이슈를 해결하기 위해 나온 클래스.
	
	/*
	 * StringBuffer 와 StringBuilder는 동일한 메서드를 지닌다.
	 * 차이점은 동기화 여부.
	 * 
	 * Thread개념 적용.
	 * StringBuffer => 멀리스레드 환경에서 유용
	 * StringBuilder => 단일스레드 환경에서 유용 (성능상 빠름)
	 */
	
	public void method() {
		String str = "hello";
		str += "world"; // 주소 2개 할당.
		
		StringBuffer sb = new StringBuffer("Hello");
		sb.append("World");
		
		StringBuilder sb2 = new StringBuilder("Hello");
		sb2.append("World");
		
		// StringBuffer , Buffer의 메서드들
		sb.deleteCharAt(0); //0번 인덱스의 문자 하나 삭제
		
		System.out.println("HelloWorld에서 o의 마지막 위치는 ? " + sb2.lastIndexOf("o")); // 특정 문자열의 마지막 인덱스 확인
		
		int length = sb2.length();
		System.out.println("sb2의 길이 : " + length); // 문자열 길이 확인
		
		StringBuilder sb3 = new StringBuilder("abc123.txt");
		System.out.println("abc123.txt에서 .txt제거하기 " + sb3.delete(sb3.lastIndexOf("."), sb3.length())); //start 지점에서 부터 문자열 길이 까지 삭제
		
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3);
	}

}
