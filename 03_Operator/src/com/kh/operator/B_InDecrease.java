package com.kh.operator;

public class B_InDecrease {
	
	/*
	 * 증감연산자 (단항 연산자 ++ --)
	 * ++ : 변수에 담긴 값을 1 증가시키는 연산자
	 * -- : 변수에 담긴 값을 1 감소시키는 연산자
	 * 
	 * 전위 연산자 : 선증강 후처리 (++변수)
	 * 후위 연산자 : 선처리 후증강 (변수++)
	 */
	
	public void method1() {
		int num = 10;
		System.out.println("전위연산 전 num : " + num);
		++num;
		System.out.println("1회 수행후 결과 : " + num);
		System.out.println("2회 수행후 결과 : " + (++num));
		System.out.println("3회 수행후 결과 : " + (++num));
		
		System.out.println("최종 결과값 num : " + num);
		System.out.println("========================");
	
		int num2 = 10;
		System.out.println("후위 연산 전 num2 : " + num2);
		num2++;
		System.out.println("1회 수행후 결과 : " + num2);
		System.out.println("2회 수행후 결과 : " + (num2++));
		System.out.println("3회 수행후 결과 : " + (num2++));
		
		System.out.println("최종 결과값 num2 : " + num2);
		System.out.println("========================");

	}
	
	public void method2() {
		int a = 10;
		int b = ++a;
		System.out.printf("a : %d , b : %d\n" , a , b);
		
		int c = 10;
		int d = c++;
		System.out.printf("c : %d , d : %d\n" , c , d);
		
		int num1 = 20;
		int result1 = (num1++) * 3 ;
		System.out.printf("num1 : %d , result1 : %d\n" , num1 , result1);
		
		int e = 10;
		int f = 20;
		int g = 30;
		
		System.out.println(e++);
		System.out.println((++e) + (f++));
		System.out.println((e++) + (--f) + (--g));
	}

}
