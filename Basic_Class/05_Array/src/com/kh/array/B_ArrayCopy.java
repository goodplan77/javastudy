package com.kh.array;

import java.util.Arrays;

public class B_ArrayCopy {
	/*
	 * 배열 복사 1) 얕은 복사 2) 깊은 복사
	 */

	public void method1() {

		// 원본 배열
		int[] origin = { 1, 2, 3, 4, 5 };

		System.out.println("===== 원본 배열 출력 =====");

		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}

		// 1 2 3 4 5

		// 얕은 복사

		int[] copy = origin; // origins 주소값 대입

		System.out.println("\n===== 복사본 배열 출력 =====");

		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}

		System.out.println("\n===== 복사본 배열 수정 =====");

		copy[2] = 99;

		System.out.println("===== 원본 배열 출력 =====");

		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}

		System.out.println("origins 와 copy는 동일 합니까? : " + (origin == copy));
		// 같은 주소값을 공유해서 사용하고 있기 때문에 복사본 배열 수정시 원본배열에도 영향을 끼친다
	}

	public void method2() {

		// 원본 배열
		int[] origin = { 1, 2, 3, 4, 5 };
		int[] copy = new int[origin.length];

		// 1. 깊은 복사 -> 배열 생성 후 직접 복사

		for (int i = 0; i < copy.length; i++) {
			copy[i] = origin[i];
		}

		copy[2] = 9999;

		System.out.println("===== 원본 배열 출력 =====");

		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}

		System.out.println("\n===== 복사본 배열 출력 =====");

		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
	}

	public void method3() {

		// 원본 배열
		int[] origin = { 1, 2, 3, 4, 5 };
		int[] copy = new int[10];

		// 2. System 클래스의 arraycopy 메소드를 활용한 깊은 복사
		// System.arraycopy(원본배열명 , 원본 복사를 시작할 인덱스 , 복사본 배열명 , 복사 배열의 시작 인덱스 , 복사할 갯수)

		System.arraycopy(origin, 0, copy, 0, 5);
		/*
		 * 1) 복사할 원본 origin 의 0번 배열 부터 복사 시작 2) 복사본 copy의 시작점 인덱스는 0번 3) origin의 0번 부터
		 * 5개(인덱스 0~4) 를 복사함
		 */

		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}

		// 잘못된 범위의 인덱스 제시 할 때는 오류 발생

	}

	public void method4() {

		// 원본 배열
		int[] origin = { 1, 2, 3, 4, 5 };

		// 3. Arrays 클래스에서 제공하는 copyOf 메소드를 이용한 복사

		// 복사본 배열 = Arrays.copyof(원본배열명 , 복사할 갯수)
		int[] copy = Arrays.copyOf(origin, 7);

		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}

		System.out.println("\n===============");
		copy(origin, 7);
	}

	/*
	 * 2. System.arraycopy : 몇번 인덱스부터 어느 위치의 인덱스에 복사할건지 직접 지정 가능
	 * 3. Arrays.copyOf : 무조건 원본 0번 인덱스 부터 내가 제시한 갯수만큼 복사가 진행. 제시한 길이가 원본 보다 크면 , 나머지는 0으로 채워짐
	 */

	public void method5() {
		
		// 원본 배열
		int[] origin = { 1, 2, 3, 4, 5 };
		
		// 4. clone 메소드를 통한 복사
		// 복사본 배열 = 원본배열.clone();
		
		int[] copy = origin.clone();
		// 주소값만 다르고 , 원본배열과 완전 동일한 배열을 반환
		
		System.out.println(Arrays.toString(copy));
		//Arrays.toString(배열)
		// => 앞뒤로 [] 붙이고 각 인덱스의 값을 ,을 찍어가면서 보여줌
		
		//toString 함수 구현
		System.out.print("[");
		for(int i = 0 ; i<copy.length;i++) {
			if(i != copy.length-1) {
				System.out.print(copy[i]+",");
			} else {
				System.out.print(copy[i]);
			}
		}

	}

	public void copy(int[] origin, int size) {
		int[] copy = new int[size];

		for (int i = 0; i < origin.length; i++) {
			copy[i] = origin[i];
		}

		for (int i = 0; i < origin.length; i++) {
			System.out.print(copy[i] + "");
		}

	}

}
