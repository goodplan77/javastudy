package com.kh.practice.array;

import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);

	public void practice1() {

		int[] number = new int[10];

		for (int i = 0; i < 10; i++) {
			number[i] = i + 1;
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", number[i]);
		}
	}

	public void practice2() {

		int[] number = new int[10];

		for (int i = 0; i < 10; i++) {
			number[i] = number.length - i;
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", number[i]);
		}
	}

	public void practice3() {

		System.out.print("양의 정수 : ");
		int input = sc.nextInt();

		int[] number = new int[input];

		for (int i = 0; i < input; i++) {
			number[i] = i + 1;
		}

		for (int i = 0; i < input; i++) {
			System.out.printf("%d ", number[i]);
		}
	}

	public void practice4() {
		String[] fruits = new String[5];
		fruits[0] = "사과";
		fruits[1] = "귤";
		fruits[2] = "포도";
		fruits[3] = "복숭아";
		fruits[4] = "참외";
		System.out.println(fruits[1]);
	}

	public void practice5() {

		System.out.print("문자열 : ");
		String str = sc.nextLine();

		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);

		char[] charArray = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			charArray[i] = str.charAt(i);
		}

		int count = 0;
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ", str, ch);
		for (int i = 0; i < str.length(); i++) {
			if (charArray[i] == ch) {
				System.out.printf("%d ", i);
				count++;
			}
		}

		System.out.printf("\n%c 개수 : %d\n", ch, count);
	}

	public void practice6() {
		String[] days = new String[7];
		days[0] = "월";
		days[1] = "화";
		days[2] = "수";
		days[3] = "목";
		days[4] = "금";
		days[5] = "토";
		days[6] = "일";

		System.out.print("0~6 사이 숫자 입력 : ");
		int select = sc.nextInt();

		if (select < 0 || select > 6) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			System.out.println(days[select] + "요일");
		}
	}

	public void practice7() {
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] array = new int[input];

		for (int i = 0; i < input; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			array[i] = sc.nextInt();
		}

		int sum = 0;

		for (int i = 0; i < input; i++) {
			System.out.printf("%d ", array[i]);
			sum += array[i];
		}
		System.out.println();
		System.out.println("총 합 : " + sum);
	}

	public void practice8() {

		while (true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if (input < 3 || input % 2 == 0) {
				System.out.println("다시 입력하세요.");
			} else {
				int[] array = new int[input];
				for (int i = 0; i < input; i++) {
					if (i <= input / 2) {
						array[i] = i;
					} else {
						
					}
				}

				for (int i = 0; i < input; i++) {
					System.out.printf("%d, ", array[i]);
				}
				System.out.println();
				break;
			}
		}
	}
}
