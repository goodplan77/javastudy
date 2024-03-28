package com.kh.chap02.loop;

public class B_While {

	/*
	 * while문
	 * [표현법]
	 * [초기식;] // 필수가 아님
	 * while(조건식) { // 조건식이 참 인 경우 while 내부의 내용이 실행됨
	 * 반복 실행 코드
	 * [증감식;] // 필수 아님 
	 * }
	 */

	public void method1() {
		// for -> while , while -> for 바꿔서 표현 가능

		int i = 0;
		while (i < 5) {
			System.out.println("아령하세요");
			i++;
		}

		System.out.println(i);
	}

	public void method2() {

		int i = 1;
		while (i < 6) {
			System.out.printf("%d ", i);
			i++;
		}
	}

	public void method3() {
		// 1~10사이의 홀수만 출력
		int i = 1;
		while (i <= 10) {
			if (i % 2 != 0) {
				System.out.printf("%d ", i);
			}
			i++;
		}
	}

	public void method4() {
		// 1부터 랜덤값 까지의 총 합계
		// 랜덤값의 범위 : 1~100
		// while문 형태

		int random = (int) (Math.random() * 100 + 1);
		int sum = 0;
		int i = 1;
		while (i <= random) {
			sum += i;
			i++;
		}
		System.out.println("1부터 " + random + " 까지의 총 합 : " + sum);
	}

	/*
	 * do - while 문 [표현법]
	 * do {
	 * 실행 코드
	 * } while(조건식);
	 * 
	 * 차이점 : 별도의 조건 없이 최초 1회는 무조건 do 영역 내부 무조건 실행
	 * 조건 검사후 참이면 반복 실행 , 거짓이면 반복종료
	 */

	public void method5() {
		int num = 1;
		do {
			System.out.println("안녕");
		} while (num == 0);
	}

}
