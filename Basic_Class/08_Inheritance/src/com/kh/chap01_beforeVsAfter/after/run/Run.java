package com.kh.chap01_beforeVsAfter.after.run;

import com.kh.chap01_beforeVsAfter.before.model.vo.*;


public class Run {

	public static void main(String[] args) {
		// Desktop
		Desktop d = new Desktop("삼성", "d-01", "삼성 데스크탑", 2000000, true);

		// SmartPhone
		SmartPhone s = new SmartPhone("애플", "S-01", "아이폰", 1300000, "LGU+");

		// TV
		TV t = new TV("LG", "t-01", "울트라씬티비", 3500000, 30);

		// 출력

		System.out.println(d);
		System.out.println(s);
		System.out.println(t);
		
		/*
		 * 상속의 장점
		 * - 보다 적은 양의 코드로 새로운 클래스들을 작성 가능
		 * - 중복된 코드를 공통적으로 관리. 새로운 코드를 추가 및 수정시 용이함 => 생산성증가
		 * - 정의해둔 부모 클래스를 통해 좀더 쉽게 클래스의 확장이 가능함
		 * 
		 * 상속의 특징
		 * - 클래스간의 상속은 다중 상속이 불가능하다
		 * - 모든 클래스는 Object 클래스의 후손(자식)
		 * - 모든 클래스는 Object 클래스에 있는 메소드를 쓸 수 있음
		 * -> 기존 메소드가 맞지 않으면 '오버라이딩'을 통해 재 정의가 가능함
		 */

	}

}
