package com.kh.chap02_lamda.part02_practice;

import com.kh.chap02_lamda.model.function.LamdaTest1;
import com.kh.chap02_lamda.model.function.LamdaTest2;


public class LamdaPractice {
	
	public static void main(String[] args) {
		// 람다식 문법 종류
		// 1. 기본 형태
		LamdaTest1 l1 = (int x , int y) -> {return x+y;};
		
		// 2. 매개변수의 자료형 생략
		l1 = (x , y) -> {return x+y;};
		
		// 3. 매개변수의 괄호 () 생략 : 매개변수가 딱 1개인 경우만 생략 가능
		// l1 = x , y -> {return x+y;};
		LamdaTest2 l2 = x-> {System.out.println(x);};
		l2.print("asdf");
		
		// 4. 중괄호 생략하기 : 실행할 코드가 딱 한문장 일 경우 생략가능.
		l1 = (x,y) -> /* return */ x+y; // 호출되는 코드가 return 값 뿐인 경우 return 생략 가능.
		l2 = x -> System.out.println(x); // 애초에 return 없다면 중괄호 바로 생략 가능.
		
		// l2 = System.out::println; 메소드 참조
		
		/*
		 * -	람다식의 간소화 문법은 필수로 사용해야 하는 것은 아니나 사용자의 취향에 따라 모두 자주 사용되는
		 * 		간결한 표현방법이기 때문에 사용방법에 대한 연습이 필요함.
		 * -	람다식을 사용 할 수 있는 위치는 return 뒤에 반환 값으로 사용하거나 , 혹은 함수형 인터페이스 변수의
		 * 		값으로 대입 될 때 사용 가능하다.
		 * 		(각 위치는 원래 대로 라면 함수형 인터페이스의 객체의 주소값이 들어 가야하는 공간이고 , 람다식은 익명
		 * 		내부 클래스의 변형체 이기 때문에 익명 내부 클래스가 들어 갈 수 있는 공간에서 사용 가능하다.)
		 * 
		 * -	람다식을 사용하면 OOP 에서도 함수를 마치 값 처럼 주고 받는 행위가 가능하다. (단 실제는 익명 객체로 구현함)
		 */
	}
	
	/*
	 * 각 람다식을 가장 간결한 형태로 표현하기
	 */
	/*
	각 람다식을 가장 간결한 형태로 표현하기
	1. ((int x) -> { return (x * x); }); 
		x -> x*x;
	2. (String str) -> { return (str.length()); };
		str -> str.length();
	3.  (int x) -> { System.out.println(x); return x; };
		x -> { System.out.println(x); return x; };
	4. (String str) -> { return (str.toUpperCase()); };
		str -> str.toUpperCase();
	5. (int x , int y) -> { return (x * y); };
		(x,y) -> x*y;
	6. ((int x , int y) -> { return (x % y == 0); });
		(x,y) -> (x % y == 0);
	7. (int x , String str1) -> { return (str1 + x); };
		(x , str1) -> str1 + x;
	8. ((int x , String str1) -> { System.out.println(x + str1); });
		(x , str1) -> System.out.println(x + str1);
	9. (int[] arr) -> { return (Math.max(Math.max(arr[0], arr[1]), arr[2])); };
		arr -> Math.max(Math.max(arr[0], arr[1]), arr[2]);
	10. ((String str1, String str2) -> { String result =  (str1.concat(str2)); return result; });
		(str1 , str2) -> (str1.concat(str2));
	*/
}
