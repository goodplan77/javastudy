package com.kh.chap01_innerClass.part04_anonymous;

public class OuterClass4 {
	
	/*
	 * 4) 익명 내부 클래스
	 * -	이름이 없는 클래스
	 * -	외부클래스 안에서 지역 변수 처럼 사용 되는 내부 클래스
	 * -	지역 내부 클래스 에서 불필요한 코드 작성 부분을 간결화한 사용 방법
	 * -	class 선언과 객체 생성을 합쳐서 표현함
	 * -	메서드의 반환값 으로나 , 매개변수 및 변수에 대입할 값으로써 활용된다.
	 */
	
	public Runnable runner = new Runnable() {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " 실행중");
		}
	};
	
	public Runnable getRunnable(String threadName) {
		
		// new 구현 하고자 하는 자료형 + 익명클래스생성자 + 내부 코드
		return new Runnable() { // 메서드의 반환형으로 익명내부 클래스 추가함.

			@Override
			public void run() {
				// threadName = "asdf"; // 지역 내부 클래스. 상수 값으로 취급
				System.out.println(threadName);
			}
			
		};
	}

}
