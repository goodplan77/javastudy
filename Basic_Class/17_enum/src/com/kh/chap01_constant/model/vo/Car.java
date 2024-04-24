package com.kh.chap01_constant.model.vo;

import com.kh.chap01_constant.model._enum.CarColor;

public class Car {
	private String name;
	private CarColor carColor;
	
	public Car() {
		
	}
	
	public String getName() {
		return name;
	}
	public CarColor getCarColor() {
		return carColor;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", carColor=" + carColor + "]";
	}
	
}
