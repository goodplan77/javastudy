package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class SquareController {

	private Shape s = new Shape();

	public double calcPerimeter(double height, double width) {
		s = new Shape(1, height, width);
		return (2 * s.getheight()) + (2 * s.getwidth());
	}

	public double calcArea(double height, double width) {
		s = new Shape(1, height, width);
		return s.getheight() * s.getwidth();
	}

	public void paintColor(String color) {
		s.setcolor(color);
	}

	public String print() {
		return "사각형 " + s.information();
	}

}
