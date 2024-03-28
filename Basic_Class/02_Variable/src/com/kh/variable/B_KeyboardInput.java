package com.kh.variable;

import java.util.Scanner;

public class B_KeyboardInput {

	public void inputTest1() {
		
		Scanner sc = new Scanner(System.in);
		// 사용자 입력사항 입력 받기
		// 이름 , 나이 , 키
		
		System.out.println("당신의 이름은 무엇입니까?");
		String name = sc.nextLine();
		
		// nextLine() : 개행이 있을경우 공백에 무관하게 개행이전까지 출력
		// next() : 공백이 있을경우 이전까지 출력
		
		System.out.println("당신의 나이는 몇 살 입니까?");
		int age = sc.nextInt();
		
		System.out.println("당신의 키는 몇 cm 입니까?");
		double height = sc.nextDouble();
		
		sc.nextLine();
		
		System.out.println("당신이 사는 곳은 ?");
		String address = sc.nextLine();
		
		System.out.println(address + "에 사는 키 :" + height + "cm, " + age + "세 " + name + "님 안녕하세요.");
		System.out.println(address.charAt(0));
	}
}
