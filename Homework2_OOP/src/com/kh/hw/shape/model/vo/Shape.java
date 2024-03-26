package com.kh.hw.shape.model.vo;

public class Shape {
	
	private int type;
	private double height;
	private double width;
	private String color = "white";
	
	public Shape() {
		
	}
	
	public Shape(int type , double height , double width) {
		this.type = type;
		this.height = height;
		this.width = width;
	}
	
	public String information() {
		return height + " " + width + " " + color;
	}
	
	public int gettype () {
		return type;
	}
	
	public void settype(int type) {
		this.type=type;
	}
	
	public double getheight() {
		return height;
	}
	
	public void setheight(double height) {
		this.height=height;
	}

	public double getwidth() {
		return width;
	}
	
	public void setwidth(double width) {
		this.width=width;
	}
	
	public String getcolor() {
		return color;
	}
	
	public void setcolor(String color) {
		this.color = color;
	}
	
}
