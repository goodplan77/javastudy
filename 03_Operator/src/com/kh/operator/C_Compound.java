package com.kh.operator;

public class C_Compound {
	/*
	 * 복합대입 연산자 : 산술연산자 , 대입연산자를 함께 사용하는 연산자 += , -= , *= , /= , %=
	 * 
	 * a += 3 -> a = a + 3
	 */

	public void method() {
		int num = 12;
		num += 3; // num = 15
		num -= 5; // num = 10
		num *= 6; // num = 60
		num /= 2; // num = 30
		num %= 4; // num = 2
		
		//문자열 접합 가능
		String str = "Hello ";
		str += "World!";
	}

}
