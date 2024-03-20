package com.kh.variable;

public class A_Variable {
	
	// 근무일수 X 시급 = 월급 계산 하는 프로그램
	
	public void printVariable() {
		System.out.println("=== 변수 사용 전 ===");
		System.out.println("시급 : 18500");
		System.out.println("근무시간 : 6");
		System.out.println("근무일수 : 20");
		
		// 월급 = 시급 X 근무시간 X 근무일수
		
		System.out.println("월급 : " + (18500 * 6 * 20) + "원 입니다.");
		
		
		System.out.println("=== 변수 사용 후 ===");
		
		int pay = 18500; //4byte
		int hour = 6; //4byte
		int day = 20; //4byte
		
		System.out.println("월급 : " + (pay * hour * day) + "원 입니다.");
		
		/*
		 * 변수 사용 이유
		 * 1. 값에 의미 부여 -> 가독성 증가
		 * 2. 필요할 때 마다 재사용 -> 생산성 증가
		 * 3. 유지보수 용이
		 */
	}
	
	// 변수 선언
	
	public void declareVariable() {
		
		/*
		변수 선언 = 메모리에 저장 공간 확보
		자료형 변수명 = 값;
		자료형: 어떠한 값 ,크기를 담아 낼 것인가?
		변수명 : 변수의 이름을 직관적으로 정하는 부분
		
		선언시 주의 사항
		1. 소문자로 시작
			ex) String user;
			ex) String userName; (관례. 낙타표기법)
		2. 같은 영역에서 동일 변수명 X
		3. 해당영역에서만 사용
		
		*/
		
		// 1. 논리형 변수 (1byte) , true/false
		boolean isTrue;
		
		// 2. 정수형
		// 2_1. 정수형
		byte bNum; //1byte (-128 ~ 127)
		short sNum; //2byte (-32768 ~ -32767)
		int iNum; //4byte (약 -21억 ~ +21억) => 정수형 대표 자료형
		long lNum; //8byte
		
		// 2_2. 실수형
		float fNum; //4byte => 소수점 아래 7자리까지
		double dNum; //8byte => 소수점 아래 15자리까지 => 정확한 값 저장 => 실수형 대표 자료형
		
		// 3. 문자형
		char ch; //2byte. 유니코드표 (0 ~ 65535)
		
		// 4. 문자열. 참조자료형
		String str;
		
		// 값 대입
		// [표현식] 변수명 = 값; (대입 연산자)
		
		isTrue = true;
		bNum = 127;
		sNum = 32767;
		iNum = 12654654;
		lNum = 8L;
		
		fNum = 1.789654f;
		dNum = 1.6549687;
		
		ch = 'A';
		str = "abc";
	}
	
	public void initVariable() {
		// 변수 선언과 동시에 값을 대입함 -> 초기화
		boolean isTrue = true;
		int longInteger = 999_999_999;
		
		int age = 20;
		age = 21;
		
		final int AGE = 20;
		// AGE = 21;
	}

}
