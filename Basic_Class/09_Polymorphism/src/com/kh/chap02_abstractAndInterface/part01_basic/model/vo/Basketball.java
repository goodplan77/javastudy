package com.kh.chap02_abstractAndInterface.part01_basic.model.vo;

public class Basketball extends Sports{
	
	// 미완성된 클래스인 추상클래스를 상속받게 되면 , 
	// 부모클래스의 추상메소드를 반드시 오버라이딩 해야함
	
	@Override
	public void rule() {
		System.out.println("손으로 공을 던져 링에 넣어야 한다.");
	}

}
