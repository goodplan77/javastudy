package com.kh.array;

import java.util.Scanner;

public class A_Array {

	/*
	 * 변수 : 하나의 공간에 하나의 값을 담을 수 있음. 배열 : 하나의 공간에 같은 자료형의 값을 여러개 담을 수 있음 -> (배열의
	 * 각인덱스자리에 실제 값들을 한개씩 담을 수 있음) (인덱스는 무조건 0부터 시작함) EX) int[] arr = new int[3]; //
	 * int 자료형이 들어 갈수 있는 3개 크기의 배열. 인덱스는 0,1,2 까지만!
	 */
	
	Scanner sc = new Scanner(System.in);

	public void method1() {
		int num1 = 0;
		int num2 = 1;
		int num3 = 2;
		int num4 = 3;
		int num5 = 4;
		// 각각의 값을 별도의 변수로 나눠서 저장 하는 경우

		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);

		/*
		 * 배열을 가지고 정수값들을 관리? 1. 배열 선언 자료형[] 배열명 = new 자료형[배열 크기]; 자료형 배열명 [];
		 * 
		 * int a; 변수선언 int[] a; 배열선언 int a[];
		 * 
		 * 2. 배열 할당 선언된 배열에 몇개의 값들을 보관 할것인지. 크기 저장 과정. a = new 자료형[배열 크기];
		 * 
		 * int[] arr = new int[5]; // 0 1 2 3 4
		 * 
		 * 
		 * 장점 : 반복문 사용 가능
		 */

		int[] arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}

	public void method2() {
		int[] arr; // stack
		arr = new int[3];
		// new 키워드가 붙은 배열은 항상 heap 영역 안에 생성
		// heap 영역안에 크기 3짜리 저장공간이 할당 + 고유 주소값 생성
		// 생성된 주소값을 arr에 저장

		// 단 , heap 메모리 영역안에서 빈값은 존재할수 없음. 따라서 JVM은 생성된 각 저장공간에 자료형에 맞는 기본값을 넣은 상태로 생성
		// 시킴.

		System.out.println("arr : " + arr);
		System.out.println("arr의 0번 인덱스에 들어가 있는 값 " + arr[0]);
		// 해시 코드 : 주소 값을 10진수 형태로 변환
		System.out.println("arr의 십진수 : " + arr.hashCode());

		// 기본 값 확인

		double[] dArr = new double[2];

		String[] sArr = new String[3];

		char[] cArr = new char[2];

		System.out.println("dArr : " + dArr[0]);
		System.out.println("sArr : " + sArr[0]);
		System.out.println("cArr : " + cArr[0]);

		/*
		 * 기본자료형 (boolean , char , byte , short , int , long , float , double) ->
		 * 실제값(리터럴)을 바로 담을 수 있는 변수 => 일반 변수
		 * 
		 * 그 외 자료형(String , Scanner , int[] , double[] ...) -> 주소값을 담고 있는 변수 => 참조변수.
		 * 레퍼런스 변수 => 주소 값을 통해 heap 메모리 영역안에 생성된 주소로 접근 할 수 있다.
		 */
	}

	public void method3() {
		int[] iArr = new int[3]; // 0 1 2
		for (int i = 0; i < 3; i++) {
			System.out.println(iArr[i]);
		}

		/*
		 * for(int i = 0 ; i < 4 ; i++) { System.out.println(iArr[i]); }
		 */

		// 배열의 크기를 얻어오는 방법.
		System.out.println("iArr배열의 크기 : " + iArr.length);
		for (int i = 0; i < iArr.length; i++) {
			//x번째 인덱스에 들어가 있는 값 : x
			System.out.printf("%d번째 인덱스에 들어가 있는 값: %d\n",i,iArr[i]);
		}
	}
	
	public void method4() {
		int [] arr = new int[5];
		/*
		 * arr[0]=1;
		 * arr[1]=2;
		 * arr[2]=3;
		 * arr[3]=4;
		 * arr[4]=5;
		 * 
		 */
		
		for(int i = 0 ; i <arr.length ; i++) {
			arr[i] = 2*(i+1);
		}
		
		for(int i = 0 ; i <arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
		// ArrayIndexOutofBoundException : 배열 크기 초과 진입시?
		
		/*
		 * 단점 : 한번 지정한 크기는 변경이 불가능.
		 * => 배열의 크기를 변경하고자 한다면 새로운 배열을 다시 생성 해야함
		 */
		
		System.out.println("이전 주소값 : " + arr.hashCode());
		arr = new int[7];
		
		/*
		 * 기존에 참조하고 있던 주소값은 heap 영역 내부를 점유하다가, 일정시간이 지나면 가비지 컬렉터(GC) 가 삭제 시켜준다. : 자동 메모리 관리
		 */
		System.out.println("arr 변경후 ::::");
		System.out.println("변경후 주소값 : " + arr.hashCode());
		
		System.out.println(arr[0]); // 이전 데이터 유지 X
		
		//현재 연결고리를 강제로 끊고자 한다면?
		arr = null;
		
		System.out.println(arr); // null 값을 가지고 있는 건 문제 X
		System.out.println(arr.hashCode()); // null값을 가진 상태에서 함수호출 , 특정 인덱스 접근시 오류 발생
	}
	
	public void method5() {
		int[] arr = new int[4];
		
		// 배열 선언 -> 초기화 한번에 하기
		
		// 방법1
		int [] arr1 = new int[] {1,2,3,4};
		
		// 방법2
		int [] arr2 = {1,2,3,4};
		
		System.out.println(arr1 == arr2);
		// == 주소값과 주소값 끼리의 비교. false 나옴
	}
	
	public void method6() {
		// 사용자에게 문자열 하나 입력 받은 후 , 각 문자들을 char 배열에 옮겨 담기
		
		System.out.print("문자열 하나 입력 : ");
		String str = sc.nextLine();
		char[] array = new char[str.length()];

		for(int i = 0 ; i<str.length() ; i++) {
			array[i] = str.charAt(i);
		}
		
		for(int j = 0 ; j < str.length() ; j++) {
			System.out.println("'" + array[j] + "'");
		}
		
	}
	
	public void method7() {
		// 1. 직접 배열의 길이를 입력한 후 크기 만큼 정수 배열 선언
		// 2. 반복문 활용 하여 0 ~ 마지막 인덱스 까지 순차적으로 값 대입 (랜덤값. 1~100사이)
		// 3. 반복문 활용하여 0 ~ 마지막 인덱스 까지 배열에 담긴 값을 출력
		// 4. 담긴 값이 짝수 인 경우 짝수의 총합 구하기
		
		System.out.print("배열 크기 : ");
		int input = sc.nextInt();
		
		int[] array = new int[input];
		
		for(int i = 0 ; i < input ; i++) {
			array[i] = (int)(Math.random()*100 +1);
		}
		
		int sum = 0;
		for(int j = 0 ; j < input ; j++) {
			if(array[j] % 2 == 0) {
				sum += array[j];
			}
			System.out.printf("%d " , array[j]);
		}
		System.out.printf("\n짝수 총합 : %d" ,sum);
	}

}
