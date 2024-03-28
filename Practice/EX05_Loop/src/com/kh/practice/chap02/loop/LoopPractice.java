package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {

	Scanner sc = new Scanner(System.in);

	public void practice1() {

		while (true) {
			System.out.println("1 이상의 숫자를 입력하세요. :");
			int input = sc.nextInt();

			if (input < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
				continue;
			}

			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}

			break;
		}

	}

	public void practice2() {

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = input; i >= 1; i--) {
				System.out.printf("%d ", i);
			}
		} else {
			System.out.println("1이상의 숫자를 입력해주세요.");
			practice2();
		}

	}

	public void practice3() {

		System.out.print("정수를 하나 입력하세요. : ");
		int input = sc.nextInt();
		int sum = 0;

		for (int i = 1; i <= input; i++) {
			sum += i;
			System.out.print(i + (i != input ? " + " : " = " + sum));
		}
	}

	public void practice4() {

		while (true) {
			System.out.print("첫 번째 숫자 : ");
			int num1 = sc.nextInt();

			System.out.print("두 번째 숫자 : ");
			int num2 = sc.nextInt();

			if (num1 < 1 || num2 < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
				practice4();
				return;
			} else {
				if (num1 > num2) {
					int temp = num1;
					num1 = num2;
					num2 = temp;
				}

				// 삼항 연산자를 이용한 크기 비교
				// int start = num1 < num2 ? num1 : num2
				// int end = num1 > num2 ? num1 : num2

				for (int i = num1; i <= num2; i++) {
					System.out.printf("%d ", i);
				}

				// 위의 예제를 사용 했을 경우
				/*
				 * for (int i = start ; i<=end ; i++) { System.out.printf("%d " , i) }
				 */

				return;
			}

		}
	}

	public void practice5() {
		while (true) {
			System.out.print("숫자 : ");
			int input = sc.nextInt();

			if (input < 2 || input > 9) {
				System.out.println("9 이하의 숫자만 입력해주세요.");
				continue;
			} else {
				for (int i = input; i <= 9; i++) {
					System.out.printf("===== %d단 =====\n", i);
					for (int j = 1; j <= 9; j++) {
						System.out.printf("%d * %d = %d\n", i, j, (i * j));
					}
				}
				break;
			}

		}

	}

	public void practice6() {
		System.out.print("시작 숫자 : ");
		int number = sc.nextInt();

		System.out.print("공차 : ");
		int space = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", (number + (space * i)));
		}

	}

	public void practice7() {

		while (true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			String input = sc.nextLine(); // 입력값이 "exit" 일때를 확인해야함

			if (input.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			char operator = input.charAt(0);

			System.out.print("정수1 : ");
			int num1 = sc.nextInt();

			System.out.print("정수2 : ");
			int num2 = sc.nextInt();

			sc.nextLine();

			int sum = 0;

			if ((operator == '/' || operator == '%') && num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				continue;
			}

			switch (operator) {
			case '+':
				sum = num1 + num2;
				break;
			case '-':
				sum = num1 - num2;
				break;
			case '*':
				sum = num1 * num2;
				break;
			case '/':
				sum = num1 / num2;
				break;
			case '%':
				sum = num1 % num2;
				break;
			default:
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
				continue;
			}

			System.out.printf("%d %c %d = %d\n", num1, operator, num2, sum);
		}
	}

	public void practice8() {

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice9() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			for (int j = input; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 소수 : 1 부터 n 까지로 나누 었을때 나누어 떨어지는 수가 1과 n뿐 인 수
	// EX) n = 6
	// 6의 경우 1~6까지의 수 중에서 , 2 와 3이 나누어 떨어짐 -> 소수 아님

	public void practice10() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();

		if (input < 2) {
			System.out.println("잘못 입력하셨습니다.");
		} else if (input == 2) {
			System.out.println("소수 입니다.");
		} else {
			boolean isPrimeNumber = true;
			for (int i = 2; i < input; i++) {
				if (input % i == 0) {
					isPrimeNumber = false;
					break;
				}
			}

			if (isPrimeNumber == true)
				System.out.println("소수 입니다.");
			else
				System.out.println("소수가 아닙니다.");

		}
	}

	public void practice11() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();

		if (input < 2) {
			System.out.println("잘못 입력하셨습니다.");
		} else {

			int count = 0;

			for (int i = 2; i <= input; i++) {

				boolean isPrimeNumber = true;

				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						isPrimeNumber = false;
						break;
					}
				}

				if (isPrimeNumber == true) {
					System.out.printf("%d ", i);
					count++;
				}
			}

			System.out.printf("\n2부터 %d까지 소수의 개수는 %d입니다.\n", input, count);
		}
	}

	public void practice12() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int count = 0;

		for (int i = 1; i <= input; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.printf("%d ", i);
				if (i % 2 == 0 && i % 3 == 0)
					count++;
			}
		}

		System.out.println();
		System.out.println("count : " + count);
	}

}
