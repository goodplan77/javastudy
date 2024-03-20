package com.kh.operator;

//산술 연산자 (이항 연산자)
// + - <<< * / %
public class A_Arithmetic {
	
	public void method() {
		int num1 = 10; 
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));
		
		double a = 35;
		double b = 10;
		
		System.out.println(a/b);
		System.out.println(a%b);
	}
	
	public void quiz() {
		
		int a = 5;
		int b = 10;
		
		int c = (++a) + b; // c = 16 , a = 6
		int d = c / a; // 2
		int e = c % a; // 4
		
		int f = e++; // f = 4 , e = 5
		int g = (--b) + (d--); // g = 11 , b = 9 , d = 1
		int h = 2;
		int i = (a++) + b / (--c / f) * ((g--) - d) % ((++e) + h);
		
		// 6 + 9 / 3 * 2
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		System.out.println("e : " + e);
		System.out.println("f : " + f);
		System.out.println("g : " + g);
		System.out.println("h : " + h);
		System.out.println("i : " + i);
	}

}
