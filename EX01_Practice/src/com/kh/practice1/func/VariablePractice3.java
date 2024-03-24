package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	
	public void calculate() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : ");
		double num1 = sc.nextDouble();

		System.out.print("세로 : ");
		double num2 = sc.nextDouble();
		
		sc.nextLine();
		
		System.out.println("면적 : " + (num1 * num2));
		System.out.println("면적 : " + (2 * (num1 + num2)));

	}

}
