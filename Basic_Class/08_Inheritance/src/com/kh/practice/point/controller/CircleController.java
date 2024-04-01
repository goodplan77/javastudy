package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {

	private Circle c = new Circle();

	public String calcArea(int x, int y, int radius) {
		
		// 혹은 새 객체를 생성하지 않고 setter() 함수를 이용해서 값만 받아서 해도 가능함 (컨트롤러 객체 생성시 이미 상단에서 Circle 객체를 생성함)
		// c.setRadius(radius);
		// c.setX(x);
		// c.setY(y);
		
		c = new Circle(x,y,radius);
		double result = Math.PI * radius * radius;
		return c.toString() + " / " + result;
		
		// return c + " / " + result;
		// toString() 자동 호출. c 만 표기 해도됨?
	}

	public String calcCircum(int x, int y, int radius) {
		c = new Circle(x,y,radius);
		double result = Math.PI * radius * 2;
		return c.toString() + " / " + result;
	}

}
