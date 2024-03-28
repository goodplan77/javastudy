package com.kh.practice.comp.func;

import java.util.Scanner;

public class CompExample {

	Scanner sc = new Scanner(System.in);

	public void method1() {

		System.out.print("정수 : ");
		int input = sc.nextInt();

		if (input > 0) {
			for (int i = 1; i <= input; i++) {
				if (i % 2 != 0)
					System.out.print("박");
				else
					System.out.print("수");
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}

	}

	public void method2() {

		int input = 0;

		while (input < 1) {
			System.out.print("정수 : ");
			input = sc.nextInt();

			if (input > 0) {
				for (int i = 1; i <= input; i++) {
					if (i % 2 != 0)
						System.out.print("박");
					else
						System.out.print("수");
				}
				break;
			} else {
				System.out.println("양수가 아닙니다.");
			}
		}

	}

	public void method3() {
		System.out.print("문자열 : ");
		String name = sc.nextLine();
		
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int count = 0;
		
		for(int i = 0 ; i<name.length() ; i++) {
			if(ch == name.charAt(i)) {
				count++;
			}
		}
		
		System.out.printf("%s 안에 포함된 %c 개수 : %d\n" , name , ch , count);
		
	
	}

	public void method4() {
		
		char select = 'y';
		
		while(select == 'y' || select == 'Y') {
			System.out.print("문자열 : ");
			String name = sc.nextLine();
			
			System.out.print("문자 : ");
			char ch = sc.nextLine().charAt(0);
			
			int count = 0;
			
			for(int i = 0 ; i<name.length() ; i++) {
				if(ch == name.charAt(i)) {
					count++;
				}
			}
			
			System.out.println("포함된 갯수 : " + count);
			
			while(true) {
				
				System.out.print("더 하시겠습니까? (y/n) : ");
				select = sc.nextLine().charAt(0);
				
				if(select == 'y' || select == 'Y') {
					break;
				} else if (select == 'n' || select == 'N') {
					break;
				} else {
					System.out.println("잘못된 대답입니다. 다시 입력해주세요.");
				}
				
			}
			
		}

	}
}
