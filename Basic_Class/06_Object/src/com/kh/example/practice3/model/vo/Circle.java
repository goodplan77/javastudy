package com.kh.example.practice3.model.vo;

public class Circle {

	private static final double PI = 3.14;
	private static int radius = 1;
	
	public Circle() {
		
	}
	
	public void incrementRadius() {
		radius++;
	}
	
	//넓이
	public void getAreaOfCircle() {
		System.out.println(radius * radius * PI);
	}
	
	//둘레
	public void getSizeOfCircle() {
		System.out.println(2 * PI * radius);
	}
	
}
