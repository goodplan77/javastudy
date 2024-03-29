package com.kh.chap01_beforeVsAfter.after.model.vo;

public class TV extends Product {
	private int inch;

	public TV() {
	}

	public TV(String brand, String pCode, String pName, int price, int inch) {
		super(brand, pCode, pName, price);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return super.toString() + ", inch : " + inch;
	}
}
