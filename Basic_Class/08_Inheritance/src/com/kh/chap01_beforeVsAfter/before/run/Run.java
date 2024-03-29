package com.kh.chap01_beforeVsAfter.before.run;

import com.kh.chap01_beforeVsAfter.before.model.vo.*; // com.kh.chap01_beforeVsAfter.before.model.vo 에 존재하는 모든 클래스 import

public class Run {

	public static void main(String[] args) {
		
		//Desktop
		Desktop d = new Desktop("삼성","d-01","삼성 데스크탑",2000000,true);
		
		//SmartPhone
		SmartPhone s = new SmartPhone("애플","S-01","아이폰",1300000,"LGU+");
		
		//TV
		TV t = new TV("LG","t-01","울트라씬티비",3500000,30);
		
		//출력
		
		System.out.println(d.toString());
		System.out.println(s.toString());
		System.out.println(t.toString());
		
		/*
		 * 상속이 없다면?
		 * 매 클래스마다 중복된 코드를 일일이 기술해 줘야함
		 * 유지보수시 모든 클래스를 일일이 수정해야함
		 * 
		 * 상속이라는 개념을 통해 중복된 필드 및 메서드를 하나의 클래스로 정의해서 관리를 할 예정
		 */
	}

}
