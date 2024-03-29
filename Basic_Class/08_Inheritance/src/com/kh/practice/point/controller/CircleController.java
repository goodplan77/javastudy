package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {

	private Circle c = new Circle();
	
	public static final double PI = 3.14;

	public String calcArea(int x, int y, int radius) {
		c = new Circle(x,y,radius);
		double result = PI * radius * radius;
		return c.toString() + " / " + result;
	}

	public String calcCircum(int x, int y, int radius) {
		c = new Circle(x,y,radius);
		double result = PI * radius * 2;
		return c.toString() + " / " + result;
	}

}
