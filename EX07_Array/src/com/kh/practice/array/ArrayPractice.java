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
						array[i] = i + 1;
					} else {
						array[i] = input - i;
					}
				}

				for (int i = 0; i < input; i++) {
					System.out.printf("%d", array[i]);
					if (i != input - 1) {
						System.out.print(", ");
					}
				}
				System.out.println();
				break;
			}
		}
	}

	public void practice9() {
		String[] chicken = new String[4];
		chicken[0] = "후라이드";
		chicken[1] = "양념";
		chicken[2] = "간장";
		chicken[3] = "눈꽃";

		System.out.print("치킨 이름을 입력하세요. : ");
		String input = sc.nextLine();

		boolean isTrue = false;

		for (int i = 0; i < chicken.length; i++) {
			if (chicken[i].equals(input)) {
				System.out.printf("%s치킨 배달 가능\n", input);
				isTrue = true;
				break;
			}
		}

		if (isTrue == false) {
			System.out.printf("%s치킨은 없는 메뉴 입니다.\n", input);
		}
	}

	public void practice10() {
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();

		char[] inputArray = new char[input.length()];

		for (int i = 0; i < input.length(); i++) {
			inputArray[i] = input.charAt(i);
		}

		for (int i = 0; i < input.length(); i++) {
			if (i <= 7) {
				System.out.printf("%c", inputArray[i]);
			} else {
				System.out.print("*");
			}
		}
	}

	public void practice11() {
		int[] number = new int[10];
		for (int i = 0; i < 10; i++) {
			number[i] = (int) (Math.random() * 10 + 1);
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", number[i]);
		}
	}

	public void practice12() {
		int[] number = new int[10];
		int max = 0;
		int min = 0;

		for (int i = 0; i < 10; i++) {
			number[i] = (int) (Math.random() * 10 + 1);

			if (i == 0) {
				max = number[i];
				min = number[i];
			}

			if (max < number[i])
				max = number[i];
			if (min > number[i])
				max = number[i];
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", number[i]);
		}

		System.out.printf("\n최대값 : %d", max);
		System.out.printf("\n최소값 : %d", min);
	}

	public void practice13() {
		int[] number = new int[10];
		for (int i = 0; i < 10; i++) {
			number[i] = (int) (Math.random() * 10 + 1);

			for (int j = 0; j < i; j++) {
				if (number[i] == number[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", number[i]);
		}
	}

	public void practice14() {
		int[] number = new int[6];
		for (int i = 0; i < 6; i++) {
			number[i] = (int) (Math.random() * 45 + 1);

			for (int j = 0; j < i; j++) {
				if (number[i] == number[j]) {
					i--;
					break;
				}
			}

			for (int k = 0; k < i; k++) {
				if (number[k] > number[i]) {
					int temp = number[i];
					number[i] = number[k];
					number[k] = temp;
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", number[i]);
		}
	}

	public void practice15() {
		System.out.print("문자열 : ");
		String str = sc.nextLine();

		int arrayLength = 0;

		System.out.print("문자열에 있는 문자 : ");

		for (int i = 0; i < str.length(); i++) {

			boolean isDup = false;

			for (int j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					isDup = true;
					break;
				}
			}

			if (!isDup) {
				System.out.printf("%c ", str.charAt(i));
				arrayLength++;
			}
		}

		System.out.printf("\n문자 개수 : %d\n", arrayLength);

	}

	public void practice16() {

		int count = 0;

		System.out.print("배열의 크기를 입력하세요 : ");
		int input = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[input];
		String output = "";
		for (int i = 0; i < input; i++) {
			System.out.print((i + 1) + "번째 문자열 : ");
			strs[i] = sc.nextLine();
		}
		
		for(int j = 0 ; j < input ; j++) {
			if(j == input-1) {
				output = output + strs[j];
			} else {
				output = output + strs[j] + ", ";
			}
		}
		
		count += input;

		while (true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char select = sc.nextLine().charAt(0);

			if (select == 'y' || select == 'Y') {
				output = output + ", "; 
				System.out.print("더 입력하고 싶은 개수 : ");
				input = sc.nextInt();
				sc.nextLine();

				strs = new String[input];
				for (int i = 0; i < input; i++) {
					System.out.print((count + (i+1)) + "번째 문자열 : ");
					strs[i] = sc.nextLine();
				}
				
				for(int j = 0 ; j < input ; j++) {
					if(j == input-1) {
						output = output + strs[j];
					} else {
						output = output + strs[j] + ", ";
					}
				}
				
				count += input;

				continue;

			} else if (select == 'n' || select == 'N') {
				System.out.println("[" + output + "]");
				break;

			} else {
				System.out.println("에러");
			}
		}

	}

}
