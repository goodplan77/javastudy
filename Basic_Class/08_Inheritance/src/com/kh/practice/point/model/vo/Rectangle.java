package com.kh.practice.point.model.vo;

public class Rectangle extends Point {

	private int width;
	private int height;

	public Rectangle() {
	}

	public Rectangle(int x, int y , int height , int width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString() + " " + height + " " + width;
	}

	
}
