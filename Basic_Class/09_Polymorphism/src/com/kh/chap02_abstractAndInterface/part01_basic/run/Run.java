package com.kh.chap02_abstractAndInterface.part01_basic.run;

import com.kh.chap02_abstractAndInterface.part01_basic.model.vo.Basketball;
import com.kh.chap02_abstractAndInterface.part01_basic.model.vo.Football;
import com.kh.chap02_abstractAndInterface.part01_basic.model.vo.Sports;

public class Run {

	public static void main(String[] args) {
		// Sports s = new Sports();
		// 추상 클래스로 객체 생성 불가. 미완성된 클래스
		
		Sports s; // 객체 생성 x. 참조 변수로서는 사용 가능
		s = new Football();
		
		Sports[] arr = new Sports[2];
		arr[0] = new Basketball();
		arr[1] = new Football();
		
		for(Sports sp : arr) {
			sp.start();
		}
		/*
		 * 추상클래스 정리
		 * - 미완성된 클래스(abstract class)
		 * - 객체 생성 불가능(단, 참조변수로는 사용 가능)
		 * - 추상메소드가 존재 하는 순간 클래스도 반드시 추상클래스로 정의
		 * 
		 * 추상메소드
		 * - 미완성된 메소드로 몸통부 {}가 구현되어 있지 않는 메소드
		 * - 실제 구현은 상속받는 자식 클래스가 하게 된다.
		 * => 메소드 사용시의 일관된 인터페이스 , 통일성을 확보.
		 * => 표준화된 틀을 제공 할 수 있음.
		 * 
		 * 템플릿 메소드
		 * - 추상 메서드나 구현된 메서드를 활용하여 전체기능의 흐름을 정의하는 메서드.
		 * (final 로 선언. 하위클래스에서 재정의 할 수 없게 만듬.)
		 */

	}

}
