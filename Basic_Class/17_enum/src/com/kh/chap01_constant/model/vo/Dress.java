package com.kh.chap01_constant.model.vo;

public class Dress {
	private String name;
	private int DressColor;
	
	public String getName() {
		return name;
	}
	public int getDressColor() {
		return DressColor;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDressColor(int dressColor) {
		DressColor = dressColor;
	}
	
	@Override
	public String toString() {
		return "Dress [name=" + name + ", DressColor=" + DressColor + "]";
	}

}
