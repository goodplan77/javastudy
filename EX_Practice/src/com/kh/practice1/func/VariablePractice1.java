package com.kh.practice1.func;
import java.util.Scanner;

public class VariablePractice1 {
	
	public void printInfo() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요. : ");
		String name = sc.nextLine();

		System.out.print("성별을 입력하세요. (남/여): ");
		String gender = sc.nextLine();
		
		System.out.print("나이를 입력하세요. : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("키를 입력하세요. (cm): ");
		double height = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("키 " + height + "인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다");

	}

}
