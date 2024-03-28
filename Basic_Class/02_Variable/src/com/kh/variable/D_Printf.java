package com.kh.variable;

public class D_Printf {
	/*
	 * System.out.println() : 값 출력후 개행 처리
	 * System.out.print() : 값만 출력
	 * 
	 * System.out.printf("출력하고자 하는 형식" , 값) : 출력하고자 하는 형식 
	 * f : format
	 * 형식에 맞춰서 값들을 출력하고 끔
	 * 
	 * %d : 정수
	 * %f : 실수
	 * %c : 문자
	 * %s : 문자열
	 */
	
	public void printfTest() {
		int iNum1 = 10;
		int iNum2 = 20;
		
		System.out.println("iNum1 : " + iNum1 + ", iNum2 : " + iNum2);
		System.out.printf("iNum1 : %d , iNum2 : %d\n" , iNum1 , iNum2);
		System.out.println("11");
		
		System.out.printf("%5d\n" , iNum1);
		//왼쪽 5칸 채우고 출력
		System.out.printf("%-5d\n" , iNum1);
		//오른쪽 5칸 채우고 출력
		
		double dNum = 4.27546789;
		System.out.printf("dNum : %f \n" , dNum);
		// %f: 7번쨰줄에서 반올림 처리

		System.out.printf("dNum : %.1f \n" , dNum);
		// %f: 소수점 아래 2번째 자리에서 반올림 되어 소수점 아래 1번째 까지만 출력
		
		char ch = 'a';
		String str = "hello";
		
		System.out.printf("%c , %s\n" , ch , str);
		System.out.printf("%C , %S\n" , ch , str);
		
		// 포맷의 갯수와 종류 , 변수의 갯수 종류가 일치해야함
				
	}

}
