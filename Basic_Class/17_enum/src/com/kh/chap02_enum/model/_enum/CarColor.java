package com.kh.chap02_enum.model._enum;

import java.util.Arrays;

public enum CarColor {
	BLACK(0) {
		@Override
		public void printTest() {
			System.out.println("저는 검정 입니다.");
		}
	} , RED(1) {
		@Override
		public void printTest() {
			System.out.println("저는 빨강 입니다.");
		}
	} , BLUE(2) {
		@Override
		public void printTest() {
			System.out.println("저는 파랑 입니다.");
		}
	};

	/*
		public static final CarColor BLACK	= new CarColor("BLACK");
		public static final CarColor RED	= new CarColor("RED");
		public static final CarColor BLUE	= new CarColor("BLUE");
		
		private String name;
	
		public CarColor(String name) {
			this.name=name;
		}
	*/
	
	private CarColor(int color) {
		this.color = color;
		System.out.println(this + "객체 생성됨");
	}
	// enum 도 결국 클래스 이기 때문에 내가 원하는 메서드를 정의 하거나 , 오버라이딩 가능함
	// 단 , 상수 값들을 관리하기 위한 용도의 메서드를 작성하는 것을 권장함.
	
	private int color;
	
	public int getColor() {
		return color;
	}
	
	// enum 내부의 값들을 반복문 돌리기
	public static CarColor valueof(int color) {
		CarColor[] arr = values(); // enum 내부의 상수값들 모아서 배열로 반환해주는 메소드[BLACK RED BLUE]
		
		return Arrays.stream(arr)
					.filter(value -> value.color == color)
					.findAny()
					.orElse(null);
	}
	
	// 상수 값 마다 고유한 메서드(기능) 부여 하기.
	public abstract void printTest();
		
}
