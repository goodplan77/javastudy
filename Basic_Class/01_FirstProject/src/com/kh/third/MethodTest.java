package com.kh.third;

public class MethodTest {

	public void testA() {
		System.out.println("testA 메서드 호출됨");
		testB();
	}
	
	public void testB() {
		System.out.println("testB 메서드 호출됨");
		testC();
	}
	
	public void testC() {
		System.out.println("testC 메서드 호출됨");
	}
	
	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
		mt.testA();
	}
}
