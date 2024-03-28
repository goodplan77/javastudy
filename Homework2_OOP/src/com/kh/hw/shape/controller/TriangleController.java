package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class TriangleController {

	private Shape s;

	public double calcArea(double height, double width) {
		s = new Shape(0, height, width);
		return (s.getheight() * s.getwidth()) / 2;
	}

	public void paintColor(String color) {
		s.setcolor(color);
	}

	public String print() {
		return "삼각형 " + s.information();
	}

}
