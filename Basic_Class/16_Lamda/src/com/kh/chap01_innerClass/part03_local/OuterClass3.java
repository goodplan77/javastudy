package com.kh.chap01_innerClass.part03_local;

public class OuterClass3 {
	
	/*
	 * 3) 지역 내부 클래스
	 * -	지역 변수 처럼 메서드 내부에서 클래스를 정의하여 사용 하는것
	 * -	이렇게 생성한 클래스는 메서드 안에서만 사용가능하며 메서드가 호출 되는 시점에 생성됨.
	 * -	지역 내부 클래스 안에서 지역 변수는 상수 처럼 취급 된다.
	 * 
	 * ??
	 * 1)	메소드 호출시 메모리 영역중 Stack 영역에 쌓이고 , 메소드 안에 지역 변수들을 위한 저장곤간이 할당됨.
	 * 		메소드가 종료되면 메소드 안에 부여되어있던 메모리들을 전부 회수함. Stack 안에 메서드에 대한 메모리 공간이 지워짐.
	 * 		스택에 쌓이는 메서드 == 스택프레임 (매개변수 , 지역변수 , 반환되는 위치 값 정보 등등이 있음)
	 * 
	 * 2)	static 키워드가 붙은 필드는 static 메모리 영역에 별도의 저장공간을 할당받는다.
	 * 		static final(상수) 키워드가 붙은 필드는 ? static 메모리 영역 안에서 상수풀(상수값만 모아두는곳) 에 저장공간할당
	 * 		final 키워드가 붙은 필드 ? static 메모리 영역중 상수메모리에 저장공간을 할당받음. -> 상수메모리 내부에 상수풀 존재
	 */
	
	private String outerStr = "외부 클래스 필드";
	private static String staticOuterStr =  "외부 클래스 스태틱변수";
	
	public Runnable getRunnable(int num) {
		int local = 1; // 지역변수
		// local = 2;
		
		// 지역 내부 클래스 . 지역변수와 동일한 생명주기를 가졌다.
		class LocalInner implements Runnable{
			int localInnerNum = 10;

			@Override
			public void run() {
				// local = 3;
				// 지역 내부 클래스에서 지역 변수 사용은 가능. 단 상수로 취급함
				System.out.println(local); // 메서드 내부에서 생성된 지역 변수 -> 호출 종료시 원래는 값이 없어짐
				System.out.println(num); // 메서드 에서 매개변수로 받아온 변수 -> 지역 변수와 동일 취급 -> 호출 종료시 원래는 값이 없어짐
				System.out.println(localInnerNum); // 
				System.out.println(outerStr); // 외부 클래스 생성후 사용 가능
				System.out.println(staticOuterStr); // 외부 클래스 생성 상관 없이
			}
			
		}
		
		return new LocalInner(); // Heap 영역으로 이동
	}
}
