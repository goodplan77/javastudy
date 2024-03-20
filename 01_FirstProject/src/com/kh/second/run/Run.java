package com.kh.second.run;

import com.kh.second.MyName; // 다른 패키지에 있는 클래스 import

public class Run {
	
	public static void main(String[] args) {
		MyName mn = new MyName(); // 메인 메소드로 불러오기
		mn.callMyName(); // 불러온 클래스의 메서드 사용
		
	}

}
