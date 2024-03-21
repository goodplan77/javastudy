package com.kh.operator;

public class D_LogicalNegation {
	/*
	 * 논리 부정 연산자 ! (단항 연산자)
	 * 
	 * 논리값을 반대로 바꿔줄때 사용함
	 * 
	 * !논리값 
	 */
	
	public void method() {
		System.out.println("true의 부정 : " + !true);
		System.out.println("false의 부정 : " + !false);
		
		boolean b = true;
		boolean b2 = !b;
		
		// true 나 false 값이 반환되는 계산식에 자주 사용됨
		
		boolean b3 = !(5<3);
	}

}
