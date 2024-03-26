package com.kh.array;

import java.util.Arrays;

public class C_DimensionlArray {

	// 2차원 배열 : 자료형이 같은 일차원 배열 여러개를 하나로 묶은 것.

	public void method1() {

		/*
		 * 2차원 배열 선언 [표현법] 자료형 배열명 [][]; 자료형 [][] 배열명; 자료형 [] 배열명 [];
		 */

		int arr1[][];
		int[][] arr2;
		int[] arr3[];

		/*
		 * 2차원 배열 할당 (크기 저장) 배열명 = new 자료형[2차원배열의 크기][1차원 배열의 크기]
		 */

		arr3 = new int[2][3];
		/*
		 * [0,0,0] [0,0,0]
		 */

		int[][] arr = new int[2][3];
		System.out.println(arr); // 2차원 배열 주소
		System.out.println(arr[0]); // 1차원 배열 주소
		System.out.println(arr[0][0]); // 배열 값

		System.out.println("2차원 배열의 길이(행의 길이) : " + arr.length);
		System.out.println("1차원 배열의 길이(열의 길이) : " + arr[0].length);

		// 외부 반복문 (행반복) ==> 행 == 2차원 배열
		for (int row = 0; row < arr.length; row++) {
			// 내부 반복문 (열반복) ==> 열 == 1차원 배열
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

	public void method2() {
		// 순서대로 1,2,3...15 값을 대입하기
		int[][] arr = new int[3][5];
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = count++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d ", arr[i][j]);
			}
			System.out.println();
		}
	}

	public void method3() {
		int[] iArr = { 1, 2, 3, 4, 5 };

		// 2차원 배열 선언 및 초기화
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	public void method4() {
		/*
		 * 가변 배열
		 * 행(2차원 배열)의 크기는 정해져 있으나 , 열(1차원 배열)의 갯수는 정해지 않은 상태
		 * 행 크기는 생략 불가. 반드시 지정
		 * 열 크기는 생략 가능
		 */
		
		int[][] arr = new int[3][];
		
		System.out.println(arr); //2차원 배열 주소값
		System.out.println(arr[0]); //null
		
		arr[0] = new int[2];
		arr[1] = new int[1];
		arr[2] = new int[3];
		
		int count = 1;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = count++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
				
	}

}
