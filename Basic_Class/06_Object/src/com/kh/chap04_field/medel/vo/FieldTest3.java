package com.kh.chap04_field.medel.vo;


// static 변수와 상수 필드
public class FieldTest3 {
	// 접근제한자 [예약어][예약어] 자료형 변수명;
	
	public static String sta = "static";
	/*
	 * static 키워드는 특정 변수나 메소드를 static 영역에 움직이지 않게 고정 시켜둠.
	 * 고정된 데이터나 메소드는 모든 객체에서 "공유"하면서 사용된다.
	 * 따라서 보통 자주 사용되는 변수 (PI값, E값), 메서드(random(), ...)은 static을 선언함으로써 
	 * 메모리 영역에 미리 올려두고 모든 객체에서 공유하며 사용한다.
	 * 
	 * 생성시점 : 프로그램 시작과 동시에
	 * 소멸시점 : 프로그램 종료시
	 * 
	 */
	
	/*
	 * 상수 필드
	 * public static final 자료형 변수명 = 값;
	 * 한 번 지정된 값을 "변경"할 수 없음
	 * static의 특징
	 * 한번만 메모리에 올려두고 공유해서 사용한다.
	 * 
	 * 값이 변경되어서는 안되는 고정 값을 메모리 상에 올려두고, 공유하며 사용할 목적으로 
	 * static final을 사용함.
	 * 
	 */
	
	public static final int NUM = 10;
	public int num =1;
	
	public static void test() {
//		System.out.println(NUM);
//		System.out.println(NUM + num);		//static 생성시점과 일반변수 생성시점이 다르기 때문에 함께 출력할 수 없다.
	}
	
	
	
}
