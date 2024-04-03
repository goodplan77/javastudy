package com.kh.chap03_wrapper.run;

public class WrapperRun {

	public static void main(String[] args) {
		
		/*
		 * Wrapper 클래스
		 * => 기본 자료형(8개)을 객체로 포장해주는 클래스들.
		 * 기본자료형	<->		Wrapper 클래스
		 * boolean			Boolean
		 * char				Character
		 * byte				Byte
		 * short			Short
		 * int				Integer
		 * long				Long
		 * float			Float
		 * double			Double
		 * 
		 * -> Boxing
		 * <- UnBoxing
		 */
		
		int num1 = 10;
		int num2 = 15;
		
		System.out.println(num1 == num2);
		// System.out.println(num1.equals(num2));
		// 기본 자료형에서 객체 자료형의 메소드를 활용하고 싶다면, Wrapper 클래스로 변환해줘야 한다.
		
		// 자동형변화 기본자료형 => Wrapper (Boxing)
		Integer i1 = num1;
		Integer i2 = num1;
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.hashCode());
		System.out.println(i1.compareTo(i2)); // 10 15
		// a.compareTo(b) : 두 값을 비교해서 a가 크면 1 , b가 크면 -1 , 같다면 0
		
		// Wrapper 클래스 => 기본자료형 (UnBoxing)
		int num3 = i1;
		int num4 = i2;
		
		// 기본자료형 <-> String
		
		String str1 = "10";
		String str2 = "15.3";
		
		System.out.println(str1+str2); // 1015.3
		
		// 1.	String -> 기본자료형 : 파싱한다.
		//		바꾸고자 하는 자료형의 Wrapper.parseXXX(변환할문자열);
		int i = Integer.parseInt(str1);
		double d = Double.parseDouble(str2);
		
		System.out.println(i+d); // 25.3
		
		// 2.	기본자료형 -> String
		//		String.valueOf(변환할 기본자료형값)
		//		"" + 기본자료형값
		String strI = String.valueOf(i);
		String strD = String.valueOf(d);
		
		System.out.println(strI+strD); // 1015.3
		
	}

}
