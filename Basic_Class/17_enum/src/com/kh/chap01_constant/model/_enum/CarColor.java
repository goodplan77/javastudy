package com.kh.chap01_constant.model._enum;

public class CarColor {
	public static final CarColor BLACK	= new CarColor("BLACK");
	public static final CarColor RED	= new CarColor("RED");
	public static final CarColor BLUE	= new CarColor("BLUE");
	
	private String name;
	
	public CarColor(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "CarColor [name=" + name + "]";
	}
	
}
 /*
interface CARCOLOR {
	int BLACK = 0 , RED = 0 , BLUE = 2;
}
*/
