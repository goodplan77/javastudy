package com.kh.practice.comp.func;

import java.util.Scanner;

public class UpAndDown {
	
	public void upDown() {
		
		Scanner sc = new Scanner(System.in);
		
		int random = (int)(Math.random()*100 +1);
		int count = 1;
				
		while(true) {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 : ");
			int input = sc.nextInt();
			
			if(input > random) {
				System.out.println("Down!");
				count++;
			} else if (input < random) {
				System.out.println("Up!");
				count++;
			} else {
				System.out.println("정답입니다 !!");
				System.out.printf("%d회만에 맞추셨습니다.\n" , count);
				break;
			}
		}
	}

}
