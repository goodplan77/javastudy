package com.kh.chap02_objectArray.run;

import java.util.Arrays;

import com.kh.chap02_objectArray.model.vo.Phone;

public class Run {

	public static void main(String[] args) {
		Phone[] arr = new Phone[3];

		// System.out.println(Arrays.toString(arr));

		arr[0] = new Phone();
		arr[1] = new Phone("갤럭시S", "10", "삼성", 1200000);
		arr[2] = new Phone("갤럭시z플립", "4", "삼성", 1400000);

		arr[0].setName("아이폰");
		arr[0].setBrand("애플");
		arr[0].setSeries("14");
		arr[0].setPrice(1000000);

		// System.out.println(Arrays.toString(arr));

		// 핸드폰 배열의 길이만큼 번복하면서
		// 반복중인 핸드폰의 정보를 출력하고
		// 핸드폰들의 가격의 총합과 평균 가격을 계산해서 출력하시오.

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
			sum += arr[i].getPrice();
		}

		System.out.println("가격 총합 : " + sum);
		System.out.println("가격 평균 : " + sum / arr.length);

		/*
		 * 향상된 for문 기존 : for(초기식;조건식;증감식)
		 * 
		 * for each문(향상된 반복문)
		 * - 배열 또는 컬렉션에 사용됨
		 * - 배열 또는 컬렉션의 0번 인덱스 부터 마지막 인덱스 까지 순차적으로
		 * 접근하는 것이 목적일 때
		 * 
		 * - 초기식 , 조건식 , 증감식이 없음
		 * - 반복하는 횟수는 배열이나 컬렉션의 크기에 의해 정해진다.
		 * 
		 * for(인덱스의 담긴 값을 저장할 변수 선언 : 배열변수명) {반복적으로 실행할 내용}
		 */

		System.out.println("=====================");
		int total = 0;
		for (Phone p : arr) {
			total += p.getPrice();
		}
		
		System.out.println("가격 총합 : " + total);
	}

}
