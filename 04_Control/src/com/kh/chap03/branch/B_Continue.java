package com.kh.chap03.branch;

public class B_Continue {
	/*
	 * continue : 반복문 안에서 사용하는 구문 , continue을 만나면 실행하지 않고 가장 가까운 반복문으로 돌아간다.
	 */

	public void method1() {
		// 1 3 5 7 9 홀수 출력
		// 방법 1) 증감식을 2씩 증가하게

		// 방법 2) 1~10까지 순차적으로 돌리고 홀수만 출력
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				continue; // 짝수 일 경우 뒤쪽 내용은 무시하고 다음 증감식으로 이동
			}
			System.out.print(i + " ");
		}
	}

	public void method2() {
		// 1부터 100까지의 총 합계
		// 6의 배수 값을 뺴고 더해주기

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 6 == 0)
				continue;
			sum += i;
		}

		System.out.println("총 합계 : " + sum);
	}

	public void method3() {
		// 2~9단 구구단 출력
		// 4의 배수단을 빼고 출력

		for (int i = 2; i <= 9; i++) {
			if (i % 4 == 0)
				continue;
			System.out.printf("--- %d단 ---\n", i);
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%d X %d = %d\n", i, j, (i * j));
			}
		}
	}

	public static void main(String[] args) {
		B_Continue bc = new B_Continue();
		bc.method3();
	}
}
