package com.kh.example.practice3.model.vo;

public class Circle {

	private static double PI = 3.14;
	private int radius = 1;
	
	public void incrementRadius() {
		radius++;
	}
	
	public void getAreaOfCircle() {
		System.out.println(2 * PI * radius);
	}
	
	public void getSizeOfCircle() {
		System.out.println(radius * radius * PI);
	}
	
}
